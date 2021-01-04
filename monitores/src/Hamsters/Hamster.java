package Hamsters;

public class Hamster extends Thread {
	private Plato p;
	private Rueda r;
	private int n;

	public Hamster(int n, Plato p, Rueda r) {
		this.p = p;
		this.r = r;
		this.n = n;
	}

	public void run() {
		while (true) {
			p.pillaPlato(n);

			//
			try {
				Thread.sleep((int) (Math.random() * 5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			p.devolverPlato(n);

			r.pillaRueda(n);

			// juego
			try {
				Thread.sleep((int) (Math.random() * 5000));
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			r.devolverRueda(n);

		}

	}

}
