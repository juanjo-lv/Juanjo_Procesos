package lanzadores;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Lanzador {
	public static void lanzarServer() {
		String serv = "servidor.Servidor";
		
		ProcessBuilder pbServ ;
		
		pbServ = new ProcessBuilder(
				"cmd","/c","start","cmd.exe","/k","java","-cp","bin",serv
				);
		try {
			pbServ.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void lanzarclientes() {
		String cli1= "clientes.Cliente";
		String cli2= "clientes.Cliente2";
		ProcessBuilder pbCli1,pbCli2;
		
		pbCli1= new ProcessBuilder("cmd","/c","start","cmd.exe","/k","java","-cp","bin",cli1);
		pbCli2 = new ProcessBuilder("cmd","/c","start","cmd.exe","/k","java","-cp","bin",cli2);
		
		try {
			pbCli1.start();
			pbCli2.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		lanzarServer();
		int num = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas salas quieres crear?"));
		
		for(int i =0;i<num;i++) {
			lanzarclientes();
		}

	}

}
