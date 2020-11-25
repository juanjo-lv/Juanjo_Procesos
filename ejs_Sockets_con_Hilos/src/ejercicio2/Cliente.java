package ejercicio2;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Cliente extends Thread {

	public static final String IP = "127.0.0.1";
	public static final int PUERTO = 5500;

	protected Socket miSocket;
	protected int numCliente;
	
	protected DataInputStream dis;
	protected DataOutputStream dos;

	protected File f;

	public Cliente(int numCliente) {
		this.numCliente=numCliente;
	}
	public void run() {

		f = new File("ejercicio2_archivos/foto.jpeg");
		try {
			miSocket = new Socket(IP,PUERTO);
			
			System.out.println("enviando el archivo");
			dos = new DataOutputStream((miSocket.getOutputStream()));
			FileInputStream fis = new FileInputStream(f);
			dis = new DataInputStream (fis); 
			
			String ruta = "ejercicio2_archivos/foto.jpeg";
			dos.writeUTF(ruta);
			dos.flush();
			System.out.println("Información enviada");
			
			dos.close();
			miSocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		//Podría hacerlo con un lanzador pero aún me lia un poco y lo he dejado así me lo tengo que mirar más en profundidad
		
		int numCli;
		Cliente cli;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero de clientes: ");
		
		numCli = sc.nextInt();
		System.out.println();
		
		for(int i =1;i<=numCli;i++) {
			cli = new Cliente(i);
			cli.start();
		}

	}

}
