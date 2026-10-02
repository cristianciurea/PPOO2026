package examen2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static List<Rezervare> lpa = new ArrayList<Rezervare>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Turist t1 = new Turist("Gigel", 3);
		Turist t2 = new Turist("Dorel", 7);
		Turist t3 = new Turist("Maricica", 2);
		
		List<Turist> lp1 = new ArrayList<Turist>();
		lp1.add(t1);
		lp1.add(t2);
		
		List<Turist> lp2 = new ArrayList<Turist>();
		lp2.add(t3);
		
		Rezervare r1 = new Rezervare(1200, "vacanta", 123, "Roma", 3, lp1);
		Rezervare r2 = new Rezervare(800, "business", 456, "Riga", 5, lp2);
		
		lpa.add(r1);
		lpa.add(r2);
		Collections.sort(lpa);
		
		for(Rezervare pa : lpa)
			System.out.println(pa);
	
		for(Rezervare pa : lpa)
			System.out.println(pa.genereazaRezervare());
		
		PrintStream ps = new PrintStream(new File("fisier.txt"));
		for(Rezervare pa : lpa)
			ps.append(pa.toString() + "\n");
		
		Fir fir1 = new Fir();
		Fir fir2 = new Fir();
		fir1.start();
		System.out.println(fir1.getId());
		fir2.start();
		System.out.println(fir2.getId());
	}

}
