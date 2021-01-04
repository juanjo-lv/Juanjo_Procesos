package Hamsters2;

public class Hamster extends Thread {
	private Monitor m;
	private int n;

	public Hamster(int n, Monitor m) {
		this.m = m;
		this.n = n;
	}

	public void run() {
		 while (true) {
		m.pillaPlato(n);

		//
		try {
			Thread.sleep((int) (Math.random() * 5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		m.devolverPlato(n);

		m.pillaRueda(n);

		// juego
		try {
			Thread.sleep((int) (Math.random() * 5000));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		m.devolverRueda(n);

		 }

	}

}
