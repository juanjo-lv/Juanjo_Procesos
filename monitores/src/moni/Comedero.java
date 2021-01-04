package moni;

public class Comedero {
	
	private int comedero;
	
	public Comedero(int comedero) {
		this.comedero=comedero;
	}
	
	
	public synchronized void cogerComedero(int n_hamster) {
		while(comedero==0) {
			System.out.println("el hamster "+n_hamster+"no tiene comedero");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		comedero--;
		System.out.println("el hamster: "+n_hamster+" ha cogido el comedero");
	}

	public synchronized void dejarComedero(int n_hamster) {
		comedero++;
		System.out.println("el hamster: "+n_hamster+" ha dejado el comedero");
		notifyAll();
	}	
}
