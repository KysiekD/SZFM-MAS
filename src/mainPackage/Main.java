package mainPackage;

import gui.PrzegladGUI;
import ogolne.MisjaKosmiczna;
import ogolne.Placowka;
import ogolne.UdzialWMisji;
import pojazd.PojazdKosmiczny;
import pojazd.PromKosmiczny;
import pojazd.SondaKosmiczna;
import pracownik.Pracownik;
import przeglad.Czesc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Pracownik naukowiecInzynier1 = null;
        Pracownik kosmonauta1 = null;
        try {
            naukowiecInzynier1 = new Pracownik("Mirosław","Hermaszewski","Roman",2441114,
                    SZFM_Enum.tytulNaukowy.doktor, SZFM_Enum.specjalizacjaNaukowa.fizyka);
            kosmonauta1 = new Pracownik("Anatolij","Milenkov","Józef",
                    SZFM_Enum.wynikTestowSprawnosciowych.zdane);

        } catch (Exception e) {
            e.printStackTrace();
        }

        MisjaKosmiczna misja1 = new MisjaKosmiczna("Juno1",12,true);

        UdzialWMisji udzialWMisji1 = new UdzialWMisji(new Date(332235533232L),new Date(339235533232L),"Starszy Pilot",
                misja1, kosmonauta1);

        Placowka placowka1 = new Placowka("Port Lotniczy im. M. Kopernika", SZFM_Enum.kraj.Polska);

        SondaKosmiczna sonda1 = new SondaKosmiczna("Sputnik",1992,19,
                SZFM_Enum.rodzajNapedu.spalinowy);
        SondaKosmiczna sonda2 = new SondaKosmiczna("Voyager1",1991,
                200,SZFM_Enum.rodzajNapedu.jonowy);
        PromKosmiczny prom1 = new PromKosmiczny("Columbia",1967,33,3,20,15);


        ArrayList<PojazdKosmiczny> listaPojazdow = PojazdKosmiczny.dajListaPojazdow();
        for(PojazdKosmiczny pojazd: listaPojazdow){
           System.out.println("Załadowano pojazd: "+pojazd.toString());
        }

        Czesc czesc1 = new Czesc("Uszczelka",12);
        Czesc czesc2 = new Czesc("Pompa ciepła",5,1);
        Czesc czesc3 = new Czesc("Monitor", 17, 2);
        Czesc czesc4 = new Czesc("Boiler",144);
        Czesc czesc5 = new Czesc("Uszczelka",18);
        Czesc czesc6 = new Czesc("Pompa",5,1);

        try {
            sonda1.dodajCzescDoPojazdu(czesc1);
            sonda1.dodajCzescDoPojazdu(czesc2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*Iterable<Czesc> extentCzesc = Czesc.getExtent(Czesc.class);
        for(Czesc czesc: extentCzesc){
            System.out.println("\n"+czesc);
        }*/

        ArrayList<Czesc> wolneCzesci = Czesc.dajWolneCzesci();
        for(Czesc czesc : wolneCzesci){
            System.out.println("Załadowano wolną część: "+czesc);
        }


        JFrame frame = new JFrame("PrzegladGUI");
        try {
            frame.setContentPane(new PrzegladGUI(listaPojazdow, placowka1, naukowiecInzynier1.getInzynier()).panel1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println("__S__Y__S__T__E__M____Z__A__Ł__A__D__O__W__A__N__Y");
    }
}
