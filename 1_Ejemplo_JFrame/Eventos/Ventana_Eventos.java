
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana_Eventos extends JFrame implements ActionListener {
    JButton b_rojo, b_verde, b_azul;
    JTextField tf;
    JPanel panelNorte, panelCentro;

    public Ventana_Eventos() {
        panelNorte = new JPanel();
        panelNorte.add(b_rojo = new JButton("rojo"));
        panelNorte.add(b_verde = new JButton("verde"));
        panelNorte.add(b_azul = new JButton("azul"));
        

        this.add(panelNorte, BorderLayout.NORTH);
        panelCentro = new JPanel();
        this.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setBackground(Color.white);

        this.add(tf = new JTextField(80),BorderLayout.SOUTH);

        // Poner a la escucha los botones
        b_rojo.addActionListener(this);
        b_verde.addActionListener(this);
        b_azul.addActionListener(this);
    }

    /* --------------------- Action Listener ------------------ */
    public void actionPerformed(ActionEvent e) {
        //tf.setText(e.getSource().toString());
        //tf.setText(e.paramString());
        tf.setText(e.getActionCommand());
        if (e.getSource() == b_rojo) {
            panelCentro.setBackground(Color.red);

        } else if (e.getSource() == b_verde) {
            panelCentro.setBackground(Color.green);
        } else if (e.getSource() == b_azul) {
            panelCentro.setBackground(Color.blue);
        }
    }

    public static void main(String[] args) {
        Ventana_Eventos miVentana = new Ventana_Eventos();
        miVentana.setSize(500, 300);
        miVentana.setVisible(true);
    }
}