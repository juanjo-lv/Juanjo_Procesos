package lanzador;

public class Lanzador {
	public static void lanzarCliente() {
		String cli = "cliente_servidor.Cliente";
		
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(
					"cmd","/c","start","cmd.exe","/k","java","-cp","bin",cli
					);
			pb.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void lanzarServ() {
		String ser = "cliente_servidor.Servidor";
		
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(
					"cmd","/c","start","cmd.exe","/k","java","-cp","bin",ser
					);
			pb.start();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	public static void main(String[] args) throws InterruptedException {
		lanzarServ();
		lanzarCliente();
	}

}