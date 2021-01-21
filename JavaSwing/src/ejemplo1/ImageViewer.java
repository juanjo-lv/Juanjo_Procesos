package ejemplo1;
import javax.swing.*;

public class ImageViewer {
	
	private JFrame frame;
	
	public ImageViewer() {
		makeFrame();
	}

	private void makeFrame() {
	    frame = new JFrame("ImageViewer");
		JLabel label = new JLabel("I am a label. I can display some text");
		
		JButton b = new JButton("ACEPTAR");
		
		frame.add(label);
		frame.add(b);
		
		//frame.setBounds(100, 100, 200, 300);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
}

