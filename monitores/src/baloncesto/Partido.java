package baloncesto;

public class Partido extends Thread {	
	private Monitor m;
	private int i;
	
	public Partido(int i, Monitor m) {	
		this.m = m;
		this.i = i;
	}
	
	public void run() {	
// 		Si pongo los comentarios aquí, no controlo en qué momento se escriben
// 		tienen que estar en un método sincronizado
		
//		System.out.println("Partido " + i + "  Voy a coger el balon " +  ());
//	
//		System.out.println("Partido " + i + "  Tengo balon y juego...");
		
		m.cogeBalon(i);
		
		try {
			Thread.sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		m.devuelveBalon(i);
				
	}
		
}
