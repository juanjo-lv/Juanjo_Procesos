package Hamsters;

public class Main {

	public static void main(String[] args) {
		final int NUMHAMSTERS = 5;
		Hamster h;
	
		Plato platos = new Plato(3);
		Rueda ruedas = new Rueda(1);
		
		for (int i = 1; i <= NUMHAMSTERS; i++) {
			h = new Hamster(i, platos, ruedas); // Los dos elementos son compartidos
			h.start();
		}
		// Cada hamster se dedica a comer y jugar indefinidamente
	}

}