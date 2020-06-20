package pojazd;

public class PromKosmiczny extends PojazdKosmiczny {
    private int liczbaZalogi;
    private int ladownoscWTonach;
    private int gruboscPowlokiwCm;

    /**
     * Konstruktor Promu, który dziedziczy po klasie Pojazd Kosmiczny.
     *
     * @param nazwa Nazwa własna promu.
     * @param rokProdukcji Rok zakończenia produkcji promu.
     * @param maksymalnyZasiegWParsekach Maksymalny zasięg w parsekach.
     * @param liczbaZalogi Liczba załogi promu.
     * @param ladownoscWTonach Ladowność w tonach. Przeznaczenie na cargo.
     * @param gruboscPowlokiwCm Grubość powłoki ochronnej w cm.
     */
    public PromKosmiczny(String nazwa, int rokProdukcji, int maksymalnyZasiegWParsekach,
                        int liczbaZalogi, int ladownoscWTonach, int gruboscPowlokiwCm)  {
        super(nazwa, rokProdukcji, maksymalnyZasiegWParsekach);
        this.liczbaZalogi = liczbaZalogi;
        this.ladownoscWTonach = ladownoscWTonach;
        this.gruboscPowlokiwCm = gruboscPowlokiwCm;
    }

    @Override
    public String toString() {
        return "Prom: "
                + super.toString();
    }

    public int getLiczbaZalogi() {
        return liczbaZalogi;
    }

    public void setLiczbaZalogi(int liczbaZalogi) {
        this.liczbaZalogi = liczbaZalogi;
    }

    public int getLadownoscWTonach() {
        return ladownoscWTonach;
    }

    public void setLadownoscWTonach(int ladownoscWTonach) {
        this.ladownoscWTonach = ladownoscWTonach;
    }

    public int getGruboscPowlokiwCm() {
        return gruboscPowlokiwCm;
    }

    public void setGruboscPowlokiwCm(int gruboscPowlokiwCm) {
        this.gruboscPowlokiwCm = gruboscPowlokiwCm;
    }
}
