package Hamsters;


public class Plato {
	private int plato;

	public Plato(int plato) {

		this.plato = plato;

	}

	public synchronized void pillaPlato(int n) {

		while (this.plato == 0) {
			try {
				System.out.println("Hamster " + n + ": Espera por plato");
				wait();
				System.out.println("Hamster " + n + ": Deja de esperar por plato");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
			
		}
		
		System.out.println("Hamster " + n + ": Tengo plato y como...");
		this.plato--;

	}

	public synchronized void devolverPlato(int n) {

		this.plato++;
		System.out.println("Hamster " + n + ": Devuelvo plato");
		notify();

	}
}
