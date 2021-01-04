package interrumpir;

public class Hilo extends Thread{

	public void run() {
	try {
		while(!isInterrupted()) {
			System.out.println("estoy en el hilo");
			/*if(Thread.interrupted()) {
				System.out.println("hilo interrumpido");
				interrupt();	
			}*/
			Thread.sleep(500);
		}
	}catch(InterruptedException e) {
		System.out.println("se ha interrumpido el hilo");
	}
	

		
	}
}
