package pojazd;

public class PromKosmiczny extends PojazdKosmiczny {
    private int liczbaZalogi;
    private int ladownoscWTonach;
    private int gruboscPowlokiwCm;

    public PromKosmiczny(String nazwa, int nrPojazdu, int rokProdukcji, int maksymalnyZasiegWParsekach,
                        int liczbaZalogi, int ladownoscWTonach, int gruboscPowlokiwCm) {
        super(nazwa, nrPojazdu, rokProdukcji, maksymalnyZasiegWParsekach);
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
