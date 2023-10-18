import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.border.Border;


class BotonEtiqueta extends JButton {
	
	BotonEtiqueta() {
		super.setFont(new Font("arial",Font.BOLD, 20));
		super.setHorizontalAlignment(JLabel.CENTER);
		super.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.blue));
        super.setOpaque(true);      
	}

	BotonEtiqueta(String texto) {
		super(texto);
		super.setHorizontalAlignment(JLabel.CENTER);
		super.setFont(new Font("arial",Font.BOLD, 20));
		super.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.blue));
		
		super.setOpaque(true);           
	}



}

class Etiqueta extends JLabel{
	
	Etiqueta() {
		super.setFont(new Font("arial",Font.BOLD, 20));
		super.setHorizontalAlignment(JLabel.CENTER);
		super.setOpaque(true);      
	}

	Etiqueta(String texto) {
		super(texto);
		super.setFont(new Font("arial",Font.BOLD, 20));
		super.setHorizontalAlignment(JLabel.CENTER);
		super.setOpaque(true);           
	}
}




public class interfaz_colores extends JFrame {
    //Declarar los componentes de la clase

	JScrollBar sb_r,sb_g,sb_b;
	JTextField tf_r,tf_g,tf_b;
	Container c;
	Etiqueta lb_r,lb_g,lb_b;
	 //Trabajar con botones
    BotonEtiqueta lb[]=new BotonEtiqueta[13];
   

    //Trabajar con etiquetas
    //JLabel lb[]=new JLabel[13];
    
	//Declarar un array de colores
	Color[] listaColores = {Color.black,Color.darkGray,Color.gray,Color.lightGray,Color.white,
			Color.magenta,Color.blue,Color.cyan,Color.green,Color.yellow,Color.orange,
			Color.red,Color.pink};


	 String[] textoColor={"negro","gris oscuro","gris","gris claro","blanco","magenta","azul",
			 "cian","verde","amarillo","naranja","rojo","rosa"};
    

        //Constructor de la clase
	interfaz_colores() {
            
        	c=this.getContentPane();
        	c.setBackground(Color.white);
                 
            JPanel wp=new JPanel();
            wp.setBackground(Color.gray);
            wp.setLayout(new GridLayout(1,3,8,8));
            add("West",wp);
           						
            sb_r = new JScrollBar(JScrollBar.VERTICAL,255,32,0,255+32);
            sb_g = new JScrollBar(JScrollBar.VERTICAL,255,32,0,255+32);
            sb_b = new JScrollBar(JScrollBar.VERTICAL,255,32,0,255+32);
            sb_r.setForeground(Color.red);
            sb_g.setForeground(Color.green);
            sb_b.setForeground(Color.blue);
            wp.add(sb_r);
            wp.add(sb_g);
            wp.add(sb_b);

            JPanel sp=new JPanel();
            sp.setBackground(Color.gray);
            add("South",sp);
            sp.setFont(new Font("Helvetica",Font.PLAIN,16));
            sp.setLayout(new GridLayout(1,6));
            
            sp.add(lb_r=new Etiqueta("rojo"));
            sp.add(tf_r=new JTextField("0"));
            sp.add(lb_g=new Etiqueta("verde"));
            sp.add(tf_g=new JTextField("0"));
            sp.add(lb_b=new Etiqueta("azul"));
            sp.add(tf_b=new JTextField("0"));
            
            lb_r.setBackground(Color.red);
            lb_g.setBackground(Color.green);
            lb_b.setBackground(Color.blue);
            
            tf_r.setEditable(false);
            tf_g.setEditable(false);
            tf_b.setEditable(false);
            
            JPanel ep=new JPanel();
            add("East",ep);
            ep.setBackground(Color.gray);
            ep.setLayout(new GridLayout(13,1));
          
            
            for (int i=0; i<13; i++) {
            	lb[i]=new BotonEtiqueta();
            	
            	lb[i].setFont(new Font("arial",Font.BOLD,18));
            	lb[i].setOpaque(true);
            	lb[i].setBackground(listaColores[i]);
            	if (i <3 )
            		lb[i].setForeground(Color.white);
            	else
            		lb[i].setForeground(Color.gray);
            	
               	lb[i].setText(textoColor[i]);
               
               	
            	ep.add(lb[i]);
            }
            
     
            c.setBackground(new Color(0,0,0));
	}


}
