package loshamsters;

public class Hamster extends Thread {

	private int numHamster;
	private Plato plato;
	private Rueda rueda;
	private Monitor m;

	public Hamster(int numHamster, Plato plato, Rueda rueda) {
		this.numHamster = numHamster;
		this.plato = plato;
		this.rueda = rueda;
	}

	public Hamster(int numHamster, Monitor m) {
		this.numHamster = numHamster;
		this.m = m;
	}

	// run sin monitor
	/*
	 * public void run() { while(true){
	 * 
	 * plato.cogerPlato(numHamster); try { Thread.sleep((int) (Math.random() *
	 * 5000)); } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } plato.dejarPlato(numHamster);
	 * 
	 * rueda.cogerRueda(numHamster);
	 * 
	 * try { Thread.sleep((int) (Math.random() * 5000)); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * rueda.dejarRueda(numHamster);
	 * 
	 * } }
	 */
	// run monitor
	public void run() {
		while (true) {
			m.cogerPlato(numHamster);
			try {
				Thread.sleep((int) (Math.random() * 5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.dejarPlato(numHamster);

			m.cogerRueda(numHamster);
			try {
				Thread.sleep((int) (Math.random() * 5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.dejarRueda(numHamster);
		}
	}

}
