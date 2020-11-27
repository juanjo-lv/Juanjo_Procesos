package lanzadores;

public class LanzaServidores {
	public static void lanzarServidores() {
		String servEco = "servidores.ServidorEco";
		String servHora = "servidores.ServidorHora";
		ProcessBuilder pbEco,pbHora;
		try {
			pbEco = new ProcessBuilder(
					"java","-cp","bin",servEco
					);
			pbHora = new ProcessBuilder(
					"java","-cp","bin",servHora
					);
			pbEco.start();
			pbHora.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		lanzarServidores();

	}

}
