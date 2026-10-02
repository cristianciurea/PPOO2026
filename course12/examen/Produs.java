package examen;

public abstract class Produs implements Comparable<Produs> {
	
	private String tipProdus;
	private String unitateMasura;
	public int cantitate;
	
    abstract String genereazaDescriere();
    
    public Produs(String tipProdus, String unitateMasura, int cantitate) {
		super();
		this.tipProdus = tipProdus;
		this.unitateMasura = unitateMasura;
		this.cantitate = cantitate;
	}

	@Override
	public String toString() {
		return "Produs [tipProdus=" + tipProdus + ", unitateMasura="
				+ unitateMasura + ", cantitate=" + cantitate + "]";
	}

	@Override
	public int compareTo(Produs n) {
		int lastCmp = unitateMasura.compareTo(n.unitateMasura);
		if (lastCmp==0)
			if (cantitate<n.cantitate)
				return -1;
			else
				if (cantitate>n.cantitate)
					return 1;
				else return 0;
		return lastCmp;
	}	
	
}
