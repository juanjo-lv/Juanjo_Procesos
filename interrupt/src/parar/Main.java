package parar;

public class Main {

	public static void main(String[] args) {
		Hilo h = new Hilo();
		
		h.start();
		
		for (int i = 0; i < 5; i++) {
			h.pararHilo();
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hilo parado");
		}
		
	}

}
