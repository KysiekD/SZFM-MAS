package przeglad;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import pojazd.PojazdKosmiczny;
import pracownik.Inzynier;

import java.util.Date;

public class Przeglad extends ObjectPlusPlus {
    private int nrPrzegladu;  //unikalny......
    private Date dataPrzegladu;
    private SZFM_Enum.statusPrzegladu statusPrzegladu;
    private Date dataWaznosciPrzegladu;


    private Przeglad(Date dataPrzegladu, SZFM_Enum.statusPrzegladu statusPrzegladu, Date dataWaznosciPrzegladu) {
        //...this.nrPrzegladu = ..........
        this.dataPrzegladu = dataPrzegladu;
        this.statusPrzegladu = statusPrzegladu;
        this.dataWaznosciPrzegladu = dataWaznosciPrzegladu;
    }

    public void rozpoczecieNowegoPrzegladu(PojazdKosmiczny pojazd, Date dataPrzegladu,
                                           SZFM_Enum.statusPrzegladu statusPrzegladu, Date dataWaznosciPrzegladu){
            /*Konstruktor................
             Tworzenie powiazania..........*/

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
        return "Przeglad{" +
                "nrPrzegladu=" + nrPrzegladu +
                ", dataPrzegladu=" + dataPrzegladu +
                ", statusPrzegladu=" + statusPrzegladu +
                ", dataWaznosciPrzegladu=" + dataWaznosciPrzegladu +
                '}';
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
