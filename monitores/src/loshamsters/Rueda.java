package loshamsters;

public class Rueda {
	private int numRuedas;
	
	public Rueda(int numRuedas) {
		this.numRuedas=numRuedas;
	}
	
	public synchronized void cogerRueda(int numHamster){
		while(numRuedas==0) {
			try {
				System.out.println("El Hamster "+numHamster+" no puede hacer ejercicio");
				wait();
				System.out.println("El Hamster "+numHamster+" ha encontrado una rueda");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			numRuedas--;
			System.out.println("El Hamster "+numHamster+" coge una rueda");
		}
	}
	
	public synchronized void dejarRueda(int numHamster) {
		numRuedas++;
	
		System.out.println("El Hamster "+numHamster+" ha dejado la rueda");
		notifyAll();
		
	}
}
