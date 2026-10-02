package examen2;

import java.util.ArrayList;
import java.util.List;

import examen.Producator;

public class Rezervare extends Calatorie implements IContabil {

	private int cod;
	private String locatie;
	private int durata;
	private List<Turist> turisti = new ArrayList<Turist>();
	
	public Rezervare(float pret, String categorie, int cod, String locatie,
			int durata, List<Turist> turisti) {
		super(pret, categorie);
		this.cod = cod;
		this.locatie = locatie;
		this.durata = durata;
		this.turisti = turisti;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public List<Turist> getTuristi() {
		return turisti;
	}

	public void setTuristi(List<Turist> turisti) {
		this.turisti = turisti;
	}

	@Override
	public float calculMedieCalatorii(String loc) {
		// TODO Auto-generated method stub
		float suma = 0.0f;
		for(Turist p : turisti)
				suma+= p.nrCalatorii;
		return suma/turisti.size();
	}

	@Override
	String genereazaRezervare() {
		// TODO Auto-generated method stub
		String s = "";
		for(Turist p : turisti)
			s+=p.nume+", ";
		s+="- "+this.locatie+", ";
		s+=this.durata;
		return s;
	}

	@Override
	public String toString() {
		return "Rezervare [cod=" + cod + ", locatie=" + locatie + ", durata="
				+ durata + ", turisti=" + turisti + ", toString()="
				+ super.toString() + "]";
	}

	public synchronized void plataRate(int suma)
	{
		if(suma<=this.pret)
		{
			System.out.println("Suma platita= "+suma);
			this.pret-=suma;
			System.out.println("Suma ramasa de plata= "+this.pret);
		}
		else
			System.out.println("Suma prea mare! "+suma);
	}
}
