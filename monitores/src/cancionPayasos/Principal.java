package cancionPayasos;


public class Principal {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		
		// Crea el payaso Miliki y un Nino, con un recurso compartido: el monitor
		Miliki miliki = new Miliki(monitor);
		Nino nino = new Nino(monitor);
		
		nino.start();
		miliki.start();//El orden da igual porque la variable está inicializada en el monitor para que empiece miliki
		
		// El main espera a que terminen de cantar todos
		try {
			miliki.join();
			nino.join();
		}
		catch (Exception e) {
			return;
		}
				
		System.out.println("Fin de la Cancion");

	}

}
