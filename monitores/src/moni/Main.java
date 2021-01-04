package moni;

public class Main {

	public static void main(String[] args) {
		final int NUM_HAMSTERS=10;
		
		Rueda ruedas= new Rueda(5);
		Comedero comedero = new Comedero(3);
		Hamster h=null;
		for (int i = 1; i <= NUM_HAMSTERS; i++) {
			h = new Hamster(i,ruedas,comedero);
			h.start();

		}
		try {
			h.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TODOS LOS HAMSTERS HAN HECHO SUS MOVIDAS");
	}

}
