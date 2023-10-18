import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEventosFoco extends JFrame implements FocusListener {
    JButton boton,boton2;
    Color colorBackgroundDefecto;
    JPanel panelNorte;
    JTextField area;

    VentanaEventosFoco() {
        boton = new JButton("Pulsame 1");
        boton2 = new JButton(("Boton"), null);
        area=new JTextField();
        //Modificar el tamaño de la letra del cuadro de texto
        area.setFont(new Font("Arial",Font.BOLD,22));
        panelNorte=new JPanel();
        panelNorte.add(boton);
        panelNorte.add(boton2);
        // Guardamos el color de background por defecto.
        colorBackgroundDefecto = boton.getBackground();
        this.add(panelNorte,BorderLayout.NORTH);
        this.add(area,BorderLayout.SOUTH);

        // Poner el boton a la escucha
        boton.addFocusListener(this);
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        e.getComponent().setBackground(Color.RED);
        // e.getOpositeComponent() devuelve el Component que le
        // cede el foco a nuestro botón.
        area.setText("Componente que gana el foco: " + ((JButton)e.getComponent()).getActionCommand());
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
        e.getComponent().setBackground(colorBackgroundDefecto);
        // get.OpositeComponent() devuelve el Component al que
        // nuestro botón cede el foco.
         area.setText("Componente al que cede el foco: " +((JButton)e.getOppositeComponent()).getActionCommand());

    }

    public static void main(String[] args) {
        VentanaEventosFoco miVentana = new VentanaEventosFoco();
        miVentana.setSize(500, 300);
        miVentana.setVisible(true);
    }
}
