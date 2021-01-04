package cancionPayasosUnicoMetodo;


public class Nino extends Thread {

	private Monitor monitor;
	// Frases de ninos
	String[] frasesNinos = {"Hola Don Jose ...", 
				"Por su casa yo pase ...",
				"A su abuela yo la vi ...",
				"Adios Don Jose"};

	// Constructor de la clase
	public Nino(Monitor monitor) {
		this.monitor = monitor;
	}
	
	// Metodo run(). Canta cada una de las frases de Miliki
	public void run() {
		for (int i=0; i<frasesNinos.length; i++) {
			//monitor.cantaNino(frasesNinos[i]);
			monitor.canta(frasesNinos[i], false);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
