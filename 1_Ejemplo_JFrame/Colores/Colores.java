package Colores;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Colores extends JFrame{

    JScrollPane barraDesplazamiento1 = new JScrollPane();
    JScrollPane barraDesplazamiento2 = new JScrollPane();
    JScrollPane barraDesplazamiento3 = new JScrollPane();

    JTextField cuadroDeTexto1 = new JTextField();
    JTextField cuadroDeTexto2 = new JTextField();
    JTextField cuadroDeTexto3 = new JTextField();

    JLabel textoLabel1 = new JLabel("Hola Mundo");
    JLabel textoLabel2 = new JLabel();
    JLabel textoLabel3 = new JLabel();

    
    Panel panelPrincipal = new Panel();
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Panel panel3 = new Panel();

    JLabel labelDerech1 = new JLabel();
    


    Colores(){
        panelPrincipal.setLayout(new BorderLayout());
        
        this.add(textoLabel1, BorderLayout.WEST);


                
        setSize(800,800);
       // setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(panelPrincipal);
    }

    public static void main(String[] args) {
        Colores colores1 = new Colores();
    }


    
}
