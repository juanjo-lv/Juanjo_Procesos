package loshamsters;

public class Plato {
 private int numplatos;
 
 public Plato(int numplatos) {
	 this.numplatos=numplatos;
 }
 
 public synchronized void cogerPlato(int n) {
	 while(numplatos == 0) {
		 try {
			System.out.println("El hamster "+n+" no puede comer ya que no hay platos, toca esperar ");
			wait();
			System.out.println("El hamster "+n+" tiene la oportunidad para comer");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numplatos--;
		System.out.println("El hamster "+n+" está comiendo");
	 }
 }
 public synchronized void dejarPlato(int n) {
	 
	 numplatos++;
	 
	 System.out.println("El hamster "+n+"acaba de dejar el plato");
	 
	 notifyAll();
 }
 
}
