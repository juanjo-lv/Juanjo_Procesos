package ejercicios;

import java.io.*;
import org.apache.commons.net.ftp.*;



public class DescargarFichero {
	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();

		String servidor = "localhost";
		String user = "usuario";
		String pasw = "123";

		try {
			System.out.println("Conectandose a " + servidor);
			cliente.connect(servidor);			
			cliente.enterLocalPassiveMode();
			boolean login = cliente.login(user, pasw);		

			if (login) {
				System.out.println("Login correcto");		

				//descargar fichero
				String direc = "/NUEVODIREC";
				cliente.changeWorkingDirectory(direc); 		

		
				
				//stream de salida para recibir el fichero descargado
				BufferedOutputStream out =
						new BufferedOutputStream(new FileOutputStream("nuevo.txt"));

				if (cliente.retrieveFile("texto.txt", out))
					// El primero es el que se busca en el dir actual para bajarlo con // el nombre del segundo, dado por el stream creado
					// Si ya existe, lo machaca
					System.out.println("Recuperado correctamente... ");
				else
					System.out.println("No se ha podido descargar... ");

				out.close();

				cliente.logout();
				cliente.disconnect();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}//main

}
