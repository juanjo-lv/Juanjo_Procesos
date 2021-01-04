package baloncesto;

public class Main {

	public static void main(String[] args) {
		Partido p;
		Monitor m;
		final int NUMPARTIDOS = 200;// Se jugarán 200 partidos
		final int NUMBALONES = 8;// Hay 8 balones
		
		m = new Monitor(NUMBALONES);
				
		for (int i=1;i<=NUMPARTIDOS;i++) {			
			p=new Partido(i, m);
			p.start();
		}

	}

}
