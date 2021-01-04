package moni;

public class Rueda {
 private int ruedas;
 
 public Rueda(int ruedas) {
	 this.ruedas=ruedas;
 }
	
public synchronized void cogerRueda(int n_hamster) {
	while(ruedas==0) {
		System.out.println("el hamster "+n_hamster+"no tiene rueda");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	ruedas--;
	System.out.println("el hamster: "+n_hamster+" ha cogido una rueda");
}

public synchronized void dejarRueda(int n_hamster) {
	ruedas++;
	System.out.println("el hamster: "+n_hamster+" ha dejado la rueda");
	notifyAll();
}
	
}
