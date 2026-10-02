package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static List<examen.ProdusAlimentar> lpa = new ArrayList<examen.ProdusAlimentar>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Producator p1 = new Producator("Vel Pitar", "Pitesi", 3.15f);
		Producator p2 = new Producator("Titan", "Bucuresti", 2.7f);
		Producator p3 = new Producator("Borsec", "Bihor", 2.2f);
		
		List<Producator> lp1 = new ArrayList<Producator>();
		lp1.add(p1);
		lp1.add(p2);
		
		List<Producator> lp2 = new ArrayList<Producator>();
		lp2.add(p3);
		
		ProdusAlimentar pa1 = new ProdusAlimentar("alimentar", "buc", 100, "paine", "10-01-2018", lp1);
		ProdusAlimentar pa2 = new ProdusAlimentar("alimentar", "litri", 12, "apa", "31-12-2018", lp2);
		
		//List<ProdusAlimentar> lpa = new ArrayList<ProdusAlimentar>();
		lpa.add(pa1);
		lpa.add(pa2);
		Collections.sort(lpa);
		
		for(ProdusAlimentar pa : lpa)
			System.out.println(pa);
	
		for(ProdusAlimentar pa : lpa)
			System.out.println(pa.genereazaDescriere());
		
		PrintStream ps = new PrintStream(new File("fisier.txt"));
		for(ProdusAlimentar pa : lpa)
			ps.append(pa.toString() + "\n");
		
		Fir fir1 = new Fir();
		Fir fir2 = new Fir();
		fir1.start();
		System.out.println(fir1.getId());
		fir2.start();
		System.out.println(fir2.getId());
	}
}
