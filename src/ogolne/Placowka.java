package ogolne;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import przeglad.Przeglad;

public class Placowka extends ObjectPlusPlus {
    private String nazwa;
    private int nrPlacowki;
    private static int najwyzszyNrPlacowki = 100;
    private SZFM_Enum.kraj kraj;

    /**
     * Placówka kosmiczna. Naczelna baza sektorowa.
     *
     * @param nazwa Nazwa własna placówki.
     * @param kraj Kraj w którym mieści się placówka.
     */
    public Placowka(String nazwa, SZFM_Enum.kraj kraj) {
        super();
        najwyzszyNrPlacowki = najwyzszyNrPlacowki + 1;
        this.nrPlacowki = najwyzszyNrPlacowki;
        this.nazwa = nazwa;
        this.kraj = kraj;
    }

    /**
     * Tworzy asocjację między placówką a przeglądem. Przeglądy odbywają się w placówkach.
     *
     * @param przeglad Wybrany przegląd.
     * @throws Exception Jeśli podany przegląd nie istnieje system zwraca błąd.
     */
    public void powiazPlacowkeZPrzegladem(Przeglad przeglad) throws Exception {
        this.addLink(SZFM_Enum.asocjacjaPlacowkaPrzeglad.placowka_przeprowadzajaca_przeglad.toString(),
                SZFM_Enum.asocjacjaPlacowkaPrzeglad.przeglad_odbywa_sie_w_placowce.toString(),
                przeglad);

        System.out.println("\n===Informacje o stworzonych asocjacjach:===");
        System.out.println("--> Dodano przegląd: "+przeglad+", do placówki: "+this);
        System.out.println("PLACÓWKA-PRZEGLĄD");
        this.showLinks(SZFM_Enum.asocjacjaPlacowkaPrzeglad.placowka_przeprowadzajaca_przeglad.toString(), System.out);
        przeglad.showLinks(SZFM_Enum.asocjacjaPlacowkaPrzeglad.przeglad_odbywa_sie_w_placowce.toString(), System.out);
        System.out.println("===Koniec informacji o asocjacjach.===\n");

    }

    /**
     * Tworzy asocjację między placówką a misją. Misje organizowane są przez placówki.
     *
     * @param misja Dana misja którą organizuje placówka.
     */
    public void powiazPlacowkeZMisja(MisjaKosmiczna misja){
        this.addLink(SZFM_Enum.asocjacjaMisjaPlacowka.placowka_organizujaca_misje.toString(),
                SZFM_Enum.asocjacjaMisjaPlacowka.misja_organizaowana_przez_placowke.toString(),
                misja);
    }

    /**
     * Szuka placówki po podanym jej numerze.
     *
     * @param nrPlacowki Numer szukanej placówki.
     * @return Zwraca szukaną placówkę.
     * @throws Exception Jeśli nie istnieje placówka o podanym numerze.
     */
    public static Placowka znajdzPlacowke(int nrPlacowki) throws Exception {
        Placowka znalezionaPlacowka = null;
        for(Placowka placowka: Placowka.getExtent(Placowka.class)){
            if(placowka.getNrPlacowki() == nrPlacowki){
                znalezionaPlacowka = placowka;
                return  znalezionaPlacowka;
            }
        }
        throw  new Exception("Nie znaleziono placówki o numerze "+nrPlacowki);
    }

    /**
     * Wyświetla informacje o placówce.
     *
     * @return Informacje o placówce.
     */
    @Override
    public String toString() {
        return "Placowka: " +
                "'" + nazwa + '\'' +
                ", nr: " + nrPlacowki +
                ", kraj: " + kraj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


    public int getNrPlacowki() {
        return nrPlacowki;
    }

    public void setNrPlacowki(int nrPlacowki) {
        this.nrPlacowki = nrPlacowki;
    }

    public SZFM_Enum.kraj getKraj() {
        return kraj;
    }

    public void setKraj(SZFM_Enum.kraj kraj) {
        this.kraj = kraj;
    }
}
