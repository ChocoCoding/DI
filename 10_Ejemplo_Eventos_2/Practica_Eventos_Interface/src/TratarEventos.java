/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beatriz
 */
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.awt.*;

public class TratarEventos implements ActionListener {

  private JTextField etiqueta;
  
  TratarEventos(){
    this.etiqueta= new JTextField();

  }
  TratarEventos(JTextField etiqueta) {
    this.etiqueta = etiqueta;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    etiqueta.setText(e.getActionCommand());
    System.out.println("Este objeto es un botón");
    System.out.println(e.getSource().getClass().getCanonicalName().toString());
   //System.out.println(e.paramString());
  }

}
