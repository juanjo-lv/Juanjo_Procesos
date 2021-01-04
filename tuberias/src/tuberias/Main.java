package tuberias;

public class Main {

	public static void main(String[] args) {
		Tuberia tub = new Tuberia();
		Consumidor c = new Consumidor(tub);
		Productor p = new Productor(tub);
		
		p.start();
		c.start();

	}

}
