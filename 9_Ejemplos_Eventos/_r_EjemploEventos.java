import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _r_EjemploEventos extends JFrame{

     JLabel label;
     JButton boton1, boton2;

     public _r_EjemploEventos(){
        JPanel panel = new JPanel();
        label = new JLabel("La etiqueta: ");
        boton1 = new JButton("UNO");
        boton2 = new JButton("DOS");

        this.getContentPane().add(panel);

        Oyente oyente = new Oyente();

        panel.add(label);
        panel.add(boton1);
        panel.add(boton2);

        boton1.addActionListener(oyente);
        boton2.addActionListener(oyente);


     }

     class Oyente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();

            label.setText("Boton pulsado: " + boton.getText());
            
        }
        
     }

     public static void main(String[] args) {
        _r_EjemploEventos r_EjemploEventos = new _r_EjemploEventos();
        r_EjemploEventos.setVisible(true);
        r_EjemploEventos.setBounds(400,600,400,400);
     }

}

