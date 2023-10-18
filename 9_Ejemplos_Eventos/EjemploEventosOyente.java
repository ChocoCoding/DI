import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class EjemploEventosOyente extends JFrame {
    JLabel etiqueta; // Declarar variables
    JButton botonUno, botonDos;
    JPanel panel;

    public EjemploEventosOyente() {
        // Construir la ventan
        etiqueta = new JLabel("La etiqueta: ");
        botonUno = new JButton("Uno");
        botonDos = new JButton("Dos");
        panel = new JPanel();
        // Añadimos los componentes al panel
        panel.add(etiqueta);
        panel.add(botonUno);
        panel.add(botonDos);
        // Añadir el panel al Frame
        getContentPane().add(panel);
        
        // Crear objeto de la clase oyente para cuando se pulse el botón
        OyenteAccion oyenteBoton = new OyenteAccion();
        // Registrar el objeto como oyente en los dos botones
        botonUno.addActionListener(oyenteBoton);
        botonDos.addActionListener(oyenteBoton);
    }

    // Implementación en la clase oyente
    class OyenteAccion implements ActionListener {
        // Cuando se pinche en el botón
        public void actionPerformed(ActionEvent evento) {
            // Obtener el botón que disparó el evento
            JButton botón = (JButton) evento.getSource();
            // Escribir en la etiqueta, el botón que se pulsó
            etiqueta.setText("Botón pulsado: " + botón.getText());
        }
    }

    // Programa principal
    public static void main(String args[]) {
        // Crear la ventana
        EjemploEventosOyente ventana = new EjemploEventosOyente();
        // Establecer el título, el tamaño y hacerla visible
        
        ventana.setTitle("Título de la ventana");
        ventana.setSize(400, 400);
        ventana.setVisible(true);
    }
}