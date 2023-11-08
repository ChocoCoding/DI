
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class InterfazPunto extends JFrame implements ActionListener, FocusListener {

	// crea un panel central
	JPanel panelNorte;

	JPanel panelSur;
	JLabel lpunto1x;
	JLabel lpunto1y;
	JTextField JTFPunto1x;
	JTextField JTFPunto1y;
	JLabel lpunto2x;
	JLabel lpunto2y;
	JTextField JTFPunto2x;
	JTextField JTFPunto2y;

	JButton JBDibujar;
	JButton JBLimpiar;

	PanelDibujo dibujar;

	// Constructor de la clase interfaz punto. Aquí creamos una instancia de
	// todos los componentes de la ventana, la cual la dividimos en tres paneles,
	// Norte, Dibujo y Sur

	InterfazPunto() {
		
		panelNorte = new JPanel();
		panelSur = new JPanel();
		
		dibujar = new PanelDibujo();

		lpunto1x = new JLabel("Coordenada x");
		lpunto1y = new JLabel("Coordenada y");

		// Le damos un valor inicial al punto 1
		// para asegurar que el rectángulo se pinta en una zona correcta
		JTFPunto1x = new JTextField("80");
		JTFPunto1y = new JTextField("80");

		lpunto2x = new JLabel("Alto");
		lpunto2y = new JLabel("Ancho");

		JTFPunto2x = new JTextField();
		JTFPunto2y = new JTextField();

		// Poner los cuadros de texto a la escucha de los eventos del Foco
		JTFPunto2y.addFocusListener(this);

		JBDibujar = new JButton("Dibujar");
		JBLimpiar = new JButton("Limpiar");

		panelNorte.setLayout(new GridBagLayout());
		// Construir la primera fila de componentes
		panelNorte.add(lpunto1x, createConstraints(0, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorte.add(JTFPunto1x, createConstraints(1, 0, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorte.add(lpunto1y, createConstraints(3, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorte.add(JTFPunto1y, createConstraints(4, 0, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

		// Construir la segunda fila de componentes
		panelNorte.add(lpunto2x, createConstraints(0, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorte.add(JTFPunto2x, createConstraints(1, 1, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorte.add(lpunto2y, createConstraints(3, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorte.add(JTFPunto2y, createConstraints(4, 1, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		;
		// Añadir el panel norte a la interfaz, la cual por ser un JFrame utiliza por
		// defecto el layout BorderLayout
		add(panelNorte, BorderLayout.NORTH);

		// Construir el panel Central
		
		
		add(dibujar, BorderLayout.CENTER);

		// Construir el panel Sur
		panelSur.setLayout(new GridBagLayout());

		// Construir la fila de botones
		panelSur.add(JBDibujar, createConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10,
						4)));
		panelSur.add(JBLimpiar, createConstraints(1, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

		// Añadir el panel sur a la interfaz
		add(panelSur, BorderLayout.SOUTH);

		// Poner los botones a la escucha

		JBLimpiar.addActionListener(this);
		JBDibujar.addActionListener(this);

		// Poner el botón dibujar desactivado hasta que el usuario los valores
		JBDibujar.setEnabled(false);

		// Poner el punto 1 no editable para que el usuario tenga el primer punto fijo
		JTFPunto1x.setEditable(false);
		JTFPunto1y.setEditable(false);

		// Asignar el foco al cuadro de texto del alto
		JTFPunto2x.requestFocus();
		

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

		if (arg0.getSource() == JBLimpiar) {

			JTFPunto2x.requestFocus();

			JTFPunto2x.setText("");
			JTFPunto2y.setText("");

			dibujar.setLimpiar(true);
			dibujar.repaint();

		}
		if (arg0.getSource() == JBDibujar) {
			
			JBDibujar.setEnabled(false);

			dibujar.asignar(Integer.parseInt(JTFPunto1x.getText()), Integer.parseInt(JTFPunto1y.getText()),
					Integer.parseInt(JTFPunto2x.getText()), Integer.parseInt(JTFPunto2y.getText()));

			dibujar.setLimpiar(false);			
			dibujar.repaint();

		}

	}

	public static void main(String s[]) {
		InterfazPunto miVentanaPunto = new InterfazPunto();
		miVentanaPunto.setSize(600, 300);
		miVentanaPunto.setLocation(80, 60);
		miVentanaPunto.setVisible(true);
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

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == JTFPunto2y)
			JBDibujar.setEnabled(true);
		// Sería aconsejable comprobar que el cuadro de texto tiene valores

	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		System.out.println("Pinto la ventana");
		panelNorte.repaint();
		panelSur.repaint();
		System.out.println(this.getHeight());
	}
}
