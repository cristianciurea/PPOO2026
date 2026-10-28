package ro.ase.swing2;

public class Produs implements Comparable {

    private int cod;
    private String denumire;
    private float pret;

    public Produs(int cod, String denumire, float pret) {
        this.cod = cod;
        this.denumire = denumire;
        this.pret = pret;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "cod=" + cod +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Produs p = (Produs) o;
        return this.denumire.compareTo(p.denumire);
    }
}
