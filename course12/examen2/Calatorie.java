package examen2;

public abstract class Calatorie implements Comparable<Calatorie>  {
	
	public float pret;
	private String categorie;
	
    abstract String genereazaRezervare();
    
    public Calatorie(float pret, String categorie) {
		super();
		this.pret = pret;
		this.categorie = categorie;
	}

	@Override
	public int compareTo(Calatorie n) {
    	int lastCmp = categorie.compareTo(n.categorie);
		if (lastCmp==0)
			if (pret<n.pret)
				return -1;
			else
				if (pret>n.pret)
					return 1;
				else return 0;
		return lastCmp;
    }

	@Override
	public String toString() {
		return "Calatorie [pret=" + pret + ", categorie=" + categorie + "]";
	}
	
	
	
}
