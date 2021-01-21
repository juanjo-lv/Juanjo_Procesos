package ejercicios;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class SubirFichero {
	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();

		String servidor = "localhost";
		String user = "usuario";
		String pasw = "123";

		try {
			System.out.println("Conectandose a " + servidor);

			/* lo puse lo de abajo porque daba error de conexion cerrada, pero al final lo 
			 * que hay que hacer es:
			 * netsh advfirewall set global StatefulFTP disable
			 * */
			/*
		   cliente.setConnectTimeout(30000);
		   cliente.setControlKeepAliveTimeout(60);
		   cliente.setControlKeepAliveReplyTimeout(3000);
			 */ 

			cliente.connect(servidor);
			System.out.println("Conectado");
			boolean login = cliente.login(user, pasw);

			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			String direc = "/NUEVODIREC";
			cliente.enterLocalPassiveMode();

			if (login) {				
				System.out.println("Login correcto");

				if (!cliente.changeWorkingDirectory(direc)) {
					String directorio = "NUEVODIREC";

					// Lo crea o busca en el directorio del usuario1

					if (cliente.makeDirectory(directorio)) {
						System.out.println("Directorio :  " + 
								directorio + " creado ...");
						cliente.changeWorkingDirectory(directorio);
					} else {
						System.out.println("No se ha podido crear el Directorio");
						System.exit(0);
					}

				}

				System.out.println("Directorio actual: "
						+ cliente.printWorkingDirectory());

				String archivo ="C:\\Users\\juanj\\Desktop\\foto.png";			 
				BufferedInputStream in =
						new BufferedInputStream(new FileInputStream(archivo));

				if (cliente.storeFile("foto.png", in)) {									//cliente.completePendingCommand(); 
					System.out.println("Subido correctamente... ");
				}
				else
					System.out.println("No se ha podido subir el fichero... ");
				//

				//Renombrar ficheros
				direc="/NUEVODIREC";
				cliente.changeWorkingDirectory(direc);
				if(cliente.rename("foto.png", "fotoperro.png"))
					System.out.println("Fichero renombrado... ");
				else
					System.out.println("No se ha podido renombar el Fichero... ");
				
				

				//Eliminar fichero
				direc="/NUEVODIREC/fotoperro.png";
				if (cliente.deleteFile(direc))
					System.out.println("Fichero eliminado... ");
				else
					System.out.println("No se ha podido eliminar Fichero... ");

				

				in.close(); // Cerrar flujo
				cliente.logout();
				cliente.disconnect();
			}
			else System.out.println("No logueado");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}// main

}// 
