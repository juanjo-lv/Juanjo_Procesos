package Hamsters;

public class Rueda {
	private int rueda;	
	
	public Rueda(int rueda) {
		
		this.rueda=rueda;
	
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
