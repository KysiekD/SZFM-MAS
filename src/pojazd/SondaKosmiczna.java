package pojazd;

import mainPackage.SZFM_Enum;

public class SondaKosmiczna extends PojazdKosmiczny {
    private SZFM_Enum.rodzajNapedu rodzajNapedu;

    public SondaKosmiczna(String nazwa, int nrPojazdu, int rokProdukcji, int maksymalnyZasiegWParsekach,
                          SZFM_Enum.rodzajNapedu rodzajNapedu) {
        super(nazwa, nrPojazdu, rokProdukcji, maksymalnyZasiegWParsekach);
        this.rodzajNapedu = rodzajNapedu;
    }

    @Override
    public String toString() {
        return "Sonda: " + super.toString();
    }
}
