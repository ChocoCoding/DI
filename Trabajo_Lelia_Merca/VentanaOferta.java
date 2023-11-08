import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class VentanaOferta extends JFrame{
    JLabel textoBienvenido,nombreProducto1,nombreProducto2,nombreProducto3,precio1,precio2,precio3,txtprecio1,txtprecio2,txtprecio3;
    JTextField cant1,cant2,cant3;
    JButton btnCancelar,btnPagar,btnCerrarSesion;
    JPanel panel1,panel2,panel3;
    Container c;
    AplicacionUsuarios app;

    public VentanaOferta(String tipoCliente,String nombreCliente,AplicacionUsuarios app){
        this.app = app;
        setTitle("Lelia Merca Gourmet");
		setBounds(300, 200, 1200, 800);
		c = this.getContentPane();
        c.setLayout(new GridBagLayout());

        //Creamos el icono de nuestra aplicacion
		java.awt.Image icon = new ImageIcon(getClass().getResource("./img/logo.png")).getImage();
        setIconImage(icon);

        //Imagen
        ImageIcon logo = new ImageIcon(getClass().getResource("./img/logo.png"));
		LaminaConImagen laminaConImagen = new LaminaConImagen(logo);
		c.add(laminaConImagen,createConstraints(0,0,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(10, 10, 50, 2)));

        //Texto Bienvenida
        textoBienvenido = new JLabel("Bienvenido: " + nombreCliente);
       	c.add(textoBienvenido,createConstraints(2,0,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,new Insets(10, 10, 50, 15)));


        //IMAGEN 1
        ImageIcon img1 = new ImageIcon(getClass().getResource("./img/champan.png"));
        LaminaConImagen laminaConImagen1 = new LaminaConImagen(img1);
        c.add(laminaConImagen1,createConstraints(0,1,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTH,new Insets(10, 10, 0, 15)));

        //IMAGEN 2
        ImageIcon img2 = new ImageIcon(getClass().getResource("./img/champan.png"));
        LaminaConImagen laminaConImagen2 = new LaminaConImagen(img1);
        c.add(laminaConImagen2,createConstraints(0,2,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTH,new Insets(10, 10, 0, 15)));

        //IMAGEN 3
        ImageIcon img3 = new ImageIcon(getClass().getResource("./img/champan.png"));
        LaminaConImagen laminaConImagen3 = new LaminaConImagen(img1);
        c.add(laminaConImagen3,createConstraints(0,3,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTH,new Insets(10, 10, 0, 15)));

        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        c.add(panel1,createConstraints(1,1,2,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTH,new Insets(10, 10, 0, 15)));

        nombreProducto1 = new JLabel("Patats");
        panel1.add(nombreProducto1,createConstraints(0,0,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.WEST,new Insets(10, 10, 0, 15)));
  
    }

	private static GridBagConstraints createConstraints(
                        int gridx,
                        int gridy,
                        int gridwidth,
                        int gridheight,
                        double weightx,
                        double weighty,
                        int fill,
                        int anchor,
                        Insets insets) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = gridx;
                constraints.gridy = gridy;
                constraints.gridwidth = gridwidth;
                constraints.gridheight = gridheight;
                constraints.weightx = weightx;
                constraints.weighty = weighty;
                constraints.fill = fill;
                constraints.anchor = anchor;
                constraints.insets = insets;
                return constraints;
}

class LaminaConImagen extends JPanel{
    private ImageIcon image;

    public LaminaConImagen(ImageIcon image){ 
        this.image = image;
    }
    
	@Override
	public void paintComponent(Graphics g){
		this.setSize(200,400);
		//Pintamos nuestra imagen
		
		g.drawImage(image.getImage(),0,0,200, 100,this);
		setOpaque(false);
		super.paintComponent(g);
	}
}
}
    
