package Actividades;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Actividad2 {
	public static final String USUARIO = "usuario";
	public static final String PASS = "123";
	public static void main(String[] args) {
		FTPClient cliente=new FTPClient();
		String nombre = "perrete.png";
		String nombre2 = "gato.jpg";
		String nombre3 = "coche.jpg";
		
		String ruta = "C:\\Users\\juanj\\Desktop\\fotosPrueba\\"+nombre;
		String ruta2="C:\\Users\\juanj\\Desktop\\fotosPrueba\\"+nombre2;
		String ruta3="C:\\Users\\juanj\\Desktop\\fotosPrueba\\"+nombre3;
		

		
		String direc = "/NUEVODIREC";
		cliente = conectarServer("localhost",USUARIO,PASS,cliente,direc);
		
		subirArchivo(cliente,ruta,nombre);
		subirArchivo(cliente,ruta2,nombre2);
		subirArchivo(cliente,ruta3,nombre3);
		
		cambiarListarDirectorio(direc,cliente);
		renombrarFichero(direc,cliente,nombre,"perro.png");
		cambiarListarDirectorio(direc,cliente);
		
		borrarFichero(direc,cliente,"perro.png");
		cambiarListarDirectorio(direc,cliente);
	}
	public static FTPClient conectarServer(String nomServ,String usuario,String pass, FTPClient cliente,String direc) {
		try {
			cliente.connect(nomServ);
		
			System.out.println("Conectando a servidor "+nomServ);
			cliente.enterLocalPassiveMode();
			
			boolean login = cliente.login(usuario, pass);
			if(login) {
				System.out.println("Conectado correctamente");
				
				//si no puede cambiar al directorio direc es que no existe, entonces lo crea
				if (!cliente.changeWorkingDirectory(direc)) {
					String directorio = "NUEVODIREC";

					
					//crea el directorio en la ruta 
					if (cliente.makeDirectory(directorio)) {
						System.out.println("Directorio :  " + 
								directorio + " creado ...");
						cliente.changeWorkingDirectory(directorio);
					} else {
						System.out.println("No se ha podido crear el Directorio");
						System.exit(0);
					}

				}
				
				
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
	public static void subirArchivo(FTPClient cliente,String ruta,String nombre) {
		try {
			
			BufferedInputStream in =
					new BufferedInputStream(new FileInputStream(ruta));
			try {
				cliente.setFileType(cliente.BINARY_FILE_TYPE);
				if(cliente.storeFile(nombre, in)) {
					System.out.println("Archivo subido...");
					in.close();
				}else {
					System.out.println("No se puede subir el archivo");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void cambiarListarDirectorio(String nombre, FTPClient cliente) {
		try {
			cliente.changeWorkingDirectory(nombre);
			System.out.println("Directorio actual :"+cliente.printWorkingDirectory());
			FTPFile[] ficheros = cliente.listFiles();
			for (int i = 0; i < ficheros.length; i++) {
				System.out.println("\t"+ficheros[i].getName()+" --> "+(ficheros[i].getSize()/1000)+"KB");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void renombrarFichero(String direc,FTPClient cliente,String nombre,String nuevoNombre) {
		//Renombrar ficheros
	
		try {
			cliente.changeWorkingDirectory(direc);
			if(cliente.rename(nombre, nuevoNombre))
				System.out.println("Fichero renombrado... ");
			else
				System.out.println("No se ha podido renombar el Fichero... ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void borrarFichero(String direc,FTPClient cliente, String nombre) {
		try {
			cliente.changeWorkingDirectory(direc);
			if(cliente.deleteFile(nombre)) {
				System.out.println("fichero eliminado con exito");
			}else {
				System.out.println("No se ha podido borrar el fichero");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
