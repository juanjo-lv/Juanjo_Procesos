package ejemplos.GUI05;

import javax.swing.*;
import java.awt.*;

class MiPanel extends JPanel {
	public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawString("Interfaz gráfica", 40, 40);
  }
}

public class Gui05 extends JFrame {
  Container panel;
  public Gui05() {
    super("Ejemplo de dibujo");
    panel = this.getContentPane();
    panel.add(new MiPanel());
    setSize(200, 100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /** Main method */
  public static void main(String[] args) {
    Gui05 ventana = new Gui05();
      
  }
  
}



