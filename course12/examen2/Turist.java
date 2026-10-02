package examen2;

public class Turist {
	
	public String nume;
	public int nrCalatorii;
	public final String CNP = "123";
	
	public Turist(String nume, int nrCalatorii) {
		super();
		this.nume = nume;
		this.nrCalatorii = nrCalatorii;
	}

	@Override
	public String toString() {
		return "Turist [nume=" + nume + ", nrCalatorii=" + nrCalatorii
				+ ", CNP=" + CNP + "]";
	}
	
	
	
}
