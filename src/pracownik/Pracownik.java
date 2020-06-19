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

    protected Pracownik(String imie, String nazwisko, String imieOjca) {
        super();
        najwyzszyNrPracownika = najwyzszyNrPracownika+1;
        this.nrPracownika = najwyzszyNrPracownika;
        this.aktualnieWsluzbie = true;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.imieOjca = imieOjca;
    }

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


    private void addNaukowiec(String imie, String nazwisko, String imieOjca,
                              SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa,
                         SZFM_Enum.tytulNaukowy tytulNaukowy) throws Exception {
        Naukowiec naukowiec = new Naukowiec(imie,nazwisko, imieOjca, specjalizacjaNaukowa,tytulNaukowy );
        this.addPart(SZFM_Enum.asocjacjaKompozycjaPracownik.pracownik.toString(),
                SZFM_Enum.asocjacjaKompozycjaPracownik.posiada_naukowca.toString(), naukowiec);

    }

    private void addKosmonauta(String imie, String nazwisko, String imieOjca,
                               SZFM_Enum.wynikTestowSprawnosciowych wynikTestow) throws Exception {
        Kosmonauta kosmonauta = new Kosmonauta(imie, nazwisko, imieOjca, wynikTestow);
        this.addPart(SZFM_Enum.asocjacjaKompozycjaPracownik.pracownik.toString(),
                SZFM_Enum.asocjacjaKompozycjaPracownik.posiada_kosmonaute.toString(),
                kosmonauta);
    }

    private void addInzynier(String imie, String nazwisko, String imieOjca,
                             int nrUprawnien) throws Exception {

        this.inzynier = new Inzynier(imie,nazwisko,imieOjca,nrUprawnien);
        this.addPart(SZFM_Enum.asocjacjaKompozycjaPracownik.pracownik.toString(),
                SZFM_Enum.asocjacjaKompozycjaPracownik.posiada_inzyniera.toString(),
                this.inzynier);
    }

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
