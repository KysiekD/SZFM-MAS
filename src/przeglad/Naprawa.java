package przeglad;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;

public class Naprawa extends ObjectPlusPlus {
    private int nrNaprawy; //unikalny....
    private String opisNaprawy;
    private SZFM_Enum.statusNaprawy statusNaprawy;
    private static int najwyzszyNrNaprawy = 87722;

    private Naprawa(SZFM_Enum.statusNaprawy statusNaprawy) {
        najwyzszyNrNaprawy = najwyzszyNrNaprawy +1;
        this.nrNaprawy = najwyzszyNrNaprawy;
        this.statusNaprawy = statusNaprawy;
    }

    public static Naprawa rozpocznijNowaNaprawe(Przeglad przeglad,
                                                SZFM_Enum.statusNaprawy statusNaprawy) throws Exception {
        if(przeglad==null){
            throw new Exception("Przegląd nie istnieje!");
        }
        Naprawa naprawa = new Naprawa(statusNaprawy);
        przeglad.addNaprawa(naprawa);
        System.out.println("\n===Informacje o stworzonych asocjacjach:===");
        System.out.println("--> Dodano naprawę: "+naprawa+", do przeglądu: "+przeglad);
        System.out.println("PRZEGLĄD-NAPRAWA");
        przeglad.showLinks(SZFM_Enum.asocjacjaPrzegladNaprawa.przeglad_z_naprawami.toString(), System.out);
        naprawa.showLinks(SZFM_Enum.asocjacjaPrzegladNaprawa.naprawa_podczas_przegladu.toString(), System.out);
        System.out.println("===Koniec informacji o asocjacjach.===\n");
        return naprawa;
    }

    public void wymienionoCzesci(Czesc staraCzesc, Czesc nowaCzesc) throws Exception {
        this.addLink(SZFM_Enum.asocjacjaCzescNaprawa.naprawa_z_wyrzucona_czescia.toString(),
                SZFM_Enum.asocjacjaCzescNaprawa.czesc_wyrzucona_podczas_naprawy.toString(),staraCzesc);
        this.addLink(SZFM_Enum.asocjacjaCzescNaprawa.naprawa_z_dodana_czescia.toString(),
                SZFM_Enum.asocjacjaCzescNaprawa.czesc_dodana_podczas_naprawy.toString(),nowaCzesc);

        System.out.println("\n===Informacje o stworzonych asocjacjach:===");
        System.out.println("--> Podczas naprawy: "+this+", wymieniono czesci: "+
                "\n    wyrzucona część: "+staraCzesc+
                "\n    dodana część:"+nowaCzesc);
        System.out.println("NAPRAWA-CZĘŚĆ");
        this.showLinks(SZFM_Enum.asocjacjaCzescNaprawa.naprawa_z_wyrzucona_czescia.toString(), System.out);
        this.showLinks(SZFM_Enum.asocjacjaCzescNaprawa.naprawa_z_dodana_czescia.toString(), System.out);
        staraCzesc.showLinks(SZFM_Enum.asocjacjaCzescNaprawa.czesc_wyrzucona_podczas_naprawy.toString(),System.out);
        nowaCzesc.showLinks(SZFM_Enum.asocjacjaCzescNaprawa.czesc_dodana_podczas_naprawy.toString(),System.out);
        System.out.println("===Koniec informacji o asocjacjach.===\n");
    }

    public Naprawa wyswietlNaprawe(int nrNaprawy){
        return null;
    }


    @Override
    public String toString() {
        return "Naprawa: " +
                "nr: " + nrNaprawy +
                ", status: " + statusNaprawy;
    }

    public int getNrNaprawy() {
        return nrNaprawy;
    }

    public void setNrNaprawy(int nrNaprawy) {
        this.nrNaprawy = nrNaprawy;
    }

    public String getOpisNaprawy() {
        return opisNaprawy;
    }

    public void setOpisNaprawy(String opisNaprawy) {
        this.opisNaprawy = opisNaprawy;
    }

    public SZFM_Enum.statusNaprawy getStatusNaprawy() {
        return statusNaprawy;
    }

    public void setStatusNaprawy(SZFM_Enum.statusNaprawy statusNaprawy) {
        this.statusNaprawy = statusNaprawy;
    }
}
