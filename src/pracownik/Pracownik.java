package pracownik;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import ogolne.MisjaKosmiczna;
import ogolne.Placowka;

import java.util.ArrayList;

public class Pracownik extends ObjectPlusPlus {
    private String imie;
    private String nazwisko;
    private int nrPracownika;
    private static int najwyzszyNrPracownika=100;
    private String imieOjca;
    private boolean aktualnieWsluzbie;
    private Inzynier inzynier;

    /**
     * Konstruktor klasy pracownik. Konstruktor ten nie jest używany na zewnątrz.
     * Istnieją pozostałe konstruktory które mogą byc używane.
     * Są ich różne rodzaje w zależności od tego jaki zawód bądź zawody ma przypisany pracownik.
     *
     * @param imie Imię pracownika.
     * @param nazwisko Nazwisko pracownika.
     * @param imieOjca Imię ojca.
     */
    protected Pracownik(String imie, String nazwisko, String imieOjca) {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
    }

    /**
     * Konstruktor dla pracownika który jest wyłącznie inżynierem.
     *
     */
    //Pracownik inzynier:
    public Pracownik(String imie, String nazwisko, String imieOjca, int nrUprawnien) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addInzynier(imie,nazwisko,imieOjca, nrUprawnien);
    }

    /**
     * Konstruktor dla pracownika który jest wyłącznie naukowcem.
     *
     * @param tytulNaukowy Tytuł naukowy pracownika-naukowca.
     * @param specjalizacjaNaukowa Specjalizacja pracownika-naukowca.
     */

    //Pracownik naukowiec:
    public Pracownik(String imie, String nazwisko, String imieOjca,
                        SZFM_Enum.tytulNaukowy tytulNaukowy,
                        SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addNaukowiec(imie,nazwisko,imieOjca, specjalizacjaNaukowa, tytulNaukowy);
    }

    /**
     * Konstruktor dla pracownika który jest wyłącznie kosmonautą.
     *
     * @param wynikTestow Wynik testów sprawnościowych pracownika-kosmonauty.
     */

    //Pracownik kosmonauta:
    public Pracownik(String imie, String nazwisko, String imieOjca,
                        SZFM_Enum.wynikTestowSprawnosciowych wynikTestow) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addKosmonauta(imie,nazwisko,imieOjca, wynikTestow);
    }

    /**
     * Konstruktor dla pracownika który jest jednoczenśnie inżynierem oraz kosmonautą.
     *
     * @param wynikTestow Specyfika klasy kosmonauta.
     * @param nrUprawnien Specyfika klasy inżynier.
     */
    //Pracownik kosmonauta-inzynier:
    public Pracownik(String imie, String nazwisko, String imieOjca,
                        SZFM_Enum.wynikTestowSprawnosciowych wynikTestow,
                        int nrUprawnien) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addKosmonauta(imie,nazwisko,imieOjca, wynikTestow);
        this.addInzynier(imie,nazwisko,imieOjca, nrUprawnien);
    }

    /**
     * Konstruktor dla klasy praconika który jest jednocześnie kosmonautą i naukowcem.
     *
     * @param wynikTestow Specyfika klasy kosmonauta.
     * @param tytulNaukowy Specyfika klasy naukowiec.
     * @param specjalizacjaNaukowa Specyfika klasy naukowiec.
     * @throws Exception
     */
    //Pracownik kosmonauta-naukowiec:
    public Pracownik(String imie, String nazwisko, String imieOjca,
                        SZFM_Enum.wynikTestowSprawnosciowych wynikTestow,
                        SZFM_Enum.tytulNaukowy tytulNaukowy,
                        SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addKosmonauta(imie,nazwisko,imieOjca, wynikTestow);
        this.addNaukowiec(imie,nazwisko,imieOjca, specjalizacjaNaukowa, tytulNaukowy);
    }

    /**
     * Konstruktor dla klasy pracownik w przypadku gdy pracownik jest jednocześnie naukowcem i inżynierem.
     *
     * @param nrUprawnien Specyfika klasy inżynier.
     * @param tytulNaukowy Specyfika klasy naukowiec.
     * @param specjalizacjaNaukowa Specyfika klasy naukowiec.
     * @throws Exception
     */
    //Pracownik naukowiec-inzynier:
    public Pracownik(String imie, String nazwisko, String imieOjca,
                        int nrUprawnien, SZFM_Enum.tytulNaukowy tytulNaukowy,
                        SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addInzynier(imie,nazwisko,imieOjca, nrUprawnien);
        this.addNaukowiec(imie,nazwisko,imieOjca, specjalizacjaNaukowa, tytulNaukowy);
    }

    /**
     * Konstruktor dla pracownika który ma wszystkie uprawnienia.
     * Jest jednocześnie kosmonautą, naukowcem i inżynierem.
     *
     * @param nrUprawnien Specyfika klasy inżynier.
     * @param tytulNaukowy Specyfika klasy naukowiec.
     * @param specjalizacjaNaukowa Specyfika klasy naukowiec.
     * @param wynikTestow Specyfika klasy kosmonauta.
     * @throws Exception
     */

    //Pracownik naukowiec-inzynier-kosmonauta (czyli legendarny koksu):
    public Pracownik(String imie, String nazwisko, String imieOjca,
                        int nrUprawnien, SZFM_Enum.tytulNaukowy tytulNaukowy,
                        SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa,
                        SZFM_Enum.wynikTestowSprawnosciowych wynikTestow) throws Exception {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
        this.addInzynier(imie,nazwisko,imieOjca, nrUprawnien);
        this.addNaukowiec(imie,nazwisko,imieOjca, specjalizacjaNaukowa, tytulNaukowy);
        this.addKosmonauta(imie,nazwisko,imieOjca, wynikTestow);
    }

    /**
     * Metoda prywatna do dodawania specyfiki naukowca do klasy pracownik.
     */
    private void addNaukowiec(String imie, String nazwisko, String imieOjca,
                              SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa,
                         SZFM_Enum.tytulNaukowy tytulNaukowy) throws Exception {
        Naukowiec naukowiec = new Naukowiec(imie,nazwisko, imieOjca, specjalizacjaNaukowa,tytulNaukowy );
        this.addPart(SZFM_Enum.asocjacjaKompozycjaPracownik.pracownik.toString(),
                SZFM_Enum.asocjacjaKompozycjaPracownik.posiada_naukowca.toString(), naukowiec);

    }

    /**
     * Metoda prywatna do dodawania specyfiki kosmonauty do klasy pracownik.
     */
    private void addKosmonauta(String imie, String nazwisko, String imieOjca,
                               SZFM_Enum.wynikTestowSprawnosciowych wynikTestow) throws Exception {
        Kosmonauta kosmonauta = new Kosmonauta(imie, nazwisko, imieOjca, wynikTestow);
        this.addPart(SZFM_Enum.asocjacjaKompozycjaPracownik.pracownik.toString(),
                SZFM_Enum.asocjacjaKompozycjaPracownik.posiada_kosmonaute.toString(),
                kosmonauta);
    }
    /**
     * Metoda prywatna do dodawania specyfiki inżyniera do klasy pracownik.
     */
    private void addInzynier(String imie, String nazwisko, String imieOjca,
                             int nrUprawnien) throws Exception {

        this.inzynier = new Inzynier(imie,nazwisko,imieOjca,nrUprawnien);
        this.addPart(SZFM_Enum.asocjacjaKompozycjaPracownik.pracownik.toString(),
                SZFM_Enum.asocjacjaKompozycjaPracownik.posiada_inzyniera.toString(),
                this.inzynier);
    }

    /**
     * Wyszukuje pracwonika.
     *
     * @param nrPracownika Nr szukanego pracownika.
     * @return Zwraca znalezionego pracownika.
     * @throws Exception Jeśli nie znaleziono pracownika.
     */
    public static Pracownik znajdzPracownika(int nrPracownika) throws Exception {

            Pracownik znalezionyPracowniik = null;
            for(Pracownik placowka: Pracownik.getExtent(Pracownik.class)){
                if(placowka.getNrPracownika() == nrPracownika){
                    znalezionyPracowniik = placowka;
                    return  znalezionyPracowniik;
                }
            }
            throw  new Exception("Nie znaleziono pracownika o numerze "+nrPracownika);
        }

    @Override
    public String toString() {
        return "Pracownik: " +
                "'" + imie + '\'' +
                ", '" + nazwisko + '\'' +
                ", nr pracownika: " + nrPracownika;
    }

    /**
     * Sprawdza czy dany pracownik jest inżynierem.
     *
     * @return Zwraca klasę inżyniera jeśli pracownik nim jest.
     * @throws Exception Jeśli pracownik nie jest inżynierem.
     */
    public Inzynier getInzynier() throws Exception {
        if(inzynier==null){
            throw new Exception("To nie jest inzynier!");
        }
        return inzynier;
    }

    public void przydzielDoMisji(MisjaKosmiczna misja){
        //...
    }

    public void odwolajZeSluzby(){
        //..
    }

    public void przywrocDoSluzby(){
        //..
    }

    public static ArrayList<Pracownik> pokazWolnychPracownikow(){
        //..
        return null;
    }


    public int getNrPracownika() {
        return nrPracownika;
    }
}
