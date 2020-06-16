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

    public enum asocjacjaPojazdPrzeglad{
        pojazd_w_przegladzie,przeglad_pojazdu
    }

    public enum asocjacjaPrzegladNaprawa{
        naprawa_podczas_przegladu,przeglad_z_naprawami
    }

    public enum asocjacjaPojazdCzesc{
        czesc_w_pojezdzie,pojazd_z_czescia
    }

}
