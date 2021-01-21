package ejemplo1;
import java.awt.*;
import javax.swing.*;


public class Main{

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					new ImageViewer();
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});


	}

}
