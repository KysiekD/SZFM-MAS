package pracownik;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import przeglad.Przeglad;

public class Inzynier extends Pracownik {
    private int nrUprawnien;


    public Inzynier(String imie, String nazwisko, String imieOjca,
                    int nrUprawnien) {
        super(imie, nazwisko, imieOjca);
        this.nrUprawnien = nrUprawnien;
    }

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
