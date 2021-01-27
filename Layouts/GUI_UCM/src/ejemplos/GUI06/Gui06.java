package ejemplos.GUI06;

import javax.swing.*;
import java.awt.*;

class MiPanel extends JPanel {
	  public void paintComponent(Graphics g) {
	    Color c = new Color(180, 10, 120);
	    g.setColor(c);
	    g.drawString("Dibujar en el panel", 90, 90);
	    g.fillOval(1, 1, 90, 90);
	  }
	}

	public class Gui06 extends JFrame {
	  Container panel;
	  public Gui06(){
	    super("Ejemplo de dibujo");
	    panel = this.getContentPane();
	    panel.add(new MiPanel());
	    setSize(300, 200);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	  }

  /** Main method */
  public static void main(String[] args) {
    Gui06 ventana = new Gui06();
      
  }
  
}



