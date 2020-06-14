package mainPackage;

import gui.PrzegladGUI;
import pojazd.PojazdKosmiczny;
import pojazd.PromKosmiczny;
import pojazd.SondaKosmiczna;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

    SondaKosmiczna sonda1 = new SondaKosmiczna("Sputnik",199222,1982,
            127,SZFM_Enum.rodzajNapedu.spalinowy);
    SondaKosmiczna sonda2 = new SondaKosmiczna("Voyager1",55112,1991,
            200,SZFM_Enum.rodzajNapedu.jonowy);
    PromKosmiczny prom1 = new PromKosmiczny("Columbia",35511,1967,33,
                                3,20,15);

    Iterable<SondaKosmiczna> listaSond = SondaKosmiczna.getExtent(SondaKosmiczna.class);
    Iterable<PromKosmiczny> listaPromow = PromKosmiczny.getExtent(PromKosmiczny.class);

    ArrayList<PojazdKosmiczny> listaPojazdow = new ArrayList<>();
    listaPojazdow.addAll((Collection<? extends PojazdKosmiczny>) listaSond);
    listaPojazdow.addAll((Collection<? extends PojazdKosmiczny>) listaPromow);

        for(PojazdKosmiczny pojazd: listaPojazdow){
       System.out.println("\n"+pojazd.toString());
    }

        JFrame frame = new JFrame("PrzegladGUI");
        frame.setContentPane(new PrzegladGUI(listaPojazdow).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
