package pojazd;

import mainPackage.ObjectPlus;
import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import ogolne.MisjaKosmiczna;
import przeglad.Przeglad;

import java.util.*;

import static mainPackage.SZFM_Enum.statusPojazdu.*;

public abstract class PojazdKosmiczny extends ObjectPlusPlus {
    private String nazwa;
    private int nrPojazdu; //unikalny
    private int rokProdukcji;
    private int maksymalnyZasiegWParsekach;
    private Date dataOstatniegoPrzegladu;
    private Date dataWaznosciPrzegladu;
    private SZFM_Enum.statusPojazdu statusPojazdu;
    private static int najwyzszyNrPojazdu = 1000; //pole klasowe
    private List<Przeglad> przeglady = new ArrayList<>();
    private static Set<Przeglad> wszystkiePrzegladyList = new HashSet<>();


    protected PojazdKosmiczny(String nazwa, int rokProdukcji, int maksymalnyZasiegWParsekach) {
        this.nazwa = nazwa;
        najwyzszyNrPojazdu = najwyzszyNrPojazdu+1;
        this.nrPojazdu = najwyzszyNrPojazdu;
        this.rokProdukcji = rokProdukcji;
        this.maksymalnyZasiegWParsekach = maksymalnyZasiegWParsekach;
        statusPojazdu = gotowy;
    }

    public void addPrzeglad(Przeglad przeglad) throws Exception {
        if(!przeglady.contains(przeglad)) {
            if (wszystkiePrzegladyList.contains(przeglad)) {
                throw new Exception("Ten przeglad jest przypisany do innego pojazdu!");
            }
        }
        przeglady.add(przeglad);
        wszystkiePrzegladyList.add(przeglad);
        this.addPart(SZFM_Enum.asocjacjaPojazdPrzeglad.pojazd_w_przegladzie.toString(),
                SZFM_Enum.asocjacjaPojazdPrzeglad.przeglad_pojazdu.toString(), przeglad);
    }

    /**
     * jeśli nie ma ekstensji którejś klasy to zostanie przechwycony błąd
     * @return
     */
    public static ArrayList<PojazdKosmiczny> dajListaPojazdow()   {
        ArrayList<PojazdKosmiczny> listaPojazdow = new ArrayList<>();
        Iterable<SondaKosmiczna> listaSond = null;
        try {
            listaSond = SondaKosmiczna.getExtent(SondaKosmiczna.class);
            listaPojazdow.addAll((Collection<? extends PojazdKosmiczny>) listaSond);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<PromKosmiczny> listaPromow = null;
        try {
            listaPromow = PromKosmiczny.getExtent(PromKosmiczny.class);
            listaPojazdow.addAll((Collection<? extends PojazdKosmiczny>) listaPromow);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return listaPojazdow;
    }

    public static PojazdKosmiczny dajPojazd(int nrPojazdu) throws Exception {

        ArrayList<PojazdKosmiczny> listaPojazdow = PojazdKosmiczny.dajListaPojazdow();

        for(PojazdKosmiczny pojazd: listaPojazdow) {
            if (pojazd.getNrPojazdu() == nrPojazdu) {
                return pojazd;
            }
        }
        throw new Exception("Nie znaleziono pojazdu o numerze: "+String.valueOf(nrPojazdu));
    }

    public boolean czyWaznyPrzeglad(){
        //atrybut wyliczalny
        //...
        return true;

    }

    public void przydzielDoMosji(MisjaKosmiczna misja){
        //...
    }

    public void rozpocznijPrzeglad(){
        //..............
    }

    public void zmienStatus(SZFM_Enum.statusPojazdu status){
        this.statusPojazdu = status;
    }

    public List<PojazdKosmiczny> pokazGotowePojazdy(){
        //............
        return null;
    }

    @Override
    public String toString() {
        return
                nrPojazdu +
                 ", '" + nazwa + '\'' +
                ", aktualny status: " + statusPojazdu;
    }

    //GETTERS AND SETTERS====================================
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNrPojazdu() {
        return nrPojazdu;
    }

    public void setNrPojazdu(int nrPojazdu) {
        this.nrPojazdu = nrPojazdu;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public int getMaksymalnyZasiegWParsekach() {
        return maksymalnyZasiegWParsekach;
    }

    public void setMaksymalnyZasiegWParsekach(int maksymalnyZasiegWParsekach) {
        this.maksymalnyZasiegWParsekach = maksymalnyZasiegWParsekach;
    }

    public Date getDataOstatniegoPrzegladu() {
        return dataOstatniegoPrzegladu;
    }

    public void setDataOstatniegoPrzegladu(Date dataOstatniegoPrzegladu) {
        this.dataOstatniegoPrzegladu = dataOstatniegoPrzegladu;
    }

    public Date getDataWaznosciPrzegladu() {
        return dataWaznosciPrzegladu;
    }

    public void setDataWaznosciPrzegladu(Date dataWaznosciPrzegladu) {
        this.dataWaznosciPrzegladu = dataWaznosciPrzegladu;
    }

    public SZFM_Enum.statusPojazdu getStatusPojazdu() {
        return statusPojazdu;
    }

    public void setStatusPojazdu(SZFM_Enum.statusPojazdu statusPojazdu) {
        this.statusPojazdu = statusPojazdu;
    }
}
