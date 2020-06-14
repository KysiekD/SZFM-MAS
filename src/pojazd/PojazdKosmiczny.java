package pojazd;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import ogolne.MisjaKosmiczna;

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


    protected PojazdKosmiczny(String nazwa, int nrPojazdu, int rokProdukcji, int maksymalnyZasiegWParsekach) {
        this.nazwa = nazwa;
        this.nrPojazdu = nrPojazdu;
        this.rokProdukcji = rokProdukcji;
        this.maksymalnyZasiegWParsekach = maksymalnyZasiegWParsekach;
        statusPojazdu = gotowy;
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
        return "nazwa='" + nazwa + '\'' +
                ", nrPojazdu=" + nrPojazdu +
                ", statusPojazdu=" + statusPojazdu +
                '}';
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
