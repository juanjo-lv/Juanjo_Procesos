import java.io.IOException;
import java.net.*;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;

import javax.crypto.*;
import javax.swing.JOptionPane;
public class Cliente {
	public static final String IP ="localhost";
	public static final int PUERTO = 6000;
	public static void main(String[] args) {

		DatagramPacket dataEnviar=null;
		DatagramPacket dataRecibir = null;
		DatagramSocket mySocket=null;
		PublicKey  publicaServ = null;
		PrivateKey privadaServ = null;
		//claves
		PublicKey publicaCliente=null;
		PrivateKey privadaCliente=null;
		KeyPairGenerator kpg;
		KeyPair kp;
		 try {
			 InetAddress host = InetAddress.getByName(IP);
			mySocket = new DatagramSocket();
			kpg = KeyPairGenerator.getInstance("RSA");
			kp = kpg.generateKeyPair();
			publicaCliente = kp.getPublic();
			privadaCliente = kp.getPrivate();
			
			Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			//enviar publica cliente
			dataEnviar = new DatagramPacket(publicaCliente.getEncoded(), publicaCliente.getEncoded().length,host,PUERTO);
			mySocket.send(dataEnviar);
			//recibir publica serv
			
			byte[] recibirpublica = new byte[2048];
			dataRecibir = new DatagramPacket(recibirpublica,recibirpublica.length);
			mySocket.receive(dataRecibir);
			publicaServ = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(recibirpublica));
			
			//Llega la clave publica del Servidor, se usará para descifrar en el cliente
			System.out.println("La clave pública del Servidor es");
			System.out.println(publicaServ);
			
			//se inicia el cifrador con la clave publica del servidor 
			rsa.init(Cipher.ENCRYPT_MODE, publicaServ);
			String eleccion ="";
			
			do {
			 eleccion = JOptionPane.showInputDialog("Elige una opcion \n"
					+ "1. factorial de un numero \n"
					+ "2. Potencia de un numero \n"
					+ "3 Ecuacion de segundo grado");
			}while(eleccion.equalsIgnoreCase("1") && eleccion.equalsIgnoreCase("2") && eleccion.equalsIgnoreCase("3"));
			
			byte[] buffer = encriptar(eleccion, publicaServ, rsa);
			dataEnviar = new DatagramPacket(buffer, buffer.length,host,PUERTO);
			mySocket.send(dataEnviar);
			
			switch(eleccion) {
			case "1":
				String num="";
				do {
					num= JOptionPane.showInputDialog(null,"Introduce un numero");
				}while(!esNum(num));
				
				byte[] buffer2 = encriptar(num, publicaServ, rsa);
				dataEnviar = new DatagramPacket(buffer2, buffer2.length,host,PUERTO);
				mySocket.send(dataEnviar);
				
				
				byte [] buffer3 = new byte[256];
				dataRecibir = new DatagramPacket(buffer3,buffer3.length);
				mySocket.receive(dataRecibir);
			
				Cipher rsa2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				rsa2.init(Cipher.DECRYPT_MODE, privadaCliente);
				
				String sol = Servidor.desencriptar(buffer3, privadaCliente, rsa2);
				System.out.println("la sol es "+sol);
				break;
			case "2":
			     num="";
			     String num2="";
				do {
					num= JOptionPane.showInputDialog(null,"Introduce la base");
				}while(!esNum(num));
				do {
					num2= JOptionPane.showInputDialog(null,"Introduce el exponente");
				}while(!esNum(num));
				
				buffer2 = encriptar(num, publicaServ, rsa);
				dataEnviar = new DatagramPacket(buffer2, buffer2.length,host,PUERTO);
				mySocket.send(dataEnviar);
				
				buffer2 = encriptar(num2, publicaServ, rsa);
				dataEnviar = new DatagramPacket(buffer2, buffer2.length,host,PUERTO);
				mySocket.send(dataEnviar);
				
				buffer3 = new byte[256];
				dataRecibir = new DatagramPacket(buffer3,buffer3.length);
				mySocket.receive(dataRecibir);
			
				 rsa2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				rsa2.init(Cipher.DECRYPT_MODE, privadaCliente);
				
			    sol = Servidor.desencriptar(buffer3, privadaCliente, rsa2);
				System.out.println("la sol es "+sol);
				
				break;
				
			case "3":	
			     num="";
			     num2="";
			     String num3="";
				do {
					num= JOptionPane.showInputDialog(null,"Introduce el valor de x^2");
				}while(!esNum(num));
				do {
					num2= JOptionPane.showInputDialog(null,"Introduce el valor de x");
				}while(!esNum(num));
				do {
					num3= JOptionPane.showInputDialog(null,"Introduce el numero");
				}while(!esNum(num));
				
				buffer2 = encriptar(num, publicaServ, rsa);
				dataEnviar = new DatagramPacket(buffer2, buffer2.length,host,PUERTO);
				mySocket.send(dataEnviar);
				
			    buffer2 = encriptar(num2, publicaServ, rsa);
				dataEnviar = new DatagramPacket(buffer2, buffer2.length,host,PUERTO);
				mySocket.send(dataEnviar);
				
			    buffer2 = encriptar(num3, publicaServ, rsa);
				dataEnviar = new DatagramPacket(buffer2, buffer2.length,host,PUERTO);
				mySocket.send(dataEnviar);
				
				buffer3 = new byte[256];
				dataRecibir = new DatagramPacket(buffer3,buffer3.length);
				mySocket.receive(dataRecibir);
			
				rsa2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				rsa2.init(Cipher.DECRYPT_MODE, privadaCliente);
				
			    sol = Servidor.desencriptar(buffer3, privadaCliente, rsa2);
				System.out.println("la sol es "+sol);
				
				break;
				
				
			}

			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static byte[] encriptar(String texto, PublicKey clave,Cipher rsa) {
		byte[] encriptado = null;
		try {
			 encriptado = rsa.doFinal(texto.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encriptado;
		
		
	}
    public static boolean esNum(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

	
}
