package mainPackage;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

public class ObjectPlusPlus extends ObjectPlus implements Serializable {

    // wszystkie informacje o połączeniech tego obiektu:
    private Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();
    // Stores information about all parts connected with any objects:
    private static Set<ObjectPlusPlus> allParts = new HashSet<>();

    /**
     * Konstruktor klasy ObjectPlusPlus.
     * Klasa ta dziedziczy po klasie ObjectPlus.
     * Zadaniem głównym tej klasy jest umożliwienie i usprawnienie konstrukcji oraz operacji na asocjacjach.
     */
    public ObjectPlusPlus() {
        super();
    }
    //podstawowa wersja, ale zamiast niej używamy jej przeciążenia, stąd private
    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier,
                         int counter) {
        Map<Object, ObjectPlusPlus> objectLinks;
        // ochrona przed połączeniem zwrotnym
        if (counter < 1) {
            return;
        }
        // znajdz kolekcję z asocjacjami dla roli
        if (links.containsKey(roleName)) {
            // get links
            objectLinks = links.get(roleName);
        } else {
            // no links -> create them
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }
        // Check if there is already the connection
        // If yes, then ignore the creation
        if (!objectLinks.containsKey(qualifier)) {
            // Add a link for the target object
            objectLinks.put(qualifier, targetObject);
            // Add the reverse connection
            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    /**
     * Metoda do tworzenia asocjacji kwalifikowanej między obiektami.
     *
     * @param roleName Nazwa roli po stronie głównego obiektu.
     * @param reverseRoleName Nazwa roli po stronie obiektu wiązanego.
     * @param targetObject Obiekt który jest wiązany.
     * @param qualifier Kwalifikator/pole/index z klasy wiązanej.
     */
    //Do asocjacji kwalifikowanej:
    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) {
        addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    /**
     * Umożliwia tworzenie asocjacji zwykłej.
     *
     * @param roleName Nazwa roli po stronie głównego obiektu.
     * @param reverseRoleName Nazwa roli po stronie obiektu wiązanego.
     * @param targetObject Obiekt który jest wiązany.
     */
    //do asocjacji bez kwalifikatora.:
    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) {
        addLink(roleName, reverseRoleName, targetObject, targetObject);
    }

    /**
     * Do tworzenia asocjacji na zasadzie kompozycji.
     *
     * @param roleName Nazwa roli po stronie głównego obiektu.
     * @param reverseRoleName Nazwa roli po stronie obiektu wiązanego.
     * @param partObject Object który stanie się częścią głównego obiektu.
     * @throws Exception Jeśli obiekt który ma być częścią jest powiązany z innym obiektem w tej relacji.
     */
    //Do kompozycji:
    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception {
        // Check if the part exist somewhere
        if (allParts.contains(partObject)) {
            throw new Exception("Error: the part is already connected to a whole.");
        }
        addLink(roleName, reverseRoleName, partObject);
        // Store adding the object as a part
        allParts.add(partObject);

    }

    /**
     * Zwraca informacje o powiązaniach danego obiektu w ramach danej asocjacji.
     *
     * @param roleName Nazwa asocjacji.
     * @return Tablica obiektów.
     * @throws Exception Jeśli klasa nie istnieje.
     */
    public ObjectPlusPlus[] getLinks(String roleName) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            //No links for the role:
            throw new Exception("Error: no links for the role: "+roleName);
        }
        objectLinks = links.get(roleName);
        return(ObjectPlusPlus[]) objectLinks.values().toArray(new ObjectPlusPlus[0]);
    }

    /**
     * Wyświetla informacje o powiązaniach danego obiektu w ramach danej asocjacji.
     *
     * @param roleName Nazwa asocjacji.
     * @param stream Strumień gdzie mają zostać wypisane informacje.
     * @throws Exception Jeśli klasa nie istnieje.
     */
    public void showLinks(String roleName, PrintStream stream) throws Exception {
        Map<Object,ObjectPlusPlus> objectLinks;
        if(!links.containsKey(roleName)) {
            //no links
            throw new Exception("No links for the role: "+roleName);
        }
        objectLinks = links.get(roleName);
        Collection col = objectLinks.values();
        stream.println("===Klasa "+this.getClass().getSimpleName()+": "+this.toString()+", powiązania:  '"+roleName+"':");

        for(Object obj:col) {
            stream.println("       "+obj);
        }
    }

    /**
     * Metoda zwracająca obiekt docelowy na podstawie kwalifikatora. Wykorzystywana jest tylko w przypadku asocjacji kwalifikowanej.
     *
     * @param roleName Nazwa asocjacji.
     * @param qualifier Index.
     * @return Zwraca obiekt.
     * @throws Exception
     */
    //Metoda zwracająca obiekt docelowy na podstawie kwalifikatora. Wykorzystywana jest tylko w przypadku asocjacji kwalifikowanej.:
    public ObjectPlusPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            throw new Exception("Error: No links for the role: "+roleName);
        }
        objectLinks = links.get(roleName);
        if(!objectLinks.containsKey(qualifier)) {
            //no link for the qualifier
            throw new Exception("No link for the qualifier: "+qualifier);
        }

        return objectLinks.get(qualifier);

    }

    /**
     * Usuwa powiązanie między obiektami. Klasa prywatna.
     * Tak naprawdę używane są jej przesłonięcia.
     *
     */
    private void removeLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter) throws Exception {
        if (counter<1) return;
        Map<Object, ObjectPlusPlus> objectLinks;
        if(!links.containsKey(roleName)) {
            throw new Exception("No links for the role: " + roleName);
        }
        objectLinks = links.get(roleName);
        if (objectLinks.containsKey(qualifier)) {
            objectLinks.remove(qualifier);
            targetObject.removeLink(reverseRoleName, roleName, this, this, counter-1);
        }

        objectLinks.remove(targetObject);
        targetObject.removeLink(reverseRoleName,roleName, this, qualifier, counter-1);

    }

    /**
     * Usuwa powiązanie między obiektami w przypadku asocjacji z kwalifikatorem.
     *
     * @param roleName Nazwa asocjacji.
     * @param reverseRoleName Nazwa asocjacji po drugiej stronie.
     * @param targetObject Obiekt usuwany.
     * @param qualifier Kwalifikator
     * @throws Exception Jeśli któryś z obiektów nie istnieje.
     */
    public void removeLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) throws Exception {
        removeLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    /**
     * Usuwa powiązanie między obiektami w przypadku asocjacji zwykłej.
     *
     * @param roleName Nazwa asocjacji.
     * @param reverseRoleName Nazwa asocjacji po drugiej stronie.
     * @param targetObject Obiekt usuwany.
     * @throws Exception Jeśli któryś z obiektów nie istnieje.
     */
    public void removeLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) throws Exception {
        removeLink(roleName, reverseRoleName, targetObject, targetObject, 2);
    }



}
