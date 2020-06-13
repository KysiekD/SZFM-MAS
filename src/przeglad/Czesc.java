package przeglad;

import mainPackage.ObjectPlusPlus;
import pojazd.PojazdKosmiczny;

public class Czesc extends ObjectPlusPlus {
    private String nazwa;
    private int nrCzesci; //unikalny....
    //private double cena;
    private double waga; //w kg
    private double wagaElektroniki; //w kg

    public Czesc(String nazwa, double waga, double wagaElektroniki) {
        //this.nrCzesci=........
        this.nazwa = nazwa;
        this.waga = waga;
        this.wagaElektroniki = wagaElektroniki; //nie moze byc wieksza niz waga calosci
    }

    //drugi konstruktor dla czesci bez elektroniki
    public Czesc(String nazwa, double waga) {
        //this.nrCzesci=........
        this.nazwa = nazwa;
        this.waga = waga;
        this.wagaElektroniki = 0;
    }

    public void usunCzescZPojazdu(int nrCzesci, PojazdKosmiczny pojazd){

    }

    @Override
    public String toString() {
        return "Czesc{" +
                "nazwa='" + nazwa + '\'' +
                ", nrCzesci=" + nrCzesci +
                ", waga=" + waga +
                ", wagaElektroniki=" + wagaElektroniki +
                '}';
    }

    public double getWagaElektroniki() {
        //sprawdzic na poczatku czy waga elektroniki nie jest null lub 0
        return wagaElektroniki;
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
