package cancionPayasos;


public class Monitor {

	// Variables de bloqueo de Miliki y los ninos
	private boolean tieneQueCantarMiliki;
	//private boolean tieneQueCantarNino;


	// Constructor del Monitor
	public Monitor(){
		this.tieneQueCantarMiliki = true;
		//this.tieneQueCantarNino = false;
	}
	
	/*
	 * Mientras canta Miliki no cantan los ninos
	 * */
	
	public synchronized void cantaMiliki(String frase) {
		while (!tieneQueCantarMiliki) {
			// Espera a que canten los ninos
			try {
				wait();
			}
			catch (InterruptedException e) {
				System.out.println("Miliki no ha podido esperar a los ninos.");
			}
		}
		// Miliki ya puede cantar
		System.out.println(frase);
		tieneQueCantarMiliki = false;
		
		notifyAll();
	}
	
	/*
	 * Mientras cantan los ninos no canta Miliki
	 * */
	public synchronized void cantaNino(String frase) {
		while (tieneQueCantarMiliki) {
			// Espera a que cante Miliki
			try {
				wait();
			}
			catch (Exception e) {
				System.out.println("El nino no ha podido esperar a Miliki.");
			}
		}
		// Los ninos ya pueden cantar
		System.out.println(frase);
		tieneQueCantarMiliki = true;
		
		notifyAll();
	}
		
	
}
