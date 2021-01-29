package pSeguridad;

public class Cifrador {
	String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ" + "0123456789 ";
	String alfabetoCifrado;

	/*
	 * Dada una cadena como "ABC" y un número (p.ej 2) devuelve la cadena rotada a
	 * la izq tantas veces como indique el número, en este caso "CAB"
	 */
	public String rotar(String cad, int numVeces) {
		char[] resultado = new char[cad.length()];
		for (int i = 0; i < cad.length(); i++) {
			int posParaExtraer = (i + numVeces) % cad.length();
			resultado[i] = cad.charAt(posParaExtraer);
		}
		String cadResultado = String.copyValueOf(resultado);
		return cadResultado;
	}

	public static void main(String[] args) {
		Cifrador c = new Cifrador();
		String cad = c.rotar("ABCDEFG", 2);
		System.out.println(cad);
	}
}
