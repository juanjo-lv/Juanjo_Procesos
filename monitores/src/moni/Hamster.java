package moni;

public class Hamster extends Thread {
	private int n_hamster;
	private  Rueda ruedas;
	private Comedero comedero;
	
	public Hamster(int n_hamster,Rueda ruedas,Comedero comedero) {
		this.n_hamster=n_hamster;
		this.ruedas=ruedas;
		this.comedero=comedero;
	}
	
	public void run() {
		comedero.cogerComedero(n_hamster);
		
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comedero.dejarComedero(n_hamster);
		
		ruedas.cogerRueda(n_hamster);
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ruedas.dejarRueda(n_hamster);
	}
	
	
}
