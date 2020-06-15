package pojazd;

import mainPackage.SZFM_Enum;

public class SondaKosmiczna extends PojazdKosmiczny {
    private SZFM_Enum.rodzajNapedu rodzajNapedu;

    public SondaKosmiczna(String nazwa, int rokProdukcji, int maksymalnyZasiegWParsekach,
                          SZFM_Enum.rodzajNapedu rodzajNapedu) {
        super(nazwa, rokProdukcji, maksymalnyZasiegWParsekach);
        this.rodzajNapedu = rodzajNapedu;
    }

    @Override
    public String toString() {
        return "Sonda: " + super.toString();
    }
}
