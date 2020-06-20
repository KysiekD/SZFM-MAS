package pojazd;

import mainPackage.ObjectPlus;
import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import ogolne.MisjaKosmiczna;
import ogolne.Placowka;
import przeglad.Czesc;
import przeglad.Przeglad;

import java.lang.reflect.Array;
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
    private List<Czesc> czesci = new ArrayList<>();
    private static Set<Czesc> wszystkieCzesciWPojazdach = new HashSet<>();

    /**
     * Klasa pojazdu kosmicznego. Jest to nad-klasa abstrakcyjna.
     *
     * @param nazwa Nazwa własna pojazdu.
     * @param rokProdukcji Rok produkcji pojazdu.
     * @param maksymalnyZasiegWParsekach Zasięg maksymalny wyrażony w parsekach.
     */
    protected PojazdKosmiczny(String nazwa, int rokProdukcji, int maksymalnyZasiegWParsekach) {
        super();
        this.nazwa = nazwa;
        najwyzszyNrPojazdu = najwyzszyNrPojazdu+1;
        this.nrPojazdu = najwyzszyNrPojazdu;
        this.rokProdukcji = rokProdukcji;
        this.maksymalnyZasiegWParsekach = maksymalnyZasiegWParsekach;
        statusPojazdu = gotowy;
    }

    /**
     * Tworzy asocjację między pojazdem a przeglądem. Przegląd dotyczy pojazdu.
     *
     * @param przeglad Dany przegląd.
     * @throws Exception Jeśli pojazd lub przegląd nie istnieją.
     */
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
     * Dodaje nową część do pojazdu. Tworzy powiązanie.
     *
     * @param czesc Dana część.
     * @throws Exception Jeśli część lub pojazd nie istnieją w bazie.
     */
    public void dodajCzescDoPojazdu(Czesc czesc) throws Exception {
        if(!czesci.contains(czesc)) {
            if (wszystkieCzesciWPojazdach.contains(czesc)) {
                throw new Exception("Ten przeglad jest przypisany do innego pojazdu!");
            }
        }
        this.addLink(SZFM_Enum.asocjacjaPojazdCzesc.pojazd_z_czescia.toString(),
                SZFM_Enum.asocjacjaPojazdCzesc.czesc_w_pojezdzie.toString(), czesc);
        czesci.add(czesc);
        PojazdKosmiczny.wszystkieCzesciWPojazdach.add(czesc);

        System.out.println("\n===Informacje o stworzonych asocjacjach:===");
        System.out.println("--> Dodano część: "+czesc+", do pojazdu: "+this);
        System.out.println("POJAZD-CZĘŚĆ");
        this.showLinks(SZFM_Enum.asocjacjaPojazdCzesc.pojazd_z_czescia.toString(), System.out);
        czesc.showLinks(SZFM_Enum.asocjacjaPojazdCzesc.czesc_w_pojezdzie.toString(), System.out);
        System.out.println("===Koniec informacji o asocjacjach.===\n");

    }

    /**
     * Usuwa powiązanie między pojazdem a częścią.
     *
     * @param czesc Dana część która jest odłączana od pojazdu.
     * @throws Exception Jeśli część lub pojazd nie istnieją.
     */
    public void odlaczCzescOdPojazdu(Czesc czesc) throws Exception {
        if(!czesci.contains(czesc)){
            throw new Exception("Tej części nie ma w tym pojeździe!");
        }
        this.removeLink(SZFM_Enum.asocjacjaPojazdCzesc.pojazd_z_czescia.toString(),
                SZFM_Enum.asocjacjaPojazdCzesc.czesc_w_pojezdzie.toString(),czesc);

        czesci.remove(czesc);
        PojazdKosmiczny.wszystkieCzesciWPojazdach.remove(czesc);

        System.out.println("\n===Informacje o stworzonych asocjacjach:===");
        System.out.println("--> Usunieto czesc: "+czesc+", z pojazdu: "+this);
        System.out.println("POJAZD-CZĘŚĆ");
        this.showLinks(SZFM_Enum.asocjacjaPojazdCzesc.pojazd_z_czescia.toString(), System.out);
        czesc.showLinks(SZFM_Enum.asocjacjaPojazdCzesc.czesc_w_pojezdzie.toString(), System.out);
        System.out.println("===Koniec informacji o asocjacjach.===\n");
    }


    /**
     *
     * @return Zwraca listę części które ma w sobie pojazd.
     */
    public List<Czesc> dajCzesciPojazdu(){
        return czesci;
    }

    /**
     *
     * @return Zwraca listę wszystkicn pojazdów.
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

    /**
     * Zwraca pojazd na podstawie jego numeru identyfikacyjnego.
     *
     * @param nrPojazdu Unikalny nr szukanego pojazdu.
     * @return Zwraca pojazd.
     * @throws Exception Jeśli pojazd o podanym numerze nie istnieje w bazie.
     */
    public static PojazdKosmiczny dajPojazd(int nrPojazdu) throws Exception {

        ArrayList<PojazdKosmiczny> listaPojazdow = PojazdKosmiczny.dajListaPojazdow();

        for(PojazdKosmiczny pojazd: listaPojazdow) {
            if (pojazd.getNrPojazdu() == nrPojazdu) {
                return pojazd;
            }
        }
        throw new Exception("Nie znaleziono pojazdu o numerze: "+String.valueOf(nrPojazdu));
    }

    /**
     * Tworzy powiązanie między pojazdem a misją. Pojazd jest wysyłany na misję.
     *
     * @param misja Dana misja.
     */
    public void powiazPojazdZMisja(MisjaKosmiczna misja){
        this.addLink(SZFM_Enum.asocjacjaMisjaPojazd.pojazd_bierze_udzial_w_misji.toString(),
                SZFM_Enum.asocjacjaMisjaPojazd.misja_ma_przypisany_pojazd.toString(), misja);
    }

    /**
     * Metoda wewnętrzna, pomocnicza, wykorzystywana w metodzie dajUzywaneCzesci()
     *
     * @return Zwraca listę wszystkich części jakie są zamontowane w pojazdach.
     * @throws ClassNotFoundException Jeśli klasa nie istnieje.
     */
    private static Set<Czesc> getWszystkieCzesciWPojazdach() throws ClassNotFoundException {
        return wszystkieCzesciWPojazdach;
    }


    /**
     * Zwraca listę części które są używane w pojazdach.
     *
     * @return Lista części w pojazdach.
     * @throws ClassNotFoundException Jeśli klasa nie istnieje.
     */
    public static List<Czesc> dajUzywaneCzesci() throws ClassNotFoundException {

        Iterable<SondaKosmiczna> sondy = SondaKosmiczna.getExtent(SondaKosmiczna.class);
        Iterable<PromKosmiczny> promy = PromKosmiczny.getExtent(PromKosmiczny.class);
        List<Czesc> czesciUzywane = new ArrayList<>();

        for(PojazdKosmiczny sonda : sondy){
            czesciUzywane.addAll(sonda.getCzesci());
        }

        for(PojazdKosmiczny prom : promy){
            czesciUzywane.addAll(prom.getCzesci());
        }


        //return wszystkieCzesciWPojazdach;
        return czesciUzywane;
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

    /**
     * Pozwala na zmianę statusu pojazdu.
     *
     * @param status Status docelowy.
     */
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

    public List<Czesc> getCzesci() {
        return czesci;
    }
}
