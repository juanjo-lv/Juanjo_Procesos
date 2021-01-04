package parar;

public class Hilo extends Thread{
	private boolean parar = false;
	
	public void pararHilo() {
		parar = true;
	}
	
	public void run() {
		while(!parar) {
			System.out.println("En el hilo");
		}
		System.out.println("Fuera de tu puto hilo");
	}
}
