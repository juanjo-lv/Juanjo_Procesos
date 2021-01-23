package Actividades;
import java.io.*;
import java.net.*;
import java.util.Iterator;

import org.apache.commons.net.ftp.*;

public class Actividad1 {
	
	public static final String USUARIO = "anonymous";
	public static final String CLAVE = "anonymous";
	
	public static void main(String[] args){

		FTPClient cliente = new FTPClient();
		FTPClient cliente2 = new FTPClient();
		
		String servidor = "ftp.rediris.es";
		String servidor2 = "ftp.freebsd.org";

		//rediris
			cliente = conectarServer(servidor,USUARIO,CLAVE,cliente);
			
			
			cambiarListarDirectorio("/",cliente);
			cambiarListarDirectorio("debian",cliente);
			cambiarListarDirectorio("/debian-cd",cliente);
			
		//mozilla no me funciona. freebsd sí
			
		cliente2 = conectarServer(servidor2,USUARIO,CLAVE,cliente2);
		cambiarListarDirectorio("/",cliente2);
		cambiarListarDirectorio("/pub",cliente2);

	}
	public static FTPClient conectarServer(String nomServ,String usuario,String pass, FTPClient cliente) {
		try {
			cliente.connect(nomServ);
			System.out.println("Conectando a servidor "+nomServ);
			cliente.enterLocalPassiveMode();
			
			boolean login = cliente.login(usuario, pass);
			if(login) {
				System.out.println("Conectado correctamente");
				
			}else{
				System.out.println("Error al conectar");
				cliente.disconnect();
				System.exit(1);
			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	public static void cambiarListarDirectorio(String nombre, FTPClient cliente) {
		try {
			cliente.changeWorkingDirectory(nombre);
			System.out.println("Directorio actual :"+cliente.printWorkingDirectory());
			FTPFile[] ficheros = cliente.listFiles();
			for (int i = 0; i < ficheros.length; i++) {
				System.out.println("\t"+ficheros[i].getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
