package baloncesto1;

public class Monitor {

	private boolean balonDisponible;
	// A diferencia del productor consumidor, cada partido se encarga de coger y soltar el balón
	// pero no se puede jugar otro partido si no se ha liberado el balón.
	
	public Monitor(boolean disp) {		
		this.balonDisponible=disp;
	}
	
	public synchronized void cogeBalon(int numP) {	
		while (!balonDisponible) {
			try {
				System.out.println("Partido " + numP + "  bloqueado esperando por balon");
				wait();
				System.out.println("Partido " + numP + "  desbloqueado porque ya tiene balon.");
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		System.out.println("Partido " + numP + "  Usa balon ");
		balonDisponible = false;	
		
	}
	
	
	// Al dividirlo en 2, se pueden encolar peticiones de otros partidos
	public synchronized void devuelveBalon(int numP){	
		
		balonDisponible = true;	
		System.out.println("Partido " + numP + "  Devuelve balon ");
		
		// Avisa a todos los hilos para desbloquearlo
		// notifyAll(); 
		// Solo avisa a un hilo para desbloquearlo
		
		notify();		
	}
	
}
