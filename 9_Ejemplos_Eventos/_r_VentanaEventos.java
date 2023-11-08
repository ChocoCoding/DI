import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _r_VentanaEventos extends JFrame{
    JButton boton1,boton2,boton3;
    JTextField textoSur;
    Container c = this.getContentPane();

    public _r_VentanaEventos(){
        JPanel panelNorte = new JPanel();
        panelNorte.setLayout(new FlowLayout());
        boton1 =  new JButton("Rojo");
        boton2 =  new JButton("Verde");
        boton3 =  new JButton("Azul");

        panelNorte.add(boton1);
        panelNorte.add(boton2);
        panelNorte.add(boton3);

        

        c.add(panelNorte, BorderLayout.NORTH);

        oyenteAccionBoton oAccionBoton = new oyenteAccionBoton();

        boton1.addActionListener(oAccionBoton);
        boton2.addActionListener(oAccionBoton);
        boton3.addActionListener(oAccionBoton);

        //Añadimos el texto al sur
        textoSur = new JTextField();
        c.add(textoSur, BorderLayout.SOUTH);
    }

    class oyenteAccionBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();

            if (boton.equals(boton1)) {
                c.setBackground(Color.RED);
                textoSur.setText(boton.getText());
            } if (boton.equals(boton2)) {
                c.setBackground(Color.GREEN);
                textoSur.setText(boton.getText());
            } if (boton.equals(boton3)) {
                c.setBackground(Color.BLUE);
                textoSur.setText(boton.getText());
            }
            

        }
        
    }

    public static void main(String[] args) {
        _r_VentanaEventos r_VentanaEventos = new _r_VentanaEventos();
        r_VentanaEventos.setVisible(true);
        r_VentanaEventos.setBounds(400,600,400,400);
    }
}
