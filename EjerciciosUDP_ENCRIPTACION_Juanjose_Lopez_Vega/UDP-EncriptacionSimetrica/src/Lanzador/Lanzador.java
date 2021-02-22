package Lanzador;

public class Lanzador {
	public static void lanzarCliente() {
		String cli = "Ejercicio1.Cliente";
		
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
		String ser = "Ejercicio1.Servidor";
		
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
