package fumadores;

public class Mesa {
	public static int ingredientefalta =0;
	public static boolean fumando = false;
	
	
	//fumador
	public synchronized void empezarfumar(int n_fum) {
		while(n_fum != ingredientefalta || fumando) {
			
			try {
				System.out.println("el fumador: "+n_fum+" no puede fumar");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("el fumador: "+n_fum+" está fumando");
		fumando = true;
		ingredientefalta = 0;
		notifyAll();
	}
	public synchronized void terminarfumar(int id) {
		System.out.println("El fumador "+id+" ha terminado de fumar");
		fumando = false;
		notifyAll();
	}
	
	
	//agente
	public synchronized void colocar(int ingrediente) {
		while(ingredientefalta != 0 || fumando) {
			try {
				System.out.println("Estanquero: no puedo poner ingrediente aun");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ingredientefalta = ingrediente;
		System.out.println("En la mesa falta el ingrediente :"+ingredientefalta);
		notifyAll();
	}
}
