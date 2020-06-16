package przeglad;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import pojazd.PojazdKosmiczny;
import pracownik.Inzynier;

import java.util.*;

public class Przeglad extends ObjectPlusPlus {
    private int nrPrzegladu;  //unikalny......
    private Date dataPrzegladu;
    private SZFM_Enum.statusPrzegladu statusPrzegladu;
    private Date dataWaznosciPrzegladu;
    private String opisPrzegladu;



    private static int najwyzszyNrPrzegladu=70000;
    private static int czasWaznosciPrzegladuWDniach = 365;
    private List<Naprawa> naprawy;
    private static Set<Naprawa> wszystkieNaprawy = new HashSet<>();


    private Przeglad(Date dataPrzegladu, SZFM_Enum.statusPrzegladu statusPrzegladu) {
        najwyzszyNrPrzegladu = najwyzszyNrPrzegladu+1;
        this.nrPrzegladu = najwyzszyNrPrzegladu;
        this.dataPrzegladu = dataPrzegladu;
        this.statusPrzegladu = statusPrzegladu;
        this.dataWaznosciPrzegladu = new Date(dataPrzegladu.getTime()+(czasWaznosciPrzegladuWDniach*86400000L));
        naprawy = new ArrayList<>();
    }

    public static Przeglad rozpoczecieNowegoPrzegladu(PojazdKosmiczny pojazd,
                                           SZFM_Enum.statusPrzegladu statusPrzegladu) throws Exception {
        if(pojazd==null){
            throw new Exception("Pojazd nie istnieje!");
        }
        Przeglad przeglad = new Przeglad(Calendar.getInstance().getTime(), statusPrzegladu);
            pojazd.addPrzeglad(przeglad);
            /*pojazd.addPart(SZFM_Enum.asocjacjaPojazdPrzeglad.pojazd.toString(),
                    SZFM_Enum.asocjacjaPojazdPrzeglad.przeglad.toString(), przeglad);*/


        return przeglad;
    }

    public void addNaprawa(Naprawa naprawa) throws Exception {
        if(!naprawy.contains(naprawa)) {
            if(wszystkieNaprawy.contains(naprawa)) {
                throw new Exception("Ta naprawa przypisana jest juz do innego przegladu!");
            }
        }
        naprawy.add(naprawa);
        wszystkieNaprawy.add(naprawa);
        this.addPart(SZFM_Enum.asocjacjaPrzegladNaprawa.przeglad_z_naprawami.toString(),
                SZFM_Enum.asocjacjaPrzegladNaprawa.naprawa_podczas_przegladu.toString(),naprawa);

    }

    public void setOpisPrzegladu(String opisPrzegladu) {
        this.opisPrzegladu = opisPrzegladu;
    }

    public String getOpisPrzegladu() {
        return opisPrzegladu;
    }

    public void przydzielInzyniera(Inzynier inzynier){

    }

    public void rozpocznijNaprawe(){

    }

    public Przeglad wyswietlPrzeglad(int nrPrzegladu){
       //...............
        return null;
    }


    @Override
    public String toString() {
        return "Przeglad: " +
                "numer przeglądu: " + nrPrzegladu +
                ", data wykonania: " + dataPrzegladu +
                ", status: " + statusPrzegladu +
                ", data ważności: " + dataWaznosciPrzegladu;
    }

    public int getNrPrzegladu() {
        return nrPrzegladu;
    }

    public void setNrPrzegladu(int nrPrzegladu) {
        this.nrPrzegladu = nrPrzegladu;
    }

    public Date getDataPrzegladu() {
        return dataPrzegladu;
    }

    public void setDataPrzegladu(Date dataPrzegladu) {
        this.dataPrzegladu = dataPrzegladu;
    }

    public SZFM_Enum.statusPrzegladu getStatusPrzegladu() {
        return statusPrzegladu;
    }

    public void setStatusPrzegladu(SZFM_Enum.statusPrzegladu statusPrzegladu) {
        this.statusPrzegladu = statusPrzegladu;
    }

    public Date getDataWaznosciPrzegladu() {
        return dataWaznosciPrzegladu;
    }

    public void setDataWaznosciPrzegladu(Date dataWaznosciPrzegladu) {
        this.dataWaznosciPrzegladu = dataWaznosciPrzegladu;
    }
}
