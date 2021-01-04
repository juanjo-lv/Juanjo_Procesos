package fumadores;

public class Agente extends Thread{
	private Mesa m;
	
	
public Agente(Mesa m) {
	this.m=m;
}
	public void run() {
		while(true) {
			m.colocar((int)Math.floor(Math.random()*3+1));
		}
		
	}
}
