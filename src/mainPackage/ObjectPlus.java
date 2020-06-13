package mainPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class ObjectPlus implements Serializable {
    private static Map<Class, List<ObjectPlus>> allExtents = new Hashtable<>();

    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();
        if (allExtents.containsKey(theClass)) {
            // jeśli ekstensja tej klasy już istnieje:
            extent = allExtents.get(theClass);
        } else {
            // jeśli ekstensja tej klasy nie istnieje -> stwórz nową:
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void readExtents(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        allExtents = (Hashtable) stream.readObject();
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException{
        if(allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(),allExtents.keySet()));
    }

    public void removeThisObjectFromExtent() throws Exception {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();
        if (allExtents.containsKey(theClass)) {
            // jeśli ekstensja tej klasy już istnieje:
            extent = allExtents.get(theClass);
            extent.remove(this);
        } else {
            throw new Exception("Nie ma żadnychn ekstencji tej klasy!");
        }
    }
}