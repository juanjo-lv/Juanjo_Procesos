package cancionPayasos;


public class Miliki extends Thread {

	private Monitor monitor;
	// Frases de Miliki
	String[] frasesMiliki = {"Hola Don Pepito ...", 
							 "Paso usted ya por casa ...",
							 "Vio usted a mi abuela",
							 "Adios Don Pepito"};
	// Constructor de la clase
	public Miliki(Monitor monitor) {
		this.monitor = monitor;
	}
	
	// Metodo run(). Canta cada una de las frases de Miliki
	public void run() {
		for (int i=0; i<frasesMiliki.length; i++)
			monitor.cantaMiliki(frasesMiliki[i]);
		// Cada una de las frases esta sincronizada		
	}
}
