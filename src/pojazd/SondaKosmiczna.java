package pojazd;

import mainPackage.SZFM_Enum;

public class SondaKosmiczna extends PojazdKosmiczny {
    private SZFM_Enum.rodzajNapedu rodzajNapedu;

    /**
     * Konstruktor klasy sonda kosmiczna.
     *
     * @param nazwa Nazwa własna sondy.
     * @param rokProdukcji Rok zakończenia produkcji sondy.
     * @param maksymalnyZasiegWParsekach Maksymalny zasięg w parsekach.
     * @param rodzajNapedu Rodzaj napędu, np. jonowy, jądrowy, spalinowy.
     */
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
