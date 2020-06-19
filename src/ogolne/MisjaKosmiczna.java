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
     *
     * @param nazwaMisji
     * @param odlegloscDoCeluWParsekach
     * @param lotZalogowy
     */
    public MisjaKosmiczna(String nazwaMisji, int odlegloscDoCeluWParsekach, boolean lotZalogowy) {
        super();
        najwyzszyNrMisji = najwyzszyNrMisji +1;
        this.nrMisji =  najwyzszyNrMisji;
        this.nazwaMisji = nazwaMisji;
        this.odlegloscDoCeluWParsekach = odlegloscDoCeluWParsekach;
        this.lotZalogowy = lotZalogowy;
    }

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

    public void zmienStatusMisji(){
        //..
    }

    public static ArrayList<MisjaKosmiczna> pokazWszystkieMisje(){
        return null;
    }

    public int getNrMisji() {
        return nrMisji;
    }
}
