package pracownik;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

public class Naukowiec extends Pracownik {
    private SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa;
    private SZFM_Enum.tytulNaukowy tytulNaukowy;

    /**
     * KOnstruktor dla klasy naukowiec. Jest ona tworzona w klasie pracownik.
     * Jako dodatek do pracownika.
     */
    public Naukowiec(String imie, String nazwisko, String imieOjca,
                     SZFM_Enum.specjalizacjaNaukowa specjalizacjaNaukowa,
                     SZFM_Enum.tytulNaukowy tytulNaukowy) {
        super(imie, nazwisko, imieOjca);
        this.specjalizacjaNaukowa = specjalizacjaNaukowa;
        this.tytulNaukowy = tytulNaukowy;
    }


}
