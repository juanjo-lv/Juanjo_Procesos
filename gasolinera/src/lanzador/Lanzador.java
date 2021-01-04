package lanzador;

import java.io.IOException;

public class Lanzador {
	public static void lanzarServidor() {
		String ser = "servidor.Servidor";
		ProcessBuilder pb1;
		
		pb1 = new ProcessBuilder("cmd","/c","start","cmd.exe","/k","java","-cp","bin",ser);
		try {
			pb1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void lanzarCliente(){
		String cli = "clientes.Cliente";
		ProcessBuilder pb;
		
		pb = new ProcessBuilder("cmd","/c","start","cmd.exe","/k","java","-cp","bin",cli);
		
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		lanzarServidor();
		for (int i = 0; i < 2; i++) {
			lanzarCliente();
		}
	}

}
