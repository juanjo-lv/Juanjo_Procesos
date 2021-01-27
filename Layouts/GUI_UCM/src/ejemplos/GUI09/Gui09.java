package ejemplos.GUI09;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Ya no hay que implementar el interfaz ActionListener:
public class Gui09 extends JFrame {
  JButton boton;
  Container panel;
  public Gui09() {
    panel = this.getContentPane();
    boton = new JButton("Pulsa!");
    panel.add(boton);
    boton.addActionListener(new OyenteBoton());
    setSize(100, 100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
 
  /** Main method */
  public static void main(String[] args) {
    Gui09 ventana = new Gui09();
      
  }
  
}

class OyenteBoton implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	    Toolkit.getDefaultToolkit().beep();
	  }
}

