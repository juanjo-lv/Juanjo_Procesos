package baloncesto1;


public class Main {
	public static void main(String[] args) {

		Partido p;
		Monitor m;
		
		// Solo tenemos un bal�n
		m = new Monitor(true);
		
		// Se jugar�n 200 partidos
		
		for (int i=1;i<=200;i++) {			
			p=new Partido(m, i);
			p.start();
		}

	}

}
