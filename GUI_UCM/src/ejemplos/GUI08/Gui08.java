package ejemplos.GUI08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui08 extends JFrame implements ActionListener {
  JButton boton;
  Container panel;

  public Gui08() {
    super("Ejemplo de eventos");
    panel = this.getContentPane();
    boton = new JButton("Pulsa!");
    panel.add(boton);
    boton.addActionListener(this);
    
    setSize(100, 100);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e) {
    Toolkit.getDefaultToolkit().beep();
  }
  
  /** Main method */
  public static void main(String[] args) {
    Gui08 ventana = new Gui08();
      
  }
  
}



