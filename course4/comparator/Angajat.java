package ase.course4.comparator;

import java.util.Comparator;
import java.util.Objects;

public class Angajat implements Comparable<Angajat> {

	private int id;
	private String nume;
	private int varsta;
	private long salariu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public long getSalariu() {
		return salariu;
	}

	public void setSalariu(long salariu) {
		this.salariu = salariu;
	}

	public Angajat(int id, String nume, int varsta, long salariu) {
		super();
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
		this.salariu = salariu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Angajat angajat)) return false;
        return getId() == angajat.getId() && getVarsta() == angajat.getVarsta() && getSalariu() == angajat.getSalariu() && Objects.equals(getNume(), angajat.getNume());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getNume(), getVarsta(), getSalariu());
	}

	@Override
	public int compareTo(Angajat a) {
		// TODO Auto-generated method stub
		return (this.id - a.id);
	}

	@Override
	public String toString() {
		return "Angajat [id=" + id + ", nume=" + nume + ", varsta=" + varsta
				+ ", salariu=" + salariu + "]";
	}
	
	public static Comparator<Angajat> salariuComp = new Comparator<Angajat>()
			{
				@Override
				public int compare(Angajat a1, Angajat a2) 
				{
					return (int)(a1.salariu - a2.salariu);
				}
			};
			
			public static Comparator<Angajat> varstaComp = new Comparator<Angajat>()
					{
						@Override
						public int compare(Angajat a1, Angajat a2) 
						{
							return (a1.varsta - a2.varsta);
						}
					};

					public static Comparator<Angajat> numeComp = new Comparator<Angajat>()
							{
								@Override
								public int compare(Angajat a1, Angajat a2) 
								{
									return a1.getNume().compareTo(a2.getNume());
								}
							};
}
