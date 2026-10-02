package examen;

public class Fir extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			try{
				System.out.println("Se incearca o noua vanzare...");
				Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
			for(ProdusAlimentar pa : Main.lpa)
				pa.vanzare((int)(Math.random()*50));
		}
	}
}
