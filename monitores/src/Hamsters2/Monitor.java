package Hamsters2;

public class Monitor {

	private int plato,rueda;
	
	public Monitor(int plato, int rueda) {		
		this.plato=plato;
		this.rueda=rueda;
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
	
public synchronized void pillaRueda(int n) {
		
		while (this.rueda==0) {
			try {
				System.out.println("Hamster "+ n + ": Espera por rueda");
				wait();
				System.out.println("Hamster "+ n + ": Deja de esperar por rueda");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		System.out.println("Hamster "+ n + ": Tengo rueda y juego...");
		this.rueda--;		
				
	}
	
	public synchronized void devolverRueda(int n) {
		
		this.rueda++;
		System.out.println("Hamster "+ n +": Devuelvo rueda");
		notify();
		
	}
	
}
