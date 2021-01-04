package loshamsters;

public class Main {

	public static void main(String[] args) {
		final int NUMHAMSTERS = 5;
		
		Hamster h ;
		
		Monitor m = new Monitor(5,4);
		
		Plato plato = new Plato(4);
		Rueda rueda = new Rueda(3);
		
		for(int i=0;i<NUMHAMSTERS;i++){
			h = new Hamster(i,m);
			h.start();
		
		}
		

	}

}
