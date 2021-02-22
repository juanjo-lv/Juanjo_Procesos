package cliente_servidor;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.*;
public class Servidor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int puerto = 6000;
		DatagramSocket socket = null;
		DatagramPacket dataEnviar = null;
		DatagramPacket dataRecibir = null;
		byte[] buffer;


		try {
			socket = new DatagramSocket(puerto);
			System.out.println("Servidor iniciado");
			KeyPairGenerator kpg;
			KeyPair kp;

			PublicKey  publicaServ = null;
			PrivateKey privadaServ = null;

			PublicKey publicaCliente=null;
			PrivateKey privadaCliente=null;

			while(true){
				//generar clave publica y privada del Servidor
				kpg = KeyPairGenerator.getInstance("RSA");
				kp = kpg.generateKeyPair();
				publicaServ = kp.getPublic();
				privadaServ = kp.getPrivate();

				// guardar claves en ficheros
				//esto si voy sobrao después

				/*recibir clave del cliente, usa para encriptar en el servidor*/
				buffer = new byte[2048];
				dataRecibir = new DatagramPacket(buffer,buffer.length);
				socket.receive(dataRecibir);
				publicaCliente = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(buffer));
			
				System.out.println("La clave publica del Cliente es:");
				System.out.println(publicaCliente);
				
				
				dataEnviar = new DatagramPacket(publicaServ.getEncoded(), publicaServ.getEncoded().length,dataRecibir.getAddress(),dataRecibir.getPort());
				socket.send(dataEnviar);
				
				Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				rsa.init(Cipher.DECRYPT_MODE, privadaServ);
				
				buffer = new byte[256];
				dataRecibir = new DatagramPacket(buffer,buffer.length);
				socket.receive(dataRecibir);
				String texto_recibido = desencriptar(buffer, privadaServ, rsa);
				
				
				switch(texto_recibido) {
				case "1":
					System.out.println("has elegido calcular el factorial");
					buffer = new byte[256];
					dataRecibir = new DatagramPacket(buffer,buffer.length);
					socket.receive(dataRecibir);
					String cad1= desencriptar(buffer, privadaServ, rsa);
					
					int num = Integer.parseInt(cad1);
				
					int factorial = factorial(num);
					String sol = Integer.toString(factorial);
					System.out.println(sol);
					
					Cipher rsa2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
					rsa2.init(Cipher.ENCRYPT_MODE, publicaCliente);
				    byte[] buffer2 = Cliente.encriptar(sol, publicaCliente, rsa2);
					dataEnviar = new DatagramPacket(buffer2, buffer2.length,dataRecibir.getAddress(),dataRecibir.getPort());
					socket.send(dataEnviar);
					
					break;
				case "2":
					System.out.println("has elegido elevar un numero a una potencia");
					buffer = new byte[256];
					dataRecibir = new DatagramPacket(buffer,buffer.length);
					socket.receive(dataRecibir);
				    cad1= desencriptar(buffer, privadaServ, rsa);
					
					byte[] buffer_num2 = new byte[256];
					dataRecibir = new DatagramPacket(buffer_num2,buffer_num2.length);
					socket.receive(dataRecibir);
				    String cad2= desencriptar(buffer_num2, privadaServ, rsa);
				    Double d1 = Double.parseDouble(cad1);
				    Double d2 = Double.parseDouble(cad2);
				    Double resul = Math.pow(d1, d2);
				    String resultado = Double.toString(resul);
				    System.out.println("Procesando los datos...");
				    			
					rsa2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
					rsa2.init(Cipher.ENCRYPT_MODE, publicaCliente);
				    buffer2 = Cliente.encriptar(resultado, publicaCliente, rsa2);
					dataEnviar = new DatagramPacket(buffer2, buffer2.length,dataRecibir.getAddress(),dataRecibir.getPort());
					socket.send(dataEnviar);
				
					break;
				case "3":	
					System.out.println("has elegido calcular la ecuación de segundo grado");
					buffer = new byte[256];
					dataRecibir = new DatagramPacket(buffer,buffer.length);
					socket.receive(dataRecibir); 
				    cad1= desencriptar(buffer, privadaServ, rsa);
					
				    buffer= new byte[256];
					dataRecibir = new DatagramPacket(buffer,buffer.length);
					socket.receive(dataRecibir);
				    cad2= desencriptar(buffer, privadaServ, rsa);

				    buffer= new byte[256];
					dataRecibir = new DatagramPacket(buffer,buffer.length);
					socket.receive(dataRecibir);
				    String cad3= desencriptar(buffer, privadaServ, rsa);
				    	
				    Double a = Double.parseDouble(cad1);
				    Double b = Double.parseDouble(cad2);
				    Double c = Double.parseDouble(cad3);
				    System.out.println("Procesando los datos...");
				    String solucion ="";
				    
				    
				        double x1 = (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);
				        double x2 = (-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
				        String solucion1 = Double.toString(x1);
				        String solucion2 = Double.toString(x2);
				        if(solucion1.equalsIgnoreCase("NaN") && solucion2.equalsIgnoreCase("NaN")) {
				        	solucion = "La ecuacion no tiene solucion en el conjunto de  R";
				        }else {
				        	solucion = "la solucion es "+x1+" y "+x2;
				        }
				        
					rsa2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
					rsa2.init(Cipher.ENCRYPT_MODE, publicaCliente);
				    buffer2 = Cliente.encriptar(solucion, publicaCliente, rsa2);
					dataEnviar = new DatagramPacket(buffer2, buffer2.length,dataRecibir.getAddress(),dataRecibir.getPort());
					socket.send(dataEnviar);
					
					break;
				}
			



			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String desencriptar(byte[] texto, PrivateKey clave, Cipher rsa) {
		byte[] desencriptado = null;
		String textoDesencriptado=null;
		 try {
			desencriptado = rsa.doFinal(texto);
		    textoDesencriptado = new String(desencriptado);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return textoDesencriptado;
	}	
    public static int factorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
	
}	

