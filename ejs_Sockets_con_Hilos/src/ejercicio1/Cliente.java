package ejercicio1;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Cliente extends Thread {

	public static final String IP = "127.0.0.1";
	public static final int PUERTO = 5500;

	protected Socket miSocket;
	protected int numCliente;
	
	protected BufferedReader leer;
	protected PrintWriter escribir;

	protected File f;

	public Cliente(int numCliente) {
		this.numCliente=numCliente;
	}
	public void run() {

		f = new File("ejercicio1_textos/archivo.txt");
		try {
			miSocket = new Socket(IP,PUERTO);
			
			System.out.println("enviando el archivo");
			escribir = new PrintWriter(new OutputStreamWriter(miSocket.getOutputStream()),true);
			leer = new BufferedReader(new FileReader(f));
			
			String texto = leer.readLine();
			escribir.println(texto);
			
			System.out.println("Información enviada");
			
			escribir.close();
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
