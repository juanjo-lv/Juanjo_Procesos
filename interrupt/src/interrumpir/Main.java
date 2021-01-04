package interrumpir;

public class Main {

	public static void main(String[] args) {
		Hilo h = new Hilo();
		
		h.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.interrupt();

	}

}
