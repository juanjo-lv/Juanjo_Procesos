package cesar2;

public class PruebaCesar {
	public static void main(String args[]) {
		String encriptado = new Cesar().Encriptar("Hola Manolo como estas", 3);
		System.out.println(encriptado);
		
		String desencriptado = new Cesar().Desencriptar(encriptado, 3);
		System.out.println(desencriptado);
	}
}
