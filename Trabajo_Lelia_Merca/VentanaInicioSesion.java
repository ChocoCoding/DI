
import java.awt.BorderLayout;
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
import javax.swing.*;


public class VentanaInicioSesion extends JFrame implements ActionListener {

	private JLabel labelInicioSesion, labelNombreUsuario;
	private JPanel panelCentral,panelSeleccionCliente;
	private JTextField textoUsuario;
	private JButton btnAceptar;
	private AplicacionUsuarios app;
	CheckboxGroup seleccionTipoCliente;
	Checkbox clienteE,clienteC,clienteP;
	Container c;
	FondoPanel fondo;

	public VentanaInicioSesion(AplicacionUsuarios app) {
		this.app = app;
		fondo = new FondoPanel();
		this.setContentPane(fondo);
		//Imagen de fondo


		//Panel de fondo
		//Establecemos un Gridbaglayout para el panel de fondo
		c = this.getContentPane();
		c.setLayout(new GridBagLayout());
		//Establecemos propiedades de nuestra ventana
		setTitle("Lelia Merca Gourmet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 400, 800, 600);
		setResizable(false);

		//Creamos el icono de nuestra aplicacion
		Image icon = new ImageIcon(getClass().getResource("./img/logo.png")).getImage();
        setIconImage(icon);

		//DEFINIMOS EL PANEL CENTRAL
		panelCentral = new JPanel();
		panelCentral.setBackground(Color.white.brighter());
		panelCentral.setLayout(new GridBagLayout());
		c.add(panelCentral,createConstraints(1,1,3,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.CENTER,new Insets(-250, 0, 0, 0)));
		
		//Imagen
		LaminaConImagen laminaConImagen = new LaminaConImagen();
		c.add(laminaConImagen,createConstraints(0,0,3,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(10, 10, 50, 2)));

		//LABEL INICIO SESION
		labelInicioSesion = new JLabel("Inicio Sesión");
		labelInicioSesion.setFont(new Font("Arial",Font.BOLD,22));
		panelCentral.add(labelInicioSesion, createConstraints(0,0,3,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.CENTER,new Insets(20, 20, 20, 20)));
		
		
		//LABEL NOMBRE USUARIO
		labelNombreUsuario = new JLabel("Nombre de usuario:");
		labelNombreUsuario.setFont(new Font("Arial",Font.BOLD,14));
		panelCentral.add(labelNombreUsuario, createConstraints(0,1,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(0, 20, 5, 20)));

		//LABEL CUADRO DE TEXTO USUARIO
		textoUsuario = new JTextField("Introduce nombre usuario",20);
		panelCentral.add(textoUsuario, createConstraints(0,2,1,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(0, 20, 10, 20)));

		//TIPO DE CLIENTE
		seleccionTipoCliente = new CheckboxGroup();
		panelSeleccionCliente = new JPanel();
		panelSeleccionCliente.setLayout(new GridLayout(3,1));
		panelSeleccionCliente.setBorder(BorderFactory.createTitledBorder("¿Que tipo de cliente eres?"));
		clienteE = new Checkbox("Cliente Esporadico",false,seleccionTipoCliente);
		clienteC = new Checkbox("Cliente Club",false,seleccionTipoCliente);
		clienteP = new Checkbox("Cliente Premium",false,seleccionTipoCliente);
		panelSeleccionCliente.add(clienteE);
		panelSeleccionCliente.add(clienteC);
		panelSeleccionCliente.add(clienteP);

		panelCentral.add(panelSeleccionCliente, createConstraints(0,3,3,1,1.0,0.2,
		GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTHWEST,new Insets(20, 20, 20, 20)));

		//Boton aceptar
		btnAceptar = new JButton("Aceptar");
		
		panelCentral.add(btnAceptar, createConstraints(0,4,3,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.CENTER,new Insets(20, 20, 20,20)));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();

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

	@Override
	public void paintComponent(Graphics g){
		this.setSize(200,400);
		//Pintamos nuestra imagen
	
	
		ImageIcon logo = new ImageIcon(getClass().getResource("./img/logo.png"));
		g.drawImage(logo.getImage(),0,0,200, 100,this);
		setOpaque(false);
		super.paintComponent(g);
	}

}

class FondoPanel extends JPanel{
	private Image imagen;

	@Override
	public void paint(Graphics g){
		imagen = new ImageIcon(getClass().getResource("./img/gourmet.jpg")).getImage();

		g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
	}


}


}
