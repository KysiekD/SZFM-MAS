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
        pojazd,przeglad
    }

}
