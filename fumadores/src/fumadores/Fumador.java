package fumadores;

public class Fumador extends Thread{
	private Mesa m;
	private int n_fum;
	
	public Fumador(Mesa m, int n_fum) {
		this.m=m;
		this.n_fum=n_fum;
	}
	public void run() {
		while(true){
			m.empezarfumar(n_fum);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.terminarfumar(n_fum);
		}
	}
	
}
