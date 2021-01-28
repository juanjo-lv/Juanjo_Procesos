package codigoFTP;

import java.io.IOException;
import java.net.SocketException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;



public class Servidor {
	public static final String DIRECCION ="/";
	
	public static void conectarServer(String nomServ,String usuario,String pass,String direc) {
		try {
			FTPClient cliente=new FTPClient();
			cliente.connect(nomServ);
		
			System.out.println("Conectando a servidor "+nomServ);
			cliente.enterLocalPassiveMode();
			
			boolean login = cliente.login(usuario, pass);
			if(login) {
				JOptionPane.showMessageDialog(null, "Conectado correctamente");
				
				//si no puede cambiar al directorio direc es que no existe, entonces lo crea
				if (!cliente.changeWorkingDirectory(direc)) {
					String directorio = "/NUEVODIREC";

					
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
			System.out.println("error al conectar");
		 
		} catch (IOException e) {
			
			System.out.println("error al conectar");
			
		}
		
	}
}
