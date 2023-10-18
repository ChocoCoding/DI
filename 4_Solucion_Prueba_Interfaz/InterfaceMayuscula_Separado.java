import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class CuadroTexto extends JTextField{
	CuadroTexto(){
		super(40);
		this.setText("hola que tal");
	}
	
}

class CasillaMayuscula extends JCheckBox  {
	Font letra ;
	String titulo;
	
	
	CasillaMayuscula(){
		super();
		this.setText("Convertir el texto a mayusculas");
		letra=new Font("SansSerif",Font.BOLD,18);
		this.setFont(letra);

		try {
			this.setDisplayedMnemonicIndex(0);
		}
		catch (IllegalArgumentException e){
			System.err.print(e.getMessage());
		}
		
		
	}


}

class PanelMayuscula extends JPanel  {
		Font letra;
		JLabel JLtexto;
		CasillaMayuscula JChBmayuscula;
		CuadroTexto JTFtexto;
		Container c;
		
		GridBagConstraints restricciones;
		Boolean pulsada=false;
		
		//Constructor del panel
		PanelMayuscula(){
			
			setLayout(new GridBagLayout());
			restricciones = new GridBagConstraints();
			
			letra=new Font("SansSerif",Font.BOLD,18);
			
			JLtexto=new JLabel("Introduce un texto cualquiera");
			JLtexto.setHorizontalAlignment(JLabel.CENTER);
			
			JLtexto.setFont(letra);
			añadeGrid(JLtexto ,0,0, 1.0, 1.0, GridBagConstraints.NORTHWEST);
			
			JTFtexto=new CuadroTexto();
			añadeGrid(JTFtexto ,0,1,0.5,0.5,GridBagConstraints.HORIZONTAL);

			JChBmayuscula=new CasillaMayuscula();
			
			añadeGrid(JChBmayuscula ,0,2,0.5,0.5,GridBagConstraints.HORIZONTAL );	
			
		}
	
		// Método privado que crea las restricciones de cada componente
		private void añadeGrid(Component c, int x, int y,double weightx, double weighty, int fill){
			restricciones.gridx=x;
			restricciones.gridy=y;
			restricciones.fill=fill;
			restricciones.insets=new Insets(10,10,10,10);
			restricciones.weightx=weightx;
			restricciones.weighty=weighty;
			add(c,restricciones);
		}
	
		
	
}


// Clase principal que implementa la ventana

public class InterfaceMayuscula_Separado{
	
	public static void main(String args[]){
			//Creamos un objeto de tipo JFrame
			JFrame ventana= new JFrame();
			ventana.setTitle("Ventana mayúscula");

			//Creamos un objeto JPanel
			PanelMayuscula mipanel=new PanelMayuscula();
			ventana.add(mipanel);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setSize(400,200);
			ventana.setVisible(true);
		}

}
			

