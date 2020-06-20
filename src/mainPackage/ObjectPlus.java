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

    /**
     * Konstruktor klasy ObjectPlus.
     * Jest to nadklasa wszystkich klas zawartych w programie.
     * Jej głównym zadaniem jest wspieranie serializacji, tj. trwałości danych
     * oraz operowanie na liście ekstensji danej klasy.
     */
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

    /**
     * Metoda zapisująca wszystkie dane z programu do wybranego strumienia.
     *
     * @param stream Strumień zapisu danych/
     * @throws IOException
     */
    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    /**
     * Metoda odczytująca zapisane uprzednio dane z podanego strumienia.
     *
     * @param stream Strumień odczytu danych.
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void readExtents(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        allExtents = (Hashtable) stream.readObject();
    }

    /**
     * Metoda zwracająca listę ze wszystkimi obiektami danej klasy.
     *
     * @param type Typ szukanej klasy.
     * @param <T>
     * @return Zwraca listę obiektów danej klasy.
     * @throws ClassNotFoundException Jeśli klasa nie istnieje.
     */
    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException{
        if(allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(),allExtents.keySet()));
    }

    /**
     * Metoda usuwająca dany obiekt z ekstensji.
     *
     * @throws Exception
     */
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