package examen;

public class Producator {

	public String denumire;
	public String localitate;
	public float pretVanzare;
	public final int codFiscal = 123;
	
	public Producator(String denumire, String adresa, float pretVanzare) {
		super();
		this.denumire = denumire;
		this.localitate = adresa;
		this.pretVanzare = pretVanzare;
	}

	@Override
	public String toString() {
		return "Producator [denumire=" + denumire + ", localitate="
				+ localitate + ", pretVanzare=" + pretVanzare + ", codFiscal="
				+ codFiscal + "]";
	}
}
