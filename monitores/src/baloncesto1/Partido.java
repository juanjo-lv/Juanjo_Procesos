package baloncesto1;


public class Partido extends Thread {
	
	private Monitor m;
	private int i;
	
	public Partido(Monitor m, int i) {	
		this.m=m;
		this.i = i;
	}
	
	public void run() {		
		System.out.println("Partido " + i + " Va a coger el balon ");
		
		m.cogeBalon(i);
		
		System.out.println("Partido " + i + " Tiene balon y juega...");
		
		//Según el orden cambian los mensajes que se escriben
		
		try {
			Thread.sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		m.devuelveBalon(i);
		
		System.out.println("Partido " + i + " termina y ya devolvio el balon ");	
	}
		
}
