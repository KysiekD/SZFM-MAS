package pracownik;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

public class Kosmonauta extends Pracownik {
    private SZFM_Enum.wynikTestowSprawnosciowych wynikTestow;

    /**
     * KOnstruktor dla klasy kosmonauta. Jest ona tworzona w klasie pracownik.
     * Jako dodatek do pracownika.
     */
    public Kosmonauta(String imie, String nazwisko, String imieOjca,
    SZFM_Enum.wynikTestowSprawnosciowych wynikTestow) {
        super(imie, nazwisko, imieOjca);
        this.wynikTestow = wynikTestow;
    }
}
