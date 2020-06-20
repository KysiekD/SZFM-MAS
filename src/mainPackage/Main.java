package mainPackage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

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
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        String savePath = "C:\\Users\\Wygrany\\Desktop\\Extent.txt";
        Pracownik naukowiecInzynier1 = null;
        ArrayList<Czesc> wolneCzesci = new ArrayList<Czesc>();
        ArrayList<PojazdKosmiczny> listaPojazdow = new ArrayList<>();

        Pracownik kosmonauta1 = null;
        MisjaKosmiczna misja1 = null;
        UdzialWMisji udzialWMisji1;
        Placowka placowka1 = null;
        SondaKosmiczna sonda1;
        SondaKosmiczna sonda2;
        PromKosmiczny prom1;
        Czesc czesc1;
        Czesc czesc2;
        Czesc czesc3;
        Czesc czesc4;
        Czesc czesc5;
        Czesc czesc6;
        Boolean czyLadujemySystem = true;

        // READ EXTENSION:
        if(czyLadujemySystem) {
            try {

                ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(savePath));
                ObjectPlus.readExtents(inStream);
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            for (Czesc e : PojazdKosmiczny.dajUzywaneCzesci()) {
                System.out.println("Załadowano część w pojeździe:" + e);
            }


            //Iterable<PojazdKosmiczny> extentPojazdow = PojazdKosmiczny.getExtent(PojazdKosmiczny.class);
            Iterable<PojazdKosmiczny> extentPojazdow = PojazdKosmiczny.dajListaPojazdow();
            for (PojazdKosmiczny pojazd : extentPojazdow) {
                System.out.println(pojazd);
                System.out.println("CZESC: " + pojazd.getCzesci());
            }

            listaPojazdow = PojazdKosmiczny.dajListaPojazdow();
            wolneCzesci = Czesc.dajWolneCzesci();

            for (Czesc czesc : wolneCzesci) {
                System.out.println("Załadowano wolną część: " + czesc);
            }

            try {
                misja1 = MisjaKosmiczna.znajdzMisje(51);
                placowka1 = Placowka.znajdzPlacowke(101);
                placowka1.powiazPlacowkeZMisja(misja1);
                naukowiecInzynier1 = Pracownik.znajdzPracownika(101);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //=======================
        //=======================
        //=======================
        if(!czyLadujemySystem) {
            try {
                naukowiecInzynier1 = new Pracownik("Mirosław", "Hermaszewski", "Roman", 2441114,
                        SZFM_Enum.tytulNaukowy.doktor, SZFM_Enum.specjalizacjaNaukowa.fizyka);
                kosmonauta1 = new Pracownik("Anatolij", "Milenkov", "Józef",
                        SZFM_Enum.wynikTestowSprawnosciowych.zdane);

            } catch (Exception e) {
                e.printStackTrace();
            }

            misja1 = new MisjaKosmiczna("Juno1", 12, true);

            udzialWMisji1 = new UdzialWMisji(new Date(332235533232L), new Date(339235533232L), "Starszy Pilot",
                    misja1, kosmonauta1);

            placowka1 = new Placowka("Port Lotniczy im. M. Kopernika", SZFM_Enum.kraj.Polska);
            placowka1.powiazPlacowkeZMisja(misja1);


            sonda1 = new SondaKosmiczna("Sputnik", 1992, 19,
                    SZFM_Enum.rodzajNapedu.spalinowy);
            sonda2 = new SondaKosmiczna("Voyager1", 1991,
                    200, SZFM_Enum.rodzajNapedu.jonowy);
            prom1 = new PromKosmiczny("Columbia", 1967, 33, 3, 20, 15);

            prom1.powiazPojazdZMisja(misja1);

            listaPojazdow = PojazdKosmiczny.dajListaPojazdow();
            for (PojazdKosmiczny pojazd : listaPojazdow) {
                System.out.println("Załadowano pojazd: " + pojazd.toString());
            }

            czesc1 = new Czesc("Uszczelka", 12);
            czesc2 = new Czesc("Pompa ciepła", 5, 1);
            czesc3 = new Czesc("Monitor", 17, 2);
            czesc4 = new Czesc("Boiler", 144);
            czesc5 = new Czesc("Uszczelka", 18);
            czesc6 = new Czesc("Pompa", 5, 1);

            try {
                sonda1.dodajCzescDoPojazdu(czesc1);
                sonda1.dodajCzescDoPojazdu(czesc2);
            } catch (Exception e) {
                e.printStackTrace();
            }


            Iterable<Czesc> extentCzesc = Czesc.getExtent(Czesc.class);
            for (Czesc czesc : extentCzesc) {
                System.out.println("\n" + czesc);
            }

            wolneCzesci = Czesc.dajWolneCzesci();
            for (Czesc czesc : wolneCzesci) {
                System.out.println("Załadowano wolną część: " + czesc);
            }
        }





        JFrame frame = new JFrame("PrzegladGUI");
        try {
            frame.setContentPane(new PrzegladGUI(listaPojazdow, placowka1, naukowiecInzynier1.getInzynier()).panel1);
        } catch (Exception e) {
            e.printStackTrace();
        }



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.out.println("System closed.");

                saveData(savePath);
                int i=JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zamknąć system?");
                if(i==0)
                    System.exit(0);
            }

        });

        frame.pack();
        frame.setVisible(true);
        System.out.println("__S__Y__S__T__E__M____Z__A__Ł__A__D__O__W__A__N__Y");



    }

    public static void saveData(String path) {
        // WRITE EXTENSION:
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            ObjectPlus.writeExtents(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
