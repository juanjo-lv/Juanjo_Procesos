package lanzadores;

public class LanzaCliente {

	public static void lanzarCliente() {
		String cli = "clientes.Cliente";
		
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(
					"java","-cp","bin",cli
					);
			pb.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		lanzarCliente();

	}
}
