package pojazd;

import mainPackage.ObjectPlus;
import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import ogolne.MisjaKosmiczna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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


    protected PojazdKosmiczny(String nazwa, int rokProdukcji, int maksymalnyZasiegWParsekach) {
        this.nazwa = nazwa;
        najwyzszyNrPojazdu = najwyzszyNrPojazdu+1;
        this.nrPojazdu = najwyzszyNrPojazdu;
        this.rokProdukcji = rokProdukcji;
        this.maksymalnyZasiegWParsekach = maksymalnyZasiegWParsekach;
        statusPojazdu = gotowy;
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
        //.............
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
                ", status: " + statusPojazdu;
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
