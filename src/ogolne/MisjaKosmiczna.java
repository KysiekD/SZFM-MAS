package ogolne;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

import java.util.ArrayList;


public class MisjaKosmiczna extends ObjectPlusPlus {
    private String nazwaMisji;
    private int nrMisji;
    private int odlegloscDoCeluWParsekach;
    private String opisMisji;
    private boolean lotZalogowy;
    private SZFM_Enum.statusMisji statusMisji;
    private static int najwyzszyNrMisji = 50;

    /**
     * Konstruktor klasy.
     *
     * @param nazwaMisji Nazwa własna misji.
     * @param odlegloscDoCeluWParsekach Odległość do celu misji wyrażona w parsekach.
     * @param lotZalogowy Informacja (true/false) czy lot jest załogowy czy też nie.
     */
    public MisjaKosmiczna(String nazwaMisji, int odlegloscDoCeluWParsekach, boolean lotZalogowy) {
        super();
        najwyzszyNrMisji = najwyzszyNrMisji +1;
        this.nrMisji =  najwyzszyNrMisji;
        this.nazwaMisji = nazwaMisji;
        this.odlegloscDoCeluWParsekach = odlegloscDoCeluWParsekach;
        this.lotZalogowy = lotZalogowy;
    }

    /**
     * Zwraca misję po podaniu jej numeru.
     *
     * @param nrMisji Unikalny numer misji.
     * @return Zwraca misję.
     * @throws Exception Jeśli w bazie nie istnieje misja o takim numerze zostaje zwrócony błąd.
     */
    public static MisjaKosmiczna znajdzMisje(int nrMisji) throws Exception {
        MisjaKosmiczna znalezionaMisja = null;
        for(MisjaKosmiczna misja: MisjaKosmiczna.getExtent(MisjaKosmiczna.class)){
            if(misja.getNrMisji() == nrMisji){
                znalezionaMisja = misja;
                return  znalezionaMisja;
            }
        }
        throw  new Exception("Nie znaleziono misji o numerze "+nrMisji);

    }


    public int wyliczCzasTrwania(){
        //..
        return 0;
    }

    /**
     * Zmienia status danej misji.
     *
     * @param status Status docelowy.
     */
    public void zmienStatusMisji(SZFM_Enum.statusMisji status){
        //..
    }

    /**
     * Zwraca listę wszystkich misji dostępnych w bazie.
     *
     * @return Wszystkie misje.
     */
    public static ArrayList<MisjaKosmiczna> pokazWszystkieMisje(){
        return null;
    }

    /**
     * Zwraca numer misji.
     *
     * @return Numer misji.
     */
    public int getNrMisji() {
        return nrMisji;
    }
}
