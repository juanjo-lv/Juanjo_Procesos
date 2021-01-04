package Hamsters2;

public class Main {

	public static void main(String[] args) {
		final int NHAMSTERS = 5;
		Hamster h;
		Monitor m;
		
		m=new Monitor(3,1);
		for (int i=0;i<NHAMSTERS;i++) {
			
			//h=new Hamster(new Plato(3),new Rueda(1)); ahora mando un monitor
			h = new Hamster(i, m);
			h.start();
		}
		//Cada hamster se dedica a comer y jugar indefinidamente						
	}

}
