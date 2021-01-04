package loshamsters;

public class Monitor {
	private int plato,rueda;
	
	public Monitor(int plato, int rueda) {
		this.plato=plato;
		this.rueda=rueda;
	}
	
	public synchronized void cogerPlato(int numHamster) {
		while(this.plato==0){
			try{
				System.out.println("El hamster "+numHamster+" no tiene plato disponible");
				wait();
				System.out.println("El hamster "+numHamster+" ya tiene plato disponible");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
		plato--;
		System.out.println("El hamster "+numHamster+" está comiendo");
	}
	public synchronized void dejarPlato(int numHamster) {
		
		plato++;
		
		System.out.println("El hamster "+numHamster+" ha dejado de comer");
		
		notify();
	
	}
	
	public synchronized void cogerRueda(int numHamster) {
		while(this.rueda==0) {
			try {
				System.out.println("El hamster "+numHamster+" no tiene rueda disponible");
				wait();
				System.out.println("El hamster "+numHamster+" ya tiene rueda disponible");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		rueda--;
		System.out.println("El hamster "+numHamster+" está comiendo");
	}
	public synchronized void dejarRueda(int numHamster) {
		rueda++;
		
		System.out.println("El hamster "+numHamster+" ha dejado de correr");
		
		notify();
	}
}

