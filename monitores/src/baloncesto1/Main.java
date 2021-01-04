package baloncesto1;


public class Main {
	public static void main(String[] args) {

		Partido p;
		Monitor m;
		
		// Solo tenemos un balón
		m = new Monitor(true);
		
		// Se jugarán 200 partidos
		
		for (int i=1;i<=200;i++) {			
			p=new Partido(m, i);
			p.start();
		}

	}

}
