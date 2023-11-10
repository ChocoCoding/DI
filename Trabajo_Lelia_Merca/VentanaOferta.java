import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.CompoundBorder;

public class VentanaOferta extends JFrame{
    JLabel textoBienvenido,nombreProducto1,nombreProducto2,nombreProducto3,
    precio1,precio2,precio3,txtprecio1,txtprecio2,txtprecio3,txtCant1,txtCant2,txtCant3,
    txtOfertas,txtCarritoDeCompra;
    JSpinner cant1,cant2,cant3;
    JButton btnCancelar,btnPagar,btnCerrarSesion,addCarrito1,addCarrito2,addCarrito3,btnLimpiarCarrito,btnActivarOfertas;
    JPanel panel1,panel2,panel3,panelImg1,panelImg2,panelImg3,panelboton,panelCarrito,panelCantidades1,panelCantidades2,
    panelCantidades3,panelPagoLimpiar,panelActivarOfertas;
    Container c;
    AplicacionUsuarios app;
    SpinnerModel value1,value2,value3;
    JSpinner spinner1,spinner2,spinner3;
    JTextArea textArea1,textArea2,textArea3,textAreaCarrito;
    private int costoTotalCarrito;

    public VentanaOferta(String tipoCliente,String nombreCliente,AplicacionUsuarios app){
        this.app = app;
        setTitle("Lelia Merca Gourmet");
		setBounds(100, 100, 1800, 1200);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        c.setBackground(new Color(90,101,150));


        Color oro = new Color(234,190,63);
        //Creamos el icono de nuestra aplicacion
		java.awt.Image icon = new ImageIcon(getClass().getResource("./img/logo.png")).getImage();
        setIconImage(icon);


                        //Imagen
        ImageIcon logo = new ImageIcon(getClass().getResource("./img/logo.png"));
		LaminaConImagen laminaConImagen = new LaminaConImagen(logo);
        c.add(laminaConImagen,createConstraints(0,0,1,2,0.5,1.5,
		GridBagConstraints.BOTH,GridBagConstraints.EAST,new Insets(0, 0, 0, 0)));

        //Label carrito
        txtCarritoDeCompra = new JLabel("Carrito de compra");
        txtCarritoDeCompra.setFont(new Font("Arial",Font.BOLD,25));
        txtCarritoDeCompra.setForeground(oro);
        c.add(txtCarritoDeCompra,createConstraints(0,1,1,1,0.5,0.05,
		GridBagConstraints.NONE,GridBagConstraints.SOUTHWEST,new Insets(370, 49, 0, 0)));


        //Carrito de compra
        panelCarrito = new JPanel();
        panelCarrito.setLayout(new GridBagLayout());;
        textAreaCarrito = new JTextArea();
        textAreaCarrito.setFont(new Font("Arial",Font.BOLD,18));
        textAreaCarrito.setEditable(false);
        textAreaCarrito.setWrapStyleWord(true);
        textAreaCarrito.setAutoscrolls(true);
        textAreaCarrito.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, oro));
        panelCarrito.add(textAreaCarrito,createConstraints(0,0,1,2,100,100,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,new Insets(0, 0, 0, 0)));
        c.add(panelCarrito,createConstraints(0,2,1,1,0.5,0.5,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,new Insets(0, 49, 0, 0)));




        //Boton pagar1
        panelPagoLimpiar = new JPanel();
        panelPagoLimpiar.setLayout(new FlowLayout());
        panelPagoLimpiar.setBackground(new Color(90,101,150,0));
        c.add(panelPagoLimpiar,createConstraints(0,3,1,1,0.5,0.5,
		GridBagConstraints.BOTH,GridBagConstraints.NORTH,new Insets(0, 0, 0, 0)));
        btnPagar = new JButton("Tramitar pedido");
        btnPagar.setBackground(Color.GREEN);

        btnLimpiarCarrito = new JButton("Limpiar carrito");
        btnLimpiarCarrito.setBackground(Color.WHITE);
        panelPagoLimpiar.add(btnPagar);
        panelPagoLimpiar.add(btnLimpiarCarrito);

        //Añadimos el evento
        OyenteBotonPagar oyenteBotonPagar = new OyenteBotonPagar();
        btnPagar.addActionListener(oyenteBotonPagar);
        btnLimpiarCarrito.addActionListener(oyenteBotonPagar);
        //Texto Ofertas
        txtOfertas = new JLabel("Ofertas Semanales");
        txtOfertas.setFont(new Font("Arial",Font.BOLD,56));
        txtOfertas.setForeground(oro);
        c.add(txtOfertas,createConstraints(1,0,1,1,1.0,1,
		GridBagConstraints.VERTICAL,GridBagConstraints.CENTER,new Insets(0, 0, 0, 0)));


        //Texto Bienvenida
        textoBienvenido = new JLabel("Bienvenido: " + nombreCliente);
        textoBienvenido.setFont(new Font("Arial",Font.BOLD,24));
       	c.add(textoBienvenido,createConstraints(2,0,1,1,1.0,1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,new Insets(10, 10, 50, 15)));

        //Boton CerrarSesion
        btnCerrarSesion = new JButton("Cerrar sesion");
        c.add(btnCerrarSesion,createConstraints(2,1,1,0,1.0,1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,new Insets(-50, 0, 0, 10)));
        btnCerrarSesion.addActionListener(oyenteBotonPagar);

        //Boton Activar Ofertas

        

    //PANEL1
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        c.add(panel1,createConstraints(1,1,1,1,1.0,1,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(20, 200, 20, 0)));
        panel1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, oro));
      setVisible(true);
        //IMAGEN 2
        ImageIcon img1 = new ImageIcon(getClass().getResource("./img/cesta1.jpg"));
        LaminaConImagenContenedor laminaConImagen1 = new LaminaConImagenContenedor(img1);
        panel1.add(laminaConImagen1,createConstraints(0,0,2,4,2,4,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,new Insets(0, 0, 0, 0)));

        nombreProducto1 = new JLabel("Cesta Gourmet 1");
        nombreProducto1.setFont(new Font("Arial",Font.BOLD,24));
        panel1.add(nombreProducto1,createConstraints(2,0,2,1,1.0,1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(0, 15, 0, 0)));

        textArea1 = new JTextArea("Este lote de Navidad contiene:\r\n" + //
                "-Bebidas:\r\n" + //
                "1 Botella 75 cl cava brut reserva Segura Viudas\r\n" + //
                "\r\n" + //
                "-Charcutería:\r\n" + //
                "1 Pieza 5 - 5,5 kg aprox. paleta ibérica de cebo envasada\r\n" + //
                "al vacío y con malla Sánchez Alcaraz\r\n" + //
                "\r\n" + //
                "-Conservas y Otros:\r\n" + //
                "1 Bolsa 70 g nueces mondadas Gancedo\r\n" + //
                "1 Brik 1 l caldo natural navidad Aneto\r\n" + //
                "\r\n" + //
                "-Turrones y Dulces:\r\n" + //
                "1 Estuche 100 g valentinos de avellana y oblea E. Moreno");
        textArea1.setEditable(false);
        panel1.add(textArea1,createConstraints(2,1,1,1,0.1,0.2,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,new Insets(0, 15, 0, 0)));

        if (tipoCliente.equals("esporadico")) {
            txtprecio1 = new JLabel("432€");
            txtprecio1.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio1.setForeground(oro);
        }else if (tipoCliente.equals("club")) {
            txtprecio1 = new JLabel("Oferta cliente club: 375€");
            txtprecio1.setFont(new Font("Arial",Font.BOLD,18));
            txtprecio1.setForeground(Color.RED);

            panel1.add(txtprecio1,createConstraints(3,2,1,1,0.1,0.1,
		    GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(10, 15, 10, 0)));
        }else if (tipoCliente.equals("premium")) {
            txtprecio1 = new JLabel("Oferta cliente premium: 330€");
            txtprecio1.setFont(new Font("Arial",Font.BOLD,18));
            txtprecio1.setForeground(new Color(90,101,150));
        }

        panel1.add(txtprecio1,createConstraints(2,2,1,1,0.1,0.1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(10, 15, 10, 0)));
        

        //Cantidades
        panelCantidades1 = new JPanel();
        panelCantidades1.setLayout(new FlowLayout());
        panel1.add(panelCantidades1,createConstraints(2,3,1,1,1,1,
		GridBagConstraints.VERTICAL,GridBagConstraints.WEST,new Insets(5, 15, 20, 0)));
        value1 =  new SpinnerNumberModel(0,0,999,1);
        spinner1 = new JSpinner(value1);
        addCarrito1 = new JButton("Añadir al carrito");
        addCarrito1.setBackground(Color.GREEN);
        panelCantidades1.add(spinner1);
        panelCantidades1.add(addCarrito1);

        //Añadimos el evento
        OyenteAddCarrito oyenteAddCarrito = new OyenteAddCarrito();
        addCarrito1.addActionListener(oyenteAddCarrito);


        //PANEL2
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        c.add(panel2,createConstraints(1,2,1,1,1.0,1,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(20, 200, 20, 0)));
        panel2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, oro));
      setVisible(true);
        //IMAGEN 2
        ImageIcon img2 = new ImageIcon(getClass().getResource("./img/jamon.jpg"));
        LaminaConImagenContenedor laminaConImagen2 = new LaminaConImagenContenedor(img2);
        panel2.add(laminaConImagen2,createConstraints(0,0,2,4,2,4,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,new Insets(0, 0, 0, 0)));

        nombreProducto2 = new JLabel("Cesta Gourmet 2");
        nombreProducto2.setFont(new Font("Arial",Font.BOLD,24));
        panel2.add(nombreProducto2,createConstraints(2,0,2,1,1.0,1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(0, 15, 0, 0)));

        textArea2 = new JTextArea("Este lote de Navidad contiene:\r\n" + //
                "-Bebidas:\r\n" + //
                "1 Botella 75 cl cava brut reserva Segura Viudas\r\n" + //
                "\r\n" + //
                "-Charcutería:\r\n" + //
                "1 Pieza 5 - 5,5 kg aprox. paleta ibérica de cebo envasada\r\n" + //
                "al vacío y con malla Sánchez Alcaraz\r\n" + //
                "\r\n" + //
                "-Conservas y Otros:\r\n" + //
                "1 Bolsa 70 g nueces mondadas Gancedo\r\n" + //
                "1 Brik 1 l caldo natural navidad Aneto\r\n" + //
                "\r\n" + //
                "-Turrones y Dulces:\r\n" + //
                "1 Estuche 100 g valentinos de avellana y oblea E. Moreno");
        textArea2.setEditable(false);
        panel2.add(textArea2,createConstraints(2,1,1,1,0.1,0.2,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,new Insets(0, 15, 0, 0)));
        

        if (tipoCliente.equals("esporadico")) {
            txtprecio2 = new JLabel("432€");
            txtprecio2.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio2.setForeground(oro);
        }else if (tipoCliente.equals("club")) {
            txtprecio2 = new JLabel("Oferta cliente club: 375€");
            txtprecio2.setFont(new Font("Arial",Font.BOLD,18));
            txtprecio2.setForeground(Color.RED);
        }else if (tipoCliente.equals("premium")) {
            txtprecio2 = new JLabel("Oferta cliente premium: 330€");
            txtprecio2.setFont(new Font("Arial",Font.BOLD,18));
            txtprecio2.setForeground(new Color(90,101,150));
        }

        panel2.add(txtprecio2,createConstraints(2,2,1,1,0.1,0.1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(10, 15, 10, 0)));


        //Cantidades
        panelCantidades2 = new JPanel();
        panelCantidades2.setLayout(new FlowLayout());
        panel2.add(panelCantidades2,createConstraints(2,3,1,1,1,1,
		GridBagConstraints.VERTICAL,GridBagConstraints.WEST,new Insets(5, 15, 20, 0)));
        value2 =  new SpinnerNumberModel(0,0,999,1);
        spinner2 = new JSpinner(value2);
        addCarrito2 = new JButton("Añadir al carrito");
        addCarrito2.setBackground(Color.GREEN);
        panelCantidades2.add(spinner2);
        panelCantidades2.add(addCarrito2);
        addCarrito2.addActionListener(oyenteAddCarrito);


        //PANEL3
        panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        c.add(panel3,createConstraints(1,3,1,3,1.0,1.0,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(0, 200, 20, 0)));
        panel3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, oro));
      setVisible(true);

        //IMAGEN 3
        ImageIcon img3 = new ImageIcon(getClass().getResource("./img/mejoresproductos.jpg"));
        LaminaConImagenContenedor laminaConImagen3 = new LaminaConImagenContenedor(img3);
        panel3.add(laminaConImagen3,createConstraints(0,0,2,4,2,4,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,new Insets(0, 0, 0, 0)));

        nombreProducto3 = new JLabel("Cesta Gourmet 3");
        nombreProducto3.setFont(new Font("Arial",Font.BOLD,24));
        panel3.add(nombreProducto3,createConstraints(2,0,2,1,1.0,0.2,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(0, 15, 0, 0)));

        textArea3 = new JTextArea("Este lote de Navidad contiene:\r\n" + //
                "-Bebidas:\r\n" + //
                "1 Botella 75 cl cava brut reserva Segura Viudas\r\n" + //
                "\r\n" + //
                "-Charcutería:\r\n" + //
                "1 Pieza 5 - 5,5 kg aprox. paleta ibérica de cebo envasada\r\n" + //
                "al vacío y con malla Sánchez Alcaraz\r\n" + //
                "\r\n" + //
                "-Conservas y Otros:\r\n" + //
                "1 Bolsa 70 g nueces mondadas Gancedo\r\n" + //
                "1 Brik 1 l caldo natural navidad Aneto\r\n" + //BOTH
                "\r\n" + //
                "-Turrones y Dulces:\r\n" + //
                "1 Estuche 100 g valentinos de avellana y oblea E. Moreno");
        textArea3.setEditable(false);
        panel3.add(textArea3,createConstraints(2,1,1,1,0.1,0.2,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,new Insets(0, 15, 0, 0)));


            if (tipoCliente.equals("esporadico")) {
            txtprecio3 = new JLabel("432€");
            txtprecio3.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio3.setForeground(oro);
        }else if (tipoCliente.equals("club")) {
            txtprecio3 = new JLabel("Oferta cliente club: 375€");
            txtprecio3.setFont(new Font("Arial",Font.BOLD,18));
            txtprecio3.setForeground(Color.RED);
        }else if (tipoCliente.equals("premium")) {
            txtprecio3 = new JLabel("Oferta cliente premium: 330€");
            txtprecio3.setFont(new Font("Arial",Font.BOLD,18));
            txtprecio3.setForeground(new Color(90,101,150));
        }
        panel3.add(txtprecio3,createConstraints(2,2,1,1,0.1,0.1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,new Insets(10, 15, 10, 0)));


        //Cantidades
        panelCantidades3 = new JPanel();
        panelCantidades3.setLayout(new FlowLayout());
        panel3.add(panelCantidades3,createConstraints(2,3,1,1,1,1,
		GridBagConstraints.VERTICAL,GridBagConstraints.WEST,new Insets(5, 15, 20, 0)));
        value3 =  new SpinnerNumberModel(0,0,999,1);
        spinner3 = new JSpinner(value3);
        addCarrito3 = new JButton("Añadir al carrito");
        addCarrito3.setBackground(Color.GREEN);
        panelCantidades3.add(spinner3);
        panelCantidades3.add(addCarrito3);
        addCarrito3.addActionListener(oyenteAddCarrito);

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
		//Pintamos nuestra imagen
		Dimension size = getSize();
		g.drawImage(image.getImage(),0,0,250, 150,null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

class LaminaConImagenContenedor extends JPanel{
    private ImageIcon image;

    public LaminaConImagenContenedor(ImageIcon image){ 
        this.image = image;
    }
    
	@Override
	public void paintComponent(Graphics g){
        Dimension size = getSize();
		g.drawImage(image.getImage(),0,0,size.width, size.height,null);
		setOpaque(false);
		super.paintComponent(g);
	}
}


    //Funcionalidad
    //Boton pagar
    class OyenteBotonPagar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();

            if (boton.equals(btnPagar)) {
                JOptionPane.showConfirmDialog(null, "¿Quieres tramitar el pedido de: " + costoTotalCarrito + "€?" );

            }if (boton.equals(btnLimpiarCarrito)) {
                textAreaCarrito.setText("");
                costoTotalCarrito = 0;
            }if (boton.equals(btnCerrarSesion)) {
                
                app.cerrarSesion(app);
            }
            
        }

    }


    class OyenteAddCarrito implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            
            if (boton.equals(addCarrito1)) {
                String cant = spinner1.getValue().toString();
                String title = nombreProducto1.getText();
                String precio = txtprecio1.getText().substring(0,txtprecio1.getText().length() - 1);
                int total = Integer.parseInt(precio) * Integer.parseInt(cant);
                if (cant.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Tienes que añadir al menos un articulo", "Fallo al añadir articulo", JOptionPane.WARNING_MESSAGE);
                }else{
                    introducirValoresCarrito(cant, title, precio,textAreaCarrito,total);
                } 
            }if (boton.equals(addCarrito2)) {
                String cant = spinner2.getValue().toString();
                String title = nombreProducto2.getText();
                String precio = txtprecio2.getText().substring(0,txtprecio2.getText().length() - 1);
                int total = Integer.parseInt(precio) * Integer.parseInt(cant);
                if (cant.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Tienes que añadir al menos un articulo", "Fallo al añadir articulo", JOptionPane.WARNING_MESSAGE);
                }else{
                    introducirValoresCarrito(cant, title, precio,textAreaCarrito,total);
                } 
            }if (boton.equals(addCarrito3)) {
                String cant = spinner3.getValue().toString();
                String title = nombreProducto3.getText();
                String precio = txtprecio3.getText().substring(0,txtprecio3.getText().length() - 1);
                int total = Integer.parseInt(precio) * Integer.parseInt(cant);
                if (cant.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Tienes que añadir al menos un articulo", "Fallo al añadir articulo", JOptionPane.WARNING_MESSAGE);
                }else{
                    introducirValoresCarrito(cant, title, precio,textAreaCarrito,total);
                } 
            }
        }

    }

    private void introducirValoresCarrito(String cant, String title,String precio,JTextArea area,int total){
        String text = textAreaCarrito.getText();
        costoTotalCarrito += total;
        text += "\n" + title  + " "+ "X" + " " + cant + "     " + "Total: " + total+ "€";
        area.setText(text);
    }
}
    
