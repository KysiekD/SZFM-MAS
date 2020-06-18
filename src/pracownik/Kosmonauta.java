package pracownik;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

public class Kosmonauta extends Pracownik {
    private SZFM_Enum.wynikTestowSprawnosciowych wynikTestow;


    public Kosmonauta(String imie, String nazwisko, String imieOjca,
    SZFM_Enum.wynikTestowSprawnosciowych wynikTestow) {
        super(imie, nazwisko, imieOjca);
        this.wynikTestow = wynikTestow;
    }
}
