package mainPackage;

public class SZFM_Enum {
    public enum statusPojazdu{
        gotowy,przydzielonyDoMisji,wycofanyZeSluzby,zezlomowany
    }

    public enum statusPrzegladu{
        ukonczonyPozytywnie, ukonczonyNegatywnie
    }

    public enum statusNaprawy{
        udana, nieudana
    }

    public enum rodzajNapedu{
        spalinowy, jadrowy,jonowy
    }


    public enum kraj{
        Polska, Niemcy, Francja, WlkBrytania
    }

    public enum specjalizacjaNaukowa{
        fizyka,biologia,matematyka,chemia
    }

    public enum tytulNaukowy{
        magister, doktor, profesor
    }

    public enum wynikTestowSprawnosciowych{
        zdane, niezdane
    }

    public enum statusMisji{
        w_przygotowaniu, w_drodze_do_celu, w_drodze_powrotnej, zakonczona_sukcesem, zakonczona_niepowodzeniem
    }

    public enum asocjacjaMisjaUdzialPracownik{
        misja_z_pracownikiem, pracownik_w_misji, udzial_pracownika, udzial_w_misji
    }

    public enum asocjacjaInzynierPrzeglad{
        przeglad_prowadzony_przez_inzyniera, inzynier_prowadzacy_przeglad
    }

    public enum asocjacjaKompozycjaPracownik{
        pracownik, posiada_inzyniera, posiada_kosmonaute,posiada_naukowca
    }

    public enum asocjacjaPojazdPrzeglad{
        pojazd_w_przegladzie,przeglad_pojazdu
    }

    public enum asocjacjaPrzegladNaprawa{
        naprawa_podczas_przegladu,przeglad_z_naprawami
    }

    public enum asocjacjaPojazdCzesc{
        czesc_w_pojezdzie,pojazd_z_czescia
    }

    public enum asocjacjaCzescNaprawa{
        czesc_wyrzucona_podczas_naprawy, naprawa_z_wyrzucona_czescia,
        czesc_dodana_podczas_naprawy, naprawa_z_dodana_czescia
    }

    public enum asocjacjaPlacowkaPrzeglad{
        placowka_przeprowadzajaca_przeglad, przeglad_odbywa_sie_w_placowce
    }

}
