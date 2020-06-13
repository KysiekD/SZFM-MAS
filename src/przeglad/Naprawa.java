package przeglad;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

public class Naprawa extends ObjectPlusPlus {
    private int nrNaprawy; //unikalny....
    private String opisNaprawy;
    private SZFM_Enum.statusNaprawy statusNaprawy;

    public Naprawa(SZFM_Enum.statusNaprawy statusNaprawy) {
        //this.nrNaprawy = ...............
        this.statusNaprawy = statusNaprawy;
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
