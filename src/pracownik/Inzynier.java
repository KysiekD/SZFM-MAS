package pracownik;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import przeglad.Przeglad;

public class Inzynier extends Pracownik {
    private int nrUprawnien;

    /**
     * KOnstruktor dla klasy inżynier. Jest ona tworzona w klasie pracownik.
     * Jako dodatek do pracownika.
     */
    public Inzynier(String imie, String nazwisko, String imieOjca,
                    int nrUprawnien) {
        super(imie, nazwisko, imieOjca);
        this.nrUprawnien = nrUprawnien;
    }

    /**
     * Umożliwia stworzenie asocjacji między inżynierem a przeglądem.
     * Inżynier odpowiada za przeglądy.
     *
     * @param przeglad Przegląd do któego należy przypisać inżyniera.
     */
    public void powiazInzynieraZPrzegladem(Przeglad przeglad){
        this.addLink(SZFM_Enum.asocjacjaInzynierPrzeglad.inzynier_prowadzacy_przeglad.toString(),
                SZFM_Enum.asocjacjaInzynierPrzeglad.przeglad_prowadzony_przez_inzyniera.toString(),
                przeglad);
    }

    @Override
    public String toString() {
        return "Inzynier: " +
                 super.toString()+
                ", nr uprawnień: =" + nrUprawnien;
    }
}
