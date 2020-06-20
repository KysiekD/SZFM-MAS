package ogolne;

import mainPackage.ObjectPlusPlus;
import mainPackage.SZFM_Enum;
import pracownik.Pracownik;

import java.util.Date;

public class UdzialWMisji extends ObjectPlusPlus {
    private Date dataRozpoczeciaPracy;
    private Date dataZakonczeniaPracy;
    private String nazwaStanowiska;
    private MisjaKosmiczna misja;
    private Pracownik pracownik;

    /**
     * Konstruktor klasy. Jest to klasa pośrednicząca, czyli klasa asocjacyjna między misją a pracownikiem.
     *
     * @param dataRozpoczeciaPracy Informacja o dniu rozpoczęcia pracy przy danej misji przez pracownika.
     * @param dataZakonczeniaPracy Dzień zakończenia pracy przy misji.
     * @param nazwaStanowiska Stanowisko na jakim przydzielony został pracownik.
     * @param misja Powiązana misja.
     * @param pracownik Powiązany pracownik.
     */
    public UdzialWMisji(Date dataRozpoczeciaPracy, Date dataZakonczeniaPracy, String nazwaStanowiska,
                        MisjaKosmiczna misja, Pracownik pracownik) {
        super();
        this.misja=misja;
        this.pracownik=pracownik;
        this.dataRozpoczeciaPracy = dataRozpoczeciaPracy;
        this.dataZakonczeniaPracy = dataZakonczeniaPracy;
        this.nazwaStanowiska = nazwaStanowiska;
        powiazMisjeZPracownikiem(misja,pracownik);
    }

    /**
     * Tworzy powiązanie misji z pracownikiem. Klasa używana w konstruktorze.
     *
     * @param misja Dana misja.
     * @param pracownik Dany pracownik.
     */
    private void powiazMisjeZPracownikiem(MisjaKosmiczna misja, Pracownik pracownik){
        misja.addLink(SZFM_Enum.asocjacjaMisjaUdzialPracownik.misja_z_pracownikiem.toString(),
                SZFM_Enum.asocjacjaMisjaUdzialPracownik.udzial_pracownika.toString(),this);
        pracownik.addLink(SZFM_Enum.asocjacjaMisjaUdzialPracownik.misja_z_pracownikiem.toString(),
                SZFM_Enum.asocjacjaMisjaUdzialPracownik.udzial_w_misji.toString(),this);
    }

    public double wyliczCzasTrwania(){
        //..
        return 0.0;
    }
}
