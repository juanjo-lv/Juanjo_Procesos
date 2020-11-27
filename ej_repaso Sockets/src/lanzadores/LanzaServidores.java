package lanzadores;

public class LanzaServidores {
	public static void lanzarServidores() {
		String servEco = "servidores.ServidorEco";
		String servHora = "servidores.ServidorHora";
		ProcessBuilder pbEco,pbHora;
		try {
			pbEco = new ProcessBuilder(
					"cmd","/c","start","cmd.exe","/k","java","-cp","bin",servEco
					);
			pbHora = new ProcessBuilder(
					"cmd","/c","start","cmd.exe","/k","java","-cp","bin",servHora
					);
			pbEco.start();
			System.out.println("cliente Eco lanzado");
			pbHora.start();
			System.out.println("cliente Hora lanzado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		lanzarServidores();

	}

}
