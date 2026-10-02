package examen;

import java.util.ArrayList;
import java.util.List;

public class ProdusAlimentar extends Produs implements ICalcul {

	private String denumireProdus;
	private String dataExpirare;
	private List<Producator> producatori = new ArrayList<Producator>();
	
	public String getDenumireProdus() {
		return denumireProdus;
	}

	public void setDenumireProdus(String denumireProdus) {
		this.denumireProdus = denumireProdus;
	}

	public String getDataExpirare() {
		return dataExpirare;
	}

	public void setDataExpirare(String dataExpirare) {
		this.dataExpirare = dataExpirare;
	}

	public List<Producator> getProducatori() {
		return producatori;
	}

	public void setProducatori(List<Producator> producatori) {
		this.producatori = producatori;
	}

	public ProdusAlimentar(String tipProdus, String unitateMasura,
			int cantitate, String denumireProdus, String dataExpirare,
			List<Producator> producatori) {
		super(tipProdus, unitateMasura, cantitate);
		this.denumireProdus = denumireProdus;
		this.dataExpirare = dataExpirare;
		this.producatori = producatori;
	}
	
	@Override
	public String toString() {
		return "ProdusAlimentar [denumireProdus=" + denumireProdus
				+ ", dataExpirare=" + dataExpirare + ", producatori="
				+ producatori + ", toString()=" + super.toString() + "]";
	}

	@Override
	public float calculPretMediu(String loc) {
		// TODO Auto-generated method stub
		float suma = 0.0f;
		for(Producator p : producatori)
			if(p.localitate == loc)
				suma+= p.pretVanzare;
		return suma/producatori.size();
	}

	@Override
	String genereazaDescriere() {
		// TODO Auto-generated method stub
		String s = "";
		for(Producator p : producatori)
			s+=p.denumire+", ";
		s+="- "+this.denumireProdus+", ";
		s+=this.calculPretMediu("Bucuresti");
		return s;
	}

	public synchronized void vanzare(int cant)
	{
		if(cant<=this.cantitate)
		{
			System.out.println("Cantitate vanduta= "+cant);
			this.cantitate-=cant;
			System.out.println("Stoc= "+this.cantitate);
		}
		else
			System.out.println("Cantitate indisponibila! "+cant);
	}
}
