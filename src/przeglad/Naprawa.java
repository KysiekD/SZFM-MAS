package przeglad;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

public class Naprawa extends ObjectPlusPlus {
    private int nrNaprawy; //unikalny....
    private String opisNaprawy;
    private SZFM_Enum.statusNaprawy statusNaprawy;
    private static int najwyzszyNrNaprawy = 87722;

    private Naprawa(SZFM_Enum.statusNaprawy statusNaprawy) {
        najwyzszyNrNaprawy = najwyzszyNrNaprawy +1;
        this.nrNaprawy = najwyzszyNrNaprawy;
        this.statusNaprawy = statusNaprawy;
    }

    public static Naprawa rozpocznijNowaNaprawe(Przeglad przeglad,
                                                SZFM_Enum.statusNaprawy statusNaprawy) throws Exception {
        if(przeglad==null){
            throw new Exception("Przegląd nie istnieje!");
        }
        Naprawa naprawa = new Naprawa(statusNaprawy);
        przeglad.addNaprawa(naprawa);
        System.out.println("\n===Informacje o stworzonych asocjacjach:===");
        przeglad.showLinks(SZFM_Enum.asocjacjaPrzegladNaprawa.przeglad_z_naprawami.toString(), System.out);
        naprawa.showLinks(SZFM_Enum.asocjacjaPrzegladNaprawa.naprawa_podczas_przegladu.toString(), System.out);
        System.out.println("\n===Koniec informacji o asocjacjach.===");
        return naprawa;
    }

    public void wymienCzesc(Czesc staraCzesc, Czesc nowaCzesc){
        //................
    }

    public Naprawa wyswietlNaprawe(int nrNaprawy){
        return null;
    }


    @Override
    public String toString() {
        return "Naprawa{" +
                "nrNaprawy=" + nrNaprawy +
                ", statusNaprawy=" + statusNaprawy +
                '}';
    }

    public int getNrNaprawy() {
        return nrNaprawy;
    }

    public void setNrNaprawy(int nrNaprawy) {
        this.nrNaprawy = nrNaprawy;
    }

    public String getOpisNaprawy() {
        return opisNaprawy;
    }

    public void setOpisNaprawy(String opisNaprawy) {
        this.opisNaprawy = opisNaprawy;
    }

    public SZFM_Enum.statusNaprawy getStatusNaprawy() {
        return statusNaprawy;
    }

    public void setStatusNaprawy(SZFM_Enum.statusNaprawy statusNaprawy) {
        this.statusNaprawy = statusNaprawy;
    }
}
