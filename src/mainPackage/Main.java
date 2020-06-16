package mainPackage;

import gui.PrzegladGUI;
import pojazd.PojazdKosmiczny;
import pojazd.PromKosmiczny;
import pojazd.SondaKosmiczna;
import przeglad.Czesc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        SondaKosmiczna sonda1 = new SondaKosmiczna("Sputnik",1992,19,
                SZFM_Enum.rodzajNapedu.spalinowy);
        SondaKosmiczna sonda2 = new SondaKosmiczna("Voyager1",1991,
                200,SZFM_Enum.rodzajNapedu.jonowy);
        PromKosmiczny prom1 = new PromKosmiczny("Columbia",1967,33,3,20,15);

        ArrayList<PojazdKosmiczny> listaPojazdow = PojazdKosmiczny.dajListaPojazdow();
        for(PojazdKosmiczny pojazd: listaPojazdow){
           System.out.println("\n"+pojazd.toString());
        }

        Czesc czesc1 = new Czesc("Uszczelka",12);
        Czesc czesc2 = new Czesc("Pompa ciepła",5,1);

        try {
            sonda1.addCzescDoPojazdu(czesc1);
            sonda1.addCzescDoPojazdu(czesc2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Iterable<Czesc> extentCzesc = Czesc.getExtent(Czesc.class);
        for(Czesc czesc: extentCzesc){
            System.out.println("\n"+czesc);
        }

        JFrame frame = new JFrame("PrzegladGUI");
        frame.setContentPane(new PrzegladGUI(listaPojazdow).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
