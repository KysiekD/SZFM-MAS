package przeglad;

import mainPackage.ObjectPlusPlus;
import pojazd.PojazdKosmiczny;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Czesc extends ObjectPlusPlus {
    private String nazwa;
    private int nrCzesci; //unikalny....
    //private double cena;
    private double waga; //w kg
    private double wagaElektroniki; //w kg
    private static int najwyzszyNrCzesci = 666771;

    public Czesc(String nazwa, double waga, double wagaElektroniki) {
        super();
        najwyzszyNrCzesci = najwyzszyNrCzesci + 1;
        this.nrCzesci = najwyzszyNrCzesci;
        this.nazwa = nazwa;
        this.waga = waga;
        this.wagaElektroniki = wagaElektroniki; //nie moze byc wieksza niz waga calosci
    }

    //drugi konstruktor dla czesci bez elektroniki
    public Czesc(String nazwa, double waga) {
        super();
        najwyzszyNrCzesci = najwyzszyNrCzesci + 1;
        this.nrCzesci = najwyzszyNrCzesci;
        this.nazwa = nazwa;
        this.waga = waga;
        this.wagaElektroniki = 0;
    }

    public static Czesc dajCzesc(int nrCzesci) throws Exception {
        Iterable<Czesc> czesci = Czesc.getExtent(Czesc.class);
        for (Czesc czesc : czesci) {
            if (czesc.getNrCzesci() == nrCzesci) {
                return czesc;
            }
        }
        throw new Exception("Czesc o numerze " + nrCzesci + " nie została znaleziona!");
    }


    @Override
    public String toString() {
        return "Część: " +
                "'" + nazwa + '\'' +
                ", nr: " + nrCzesci;
    }

    public double getWagaElektroniki() {
        //sprawdzic na poczatku czy waga elektroniki nie jest null lub 0
        return wagaElektroniki;
    }

    public static ArrayList<Czesc> dajWolneCzesci() throws ClassNotFoundException {
        Iterable<Czesc> czesciWszystkie = Czesc.getExtent(Czesc.class);
        List<Czesc> czesciWPojazdach = PojazdKosmiczny.dajUzywaneCzesci();

        ArrayList<Czesc> czesciWolne = new ArrayList<>();
        //==========
        for(Czesc czesc : czesciWszystkie){
            if(!czesciWPojazdach.contains(czesc)){
                czesciWolne.add(czesc);
            }
        }


        //==========
        /*for(Czesc czesc: czesciWszystkie){
            if (!czesciWPojazdach.contains(czesc)) {
                czesciWolne.add(czesc);
            }
        }*/
        //===========



        return czesciWolne;
    }

    public void setWagaElektroniki(double wagaElektroniki) {
        this.wagaElektroniki = wagaElektroniki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNrCzesci() {
        return nrCzesci;
    }

    public void setNrCzesci(int nrCzesci) {
        this.nrCzesci = nrCzesci;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }


}
