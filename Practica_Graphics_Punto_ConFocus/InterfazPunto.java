
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.awt.*;

class PanelSur extends JPanel {
	JButton JBCalcular;
	JButton JBDibujar;
	JButton JBLimpiar;

	PanelSur() {

		JBCalcular = new JButton("Calcular");
		JBDibujar = new JButton("Dibujar");
		JBLimpiar = new JButton("Limpiar");

		// Construir el panel Sur
		setLayout(new GridBagLayout());

		// Construir la fila de botones
		add(JBCalcular, createConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(JBDibujar, createConstraints(1, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(JBLimpiar, createConstraints(2, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
	}

	private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
			double weightx, double weighty, int fill, int anchor, Insets insets) {
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

}

class ControladorFoco implements FocusListener {
	PanelNorte pN;
	PanelSur pS;

	ControladorFoco(PanelSur panelSur, PanelNorte panelNorte) {
		pN = panelNorte;
		pS = panelSur;
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == pN.JTFPunto2x) {
			System.out.println("Estoy en el primero");
			pS.JBCalcular.setEnabled(false);
			JTextField texto = (JTextField) e.getSource();
			texto.setSelectionStart(0);
			texto.setSelectionEnd(texto.getText().length());
		}

		if (e.getOppositeComponent() == pN.JTFPunto2x) {
			System.out.println("Estoy en el segundo");
			JTextField texto = (JTextField) e.getSource();
			texto.setSelectionStart(0);
			texto.setSelectionEnd(texto.getText().length());
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == pN.JTFPunto2y) {
			// Activa el botón Calcular
			pS.JBCalcular.setEnabled(true);
			pS.JBDibujar.setEnabled(false);
		}
	}

}

class PanelNorte extends JPanel {
	JLabel lpunto1x;
	JLabel lpunto1y;
	JTextField JTFPunto1x;
	JTextField JTFPunto1y;
	JLabel lpunto2x;
	JLabel lpunto2y;
	JTextField JTFPunto2x;
	JTextField JTFPunto2y;

	PanelNorte() {

		lpunto1x = new JLabel("Coordenada x");
		lpunto1y = new JLabel("Coordenada y");

		// Le damos un valor inicial al punto 1
		// para asegurar que el rectángulo se pinta en una zona correcta
		JTFPunto1x = new JTextField("80");
		JTFPunto1y = new JTextField("80");

		lpunto2x = new JLabel("Coordenada x");
		lpunto2y = new JLabel("Coordenada y");

		JTFPunto2x = new JTextField();
		JTFPunto2y = new JTextField();

		// Poner el punto 1 no editaable para que el usuario tenga el primer punto fijo
		JTFPunto1x.setEditable(false);
		JTFPunto1y.setEditable(false);

		this.setLayout(new GridBagLayout());
		// Construir la primera fila de componentes
		add(lpunto1x, createConstraints(0, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(JTFPunto1x, createConstraints(1, 0, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(lpunto1y, createConstraints(3, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(JTFPunto1y, createConstraints(4, 0, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

		// Construir la segunda fila de componentes
		add(lpunto2x, createConstraints(0, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(JTFPunto2x, createConstraints(1, 1, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(lpunto2y, createConstraints(3, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		add(JTFPunto2y, createConstraints(4, 1, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		;

	}

	private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
			double weightx, double weighty, int fill, int anchor, Insets insets) {
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

}

@SuppressWarnings("serial")
public class InterfazPunto extends JFrame implements ActionListener, ListSelectionListener{

	// crea un panel central
	PanelNorte panelNorte;
	JPanel panelCentral;
	PanelSur panelSur;

	// JTextArea JTFdistancia;
	// Sustituir el textArea por un JList
	JList<String> JTFdistancia;
	DefaultListModel<String> dlm;

	PanelDibujo dibujar;

	// Crea dos instancias de tipo punto
	Punto miPunto1;
	Punto miPunto2;

	// Constructor de la clase interfaz punto. Aquí creamos una instancia de
	// todos los componentes de la ventana, la cual la dividimos en tres paneles,
	// Norte, Central y Sur
	// El panel Central va a estar compuesto a su vez por el panel Dibujo y el
	// textArea, en el cual mostramos
	// la distancia entre dos punto

	InterfazPunto() {

		panelNorte = new PanelNorte();
		panelCentral = new JPanel();
		panelSur = new PanelSur();
		dibujar = new PanelDibujo();
		dibujar.setBackground(Color.gray);

		// JTFdistancia = new JTextArea();
		dlm = new DefaultListModel<String>();
		JTFdistancia = new JList<>(dlm);

		// Añadir el panel norte a la interfaz, la cual por ser un JFrame utiliza por
		// defecto el layout BorderLayout
		add(panelNorte, BorderLayout.NORTH);

		// Construir el panel Central
		panelCentral.setLayout(new GridLayout(1, 2));
		Border miBorde = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

		panelCentral.setBorder(miBorde);
		//JTFdistancia.setEditable(false);
		JTFdistancia.setBorder(miBorde);

		panelCentral.add(JTFdistancia);
		panelCentral.add(dibujar);

		// Añadir el panel central a la interfaz
		add(panelCentral, BorderLayout.CENTER);

		// Añadir el panel sur a la interfaz
		add(panelSur, BorderLayout.SOUTH);

		// Crear dos instancias de la clase punto
		miPunto1 = new Punto();
		miPunto2 = new Punto();

		// Asignar el foco al cuadro de texto del punto2
		panelNorte.JTFPunto2x.requestFocus();

		this.setMinimumSize(new Dimension(300, 300));

		// Poner los botones a la escucha
		panelSur.JBCalcular.addActionListener(this);
		panelSur.JBDibujar.addActionListener(this);
		panelSur.JBLimpiar.addActionListener(this);

		// Poner los cuadros de texto a la escucha de los eventos del foco
		panelNorte.JTFPunto2x.addFocusListener(new ControladorFoco(panelSur, panelNorte));
		panelNorte.JTFPunto2y.addFocusListener(new ControladorFoco(panelSur, panelNorte));
		// Poner el JList a la escucha

		JTFdistancia.addListSelectionListener(this);
	}

	/*
	 * Implementación de la funcionalidad. Todos los botones implementan la
	 * interface ActionListener, por lo que cada vez
	 * que pulsamos en un botón, ejecuta el mismo método.
	 * Debido a esto la primera instrucción que debemos añadir es la que nos permite
	 * identificar que botón a pulsado el usuario
	 * y dependiendo de eso realizamos una función u otra.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		/*
		 * Lo primero que hacemos es obtener el objeto punto de los cuadros de texto.
		 * Como el JTextField nos devuelve un dato
		 * de tipo String y el objeto Punto necesita dos coordenadas de tipo Double
		 * debemos hacer la conversión. Dicha conversion
		 * puede lanzar una excepción cuando se produce un error, por lo cual debemos
		 * capturarla. Esto lo hacemos incluyendo las
		 * instrucciones susceptibles de que se produzca una excepción dentro del try.
		 * Sería más correcto que cada conversión tuviera su propio bloque y gestionar
		 * los posibles errores por separado, y hacer que
		 * si el usuario introduce un valor incorrecto en el cuadro de texto no le deje
		 * pasar al siguiente. Esto se gestiona con los eventos
		 * del foco
		 * 
		 */

		if (arg0.getSource() == panelSur.JBCalcular) {
			try {
				miPunto1.asignarX(Double.parseDouble(panelNorte.JTFPunto1x.getText()));
				miPunto1.asignarY(Double.parseDouble(panelNorte.JTFPunto1y.getText()));

				miPunto2.asignarX(Double.parseDouble(panelNorte.JTFPunto2x.getText()));
				miPunto2.asignarY(Double.parseDouble(panelNorte.JTFPunto2y.getText()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Se ha producido un error al convertir el texto a Double" + e.getMessage());
			}

			Double distanciaPuntos = Math.round(miPunto1.calcularDistancia(miPunto2) * 100.0) / 100.0;
			// Sacamos en el textArea los dos puntos con el siguiente mensaje. Para ello
			// modificamos la clase punto
			// y le añado el método mostrarPunto

			//JTFdistancia.setText(JTFdistancia.getText() + (distanciaPuntos + "\n"));
			dlm.addElement(String.valueOf(distanciaPuntos));
			// Al calcular la distancia entre dos puntos activar el botón Dibujar
			panelSur.JBDibujar.setEnabled(true);
		}
		if (arg0.getSource() == panelSur.JBLimpiar) {

			panelNorte.JTFPunto2x.requestFocus();

			panelNorte.JTFPunto2x.setText("");
			panelNorte.JTFPunto2y.setText("");

			dibujar.asignarPunto(new Punto(0, 0), new Punto(this.getWidth(), this.getHeight()));
			dibujar.setLimpiar(true);
			dibujar.repaint();

		}
		if (arg0.getSource() == panelSur.JBDibujar) {
			panelSur.JBDibujar.setEnabled(false);

			dibujar.asignarPunto(miPunto1, miPunto2);
			dibujar.setLimpiar(false);

			// Comprobar si el tamaño del rectángulo que estamos dibujando
			// es mayor que el contenedor (en este caso el JPanel)
			int width = (int) (dibujar.obtenerPunto2().obtenerX()) - (int) (dibujar.obtenerPunto1().obtenerX());

			// En este caso al ancho del panel dibujo le resto la coordenada X del primer
			// punto, ya que no dibujo el rectángulo en el punto (0,0)
			if (width > dibujar.getWidth() - dibujar.obtenerPunto1().obtenerX()) {

				if (width > dibujar.getHeight() - dibujar.obtenerPunto1().obtenerY())
					// En este caso modificamos el alto y el ancho de la ventana
					this.setMinimumSize(new Dimension(this.getWidth() + width, this.getHeight() + width));
				else
					// En este caso modificamos sólo el ancho de la ventana
					System.out.println("Entro si o no");
				this.setMinimumSize(new Dimension(this.getWidth() + width, dibujar.getHeight()));

			}
			dibujar.repaint();

		}

	}

	public static void main(String s[]) {
		InterfazPunto miVentanaPunto = new InterfazPunto();
		miVentanaPunto.setSize(600, 400);
		miVentanaPunto.setLocation(80, 60);
		miVentanaPunto.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		//Debemos crear un objeto Figura y crear una lista de Figuras.
		//El objeto figura tiene dos puntos
		JList lista=new JList();
		
		System.out.println("EStoy en el eleemento seleccionado" +e.getSource().getClass().toString());
		
		System.out.println(e.getFirstIndex());
	}

}
