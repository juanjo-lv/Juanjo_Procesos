package baloncesto;

public class Monitor {
	private int numBalones;
	
	public Monitor(int numeroBalones) {
		
		this.numBalones = numeroBalones;
	}
	
	public synchronized void cogeBalon(int numP) {
		//int balonUsado;
		
		while (this.numBalones<=0) {
			try {
				System.out.println("Partido " + numP + "  Bloqueado esperando por balon");
				
				wait();// Deja bloqueado el hilo que lo llama, el hilo es el Partido
				
				System.out.println("Partido " + numP + "  Desbloqueado, quedan " + numBalones + " balones antes de usar el disponible");
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		System.out.println("Partido " + numP + "  Tengo balon y juego...");
		

		numBalones--;
		
		System.out.println("Partido " + numP + "  Quedan " + numBalones + " balones.");

	}
	
	public synchronized void devuelveBalon(int numP) {			
		numBalones++;
		System.out.println("Partido " + numP + "  Devuelve balon, quedan " + numBalones + " balones");
		
		notifyAll(); 
		
		// Avisa a un hilo para desbloquearlo. Probar con los dos y ver diferencia
		//notify();
			
	}
	
}
