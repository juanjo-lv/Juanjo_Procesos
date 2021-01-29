package asimetrico;

// Ejemplo de uso de clave asim�trica:
// se generan dos claves asociadas: publica y privada,
// el emisor encripta con la clave publica del receptor y manda el mensaje
// el receptor usa su clave privada para desencriptar el mensaje
import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;

public class GestorCifrado {
	KeyPair claves;
	KeyPairGenerator generadorClaves;
	Cipher cifrador;
	final static int TAM = 1024;

	public GestorCifrado() throws NoSuchAlgorithmException, NoSuchPaddingException {
		generadorClaves = KeyPairGenerator.getInstance("RSA");
		// Clave asim�trica: es decir 2 claves una p�blica y una privada asociada
		/*
		 * Usaremos una longitud de clave de 1024 bits
		 */
		generadorClaves.initialize(TAM);
		claves = generadorClaves.generateKeyPair();
		cifrador = Cipher.getInstance("RSA");
	}

	public PublicKey getPublica() {
		return claves.getPublic();
	}

	public PrivateKey getPrivada() {
		return claves.getPrivate();
	}

	public byte[] cifrar(byte[] paraCifrar, Key claveCifrado)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] resultado;
		/* Se pone el cifrador en modo cifrado */
		cifrador.init(Cipher.ENCRYPT_MODE, claveCifrado);
		resultado = cifrador.doFinal(paraCifrar);

		return resultado;
	}

	public byte[] descifrar(byte[] paraDescifrar, Key claveDescifrado)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] resultado;

		/* Se pone el cifrador en modo descifrado */
		cifrador.init(Cipher.DECRYPT_MODE, claveDescifrado);
		resultado = cifrador.doFinal(paraDescifrar);

		return resultado;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		GestorCifrado gestorCifrado = new GestorCifrado();

		String mensajeOriginal = "Hola mundo";

		Key clavePublica = gestorCifrado.getPublica();

		byte[] mensajeCifrado = gestorCifrado.cifrar(mensajeOriginal.getBytes(), clavePublica);

		String cadCifrada = new String(mensajeCifrado, "UTF-8");

		System.out.println("Cadena original:" + mensajeOriginal);
		System.out.println("Cadena cifrada:" + cadCifrada);

		/* Cogemos la cadCifrada y la desciframos con la otra clave, la privada */
		Key clavePrivada = gestorCifrado.getPrivada();

		byte[] descifrada = gestorCifrado.descifrar(mensajeCifrado, clavePrivada);

		/* E imprimimos el mensaje */
		String mensajeDescifrado = new String(descifrada, "UTF-8");

		System.out.println("El mensaje descifrado es:" + mensajeDescifrado);
	}
}
