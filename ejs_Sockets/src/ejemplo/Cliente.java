package ejemplo;
import java.net.*;
import java.io.*;
public class Cliente {
	final static String IP="localhost";
	final static int PUERTO = 6000;
	
	public static void main(String[] args) {
		
			try {
				for(int i = 1 ; i<4;i++) {
					
				
				Socket misocket = new Socket(IP,PUERTO);
				BufferedReader lectura;
				
				lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
				System.out.println("Mensaje del server: "+lectura.readLine());
				misocket.close();

				}
			
			
			//Excepciones
			} catch (UnknownHostException e) {
				System.err.println("Nombre de maquina servidora desconocida");
			}catch(ConnectException e) {
				System.err.println("El servidor no está conectado");
			}catch(SocketException e) {
				System.err.println("Error en la lectura/escritura");
			}catch(Exception e) {
				System.err.println("Error en la operacion");
			}
		

	}

}
