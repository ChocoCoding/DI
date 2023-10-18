/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beatriz
 */
import java.awt.event.*;


import javax.swing.JTextField;



public class TratarEventos extends MouseAdapter {

  private JTextField etiqueta = new JTextField();

  TratarEventos(JTextField etiqueta) {
    this.etiqueta = etiqueta;
  }

  public void mouseClicked(MouseEvent EventoQueLlega) {
    MiBoton boton = new MiBoton();

    if (EventoQueLlega.getSource() instanceof MiBoton) {
      System.out.println("Este objeto es un boton.");
      boton = (MiBoton) EventoQueLlega.getSource();
      System.out.println(EventoQueLlega.getSource().toString());
    }

    etiqueta.setText(boton.getActionCommand());

  }

}
