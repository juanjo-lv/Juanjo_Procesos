package fumadores;

public class Main {

	public static void main(String[] args) {
		Mesa m = new Mesa();
		Agente agente = new Agente(m);
		agente.start();
		for (int i = 1; i <=3; i++) {
			Fumador f = new Fumador(m,i);
			f.start();
		}

	}

}
