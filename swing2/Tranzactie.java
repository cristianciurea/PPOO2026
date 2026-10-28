package ro.ase.swing2;

public class Tranzactie {

    private int codProdus;
    private int cantitate;
    private String tip;

    public Tranzactie(int codProdus, int cantitate, String tip) {
        this.codProdus = codProdus;
        this.cantitate = cantitate;
        this.tip = tip;
    }

    public int getCodProdus() {
        return codProdus;
    }

    public void setCodProdus(int codProdus) {
        this.codProdus = codProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "codProdus=" + codProdus +
                ", cantitate=" + cantitate +
                ", tip='" + tip + '\'' +
                '}';
    }
}
