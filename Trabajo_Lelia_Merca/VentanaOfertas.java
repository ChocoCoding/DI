import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class VentanaOfertas extends JFrame{

    //ATRIBUTOS
    JLabel textoBienvenido,nombreProducto1,nombreProducto2,nombreProducto3,
    precio1,precio2,precio3,txtprecio1,txtprecio2,txtprecio3,txtCant1,txtCant2,txtCant3,
    txtOfertas,txtCarritoDeCompra,labelPanelDerecho,labelClienteClub,labelClientePremium;

    JSpinner cant1,cant2,cant3;

    JButton btnCancelar,btnPagar,btnCerrarSesion,addCarrito1,addCarrito2,addCarrito3,btnLimpiarCarrito,btnCuponclub,btnCuponPremium;

    JPanel panelTop,panelIzq,panelCentral,panelDerecho;

    JPanel panel1,panel2,panel3,panel4Vacio,panelImg1,panelImg2,panelImg3,panelboton,panelCantidades1,panelCantidades2,
    panelCantidades3,panelPagoLimpiar,panelActivarOfertasm,panelLogin,panelVacio1,panelClienteClub,panelClientePremium;

    Container c;

    AplicacionUsuarios app;

    SpinnerModel value1,value2,value3;

    JSpinner spinner1,spinner2,spinner3;

    JTextArea textArea1,textArea2,textArea3,textAreaCarrito;

    private int costoTotalCarrito;

    //COLORES
    Color oro = new Color(234,190,63);
    Color colorFondo = new Color(90,101,150);

    public VentanaOfertas(String tipoCliente,String nombreCliente,AplicacionUsuarios app){

        //Listeners
        OyenteBotonPagar oyenteBotonPagar = new OyenteBotonPagar();
        OyenteAddCarrito oyenteAddCarrito = new OyenteAddCarrito();

        //PROPIEDADES DEL JFRAME
        this.app = app;
        setTitle("Lelia Merca Gourmet");
        this.setBounds(0,0, 1280, 840);
        setLocationRelativeTo(null);
		c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        //Creamos el icono de nuestra aplicacion
		java.awt.Image icon = new ImageIcon(getClass().getResource("./img/logo.png")).getImage();
        setIconImage(icon);
        
        //PANEL TOP
        panelTop = new JPanel();
        panelTop.setLayout(new GridBagLayout());
        
        c.add(panelTop,createConstraints(0,0,3,1,3,0.3,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,0,0,new Insets(0, 0, 0, 0)));
        
        //Imagen
        ImageIcon logo = new ImageIcon(getClass().getResource("./img/logo.png"));
        LaminaConImagen laminaConImagen = new LaminaConImagen(logo);
        panelTop.add(laminaConImagen,createConstraints(0,0,1,1,0.6,1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,60,new Insets(0, 0, 0, 0)));

        //Texto Ofertas
        txtOfertas = new JLabel("Ofertas Semanales");
        txtOfertas.setFont(new Font("Arial",Font.BOLD,40));
        txtOfertas.setForeground(oro);
        panelTop.add(txtOfertas,createConstraints(1,0,1,0,0.3,1,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,0,0,new Insets(0, 30, 0, 0)));


        //PANEL LOGIN
        panelLogin = new JPanel();
        panelLogin.setLayout(new GridLayout(2,1));
        panelTop.add(panelLogin,createConstraints(2,0,1,1,0.1,1,
        GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,0,0,new Insets(0, 0, 0, 0)));
        //Texto Bienvenida
        textoBienvenido = new JLabel("Bienvenido: " + nombreCliente);
        textoBienvenido.setFont(new Font("Arial",Font.BOLD,24));
        panelLogin.add(textoBienvenido);
        //Boton CerrarSesion
        btnCerrarSesion = new JButton("Cerrar sesion");
        panelLogin.add(btnCerrarSesion);

        btnCerrarSesion.addActionListener(oyenteBotonPagar);

        //PANEL IZQUIERDO
        panelIzq = new JPanel();
        panelIzq.setLayout(new GridBagLayout());;
        c.add(panelIzq,createConstraints(0,1,1,1,0.3,0.95,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,0,0,new Insets(0, 20, 0, 20)));
        panelIzq.setBackground(new Color(255,255,255,0));
        panelIzq.setOpaque(false);

        //Texto carrito
        txtCarritoDeCompra = new JLabel("Carrito de compra");
        txtCarritoDeCompra.setFont(new Font("Arial",Font.BOLD,20));
        txtCarritoDeCompra.setForeground(oro);
        panelIzq.add(txtCarritoDeCompra,createConstraints(0,0,1,1,1,0.1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,0,new Insets(0, 0, 0, 0)));

        //Carrito de compra
        textAreaCarrito = new JTextArea();
        textAreaCarrito.setFont(new Font("Arial",Font.BOLD,18));
        textAreaCarrito.setEditable(false);
        textAreaCarrito.setWrapStyleWord(true);
        textAreaCarrito.setAutoscrolls(true);
        textAreaCarrito.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, oro));
        panelIzq.add(textAreaCarrito,createConstraints(0,1,1,1,1,0.8,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,0,new Insets(0, 0, 0, 0)));

        //Boton pagar1
        panelPagoLimpiar = new JPanel();
        panelPagoLimpiar.setLayout(new FlowLayout());
        panelPagoLimpiar.setBackground(new Color(90,101,150,0));
        btnPagar = new JButton("Tramitar pedido");
        btnPagar.setBackground(Color.GREEN);
        btnLimpiarCarrito = new JButton("Limpiar carrito");
        btnLimpiarCarrito.setBackground(Color.WHITE);
        panelPagoLimpiar.add(btnPagar);
        panelPagoLimpiar.add(btnLimpiarCarrito);

        panelIzq.add(panelPagoLimpiar,createConstraints(0,2,1,1,1,0.1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,0,new Insets(0, 0, 0, 0)));

        //Añadimos el evento
        btnPagar.addActionListener(oyenteBotonPagar);
        btnLimpiarCarrito.addActionListener(oyenteBotonPagar);


        //PANEL CENTRAL
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridBagLayout());
        c.add(panelCentral,createConstraints(1,1,1,1,0.6,0.95,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,0,0,new Insets(0, 0, 0, 0)));

        //PANEL 1
        panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setLayout(new GridBagLayout());
        panelCentral.add(panel1,createConstraints(0,0,1,1,1,0.28,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,0,0,new Insets(5, 0, 0, 0)));
        panel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, oro));

        ImageIcon img1 = new ImageIcon(getClass().getResource("./img/jamon.jpg"));
        LaminaConImagenContenedor laminaConImagen1 = new LaminaConImagenContenedor(img1);
        panel1.add(laminaConImagen1,createConstraints(0,0,2,4,1,0.28,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,0,0,new Insets(0, 0, 0, 0)));

        nombreProducto1 = new JLabel("Cesta Gourmet 1");
        nombreProducto1.setFont(new Font("Arial",Font.BOLD,20));
        panel1.add(nombreProducto1,createConstraints(2,0,1,1,0.5,0.1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,5,new Insets(0, 30, 0, 0)));

        textArea1 = new JTextArea("Este lote de Navidad contiene:\r\n" + //
                "-Bebidas:\r\n" + //
                "1 Botella 75 cl cava brut reserva Segura Viudas\r\n" + //
                "-Charcutería:\r\n" + //
                "1 Pieza 5 - 5,5 kg aprox. paleta ibérica de cebo envasada\r\n" + //
                "-Conservas y Otros:\r\n" + //
                "1 Bolsa 70 g nueces mondadas Gancedo\r\n"
                );
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Arial",Font.PLAIN,14));
        panel1.add(textArea1,createConstraints(2,1,1,1,0.5,0.6,
		GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTHWEST,-100,0,new Insets(0, 30, 0, 0)));
        
        if (tipoCliente.equals("esporadico")) {
            txtprecio1 = new JLabel("114€");
            txtprecio1.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio1.setForeground(oro);
        }else if (tipoCliente.equals("club")) {
            txtprecio1 = new JLabel("97€");
            txtprecio1.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio1.setForeground(Color.MAGENTA);
        }else if (tipoCliente.equals("premium")) {
            txtprecio1 = new JLabel("71€");
            txtprecio1.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio1.setForeground(Color.CYAN);
        }
        panel1.add(txtprecio1,createConstraints(2,2,1,1,0.5,0.1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,0,0,new Insets(0, 30, 0, 0)));

        //Cantidades
        panelCantidades1 = new JPanel();
        panelCantidades1.setLayout(new FlowLayout());
        panelCantidades1.setBackground(Color.WHITE);
        panel1.add(panelCantidades1,createConstraints(2,3,1,1,0.5,0.2,
		GridBagConstraints.VERTICAL,GridBagConstraints.WEST,0,0,new Insets(0, 30, 0, 0)));
        value1 =  new SpinnerNumberModel(0,0,999,1);
        spinner1 = new JSpinner(value1);
        addCarrito1 = new JButton("Añadir al carrito");
        addCarrito1.setBackground(Color.GREEN);
        panelCantidades1.add(spinner1);
        panelCantidades1.add(addCarrito1);
        addCarrito1.addActionListener(oyenteAddCarrito);
       

        //PANEL 2
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panelCentral.add(panel2,createConstraints(0,1,1,1,1,0.28,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,0,0,new Insets(5, 0, 0, 0)));
        panel2.setBackground(Color.white);
        panel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, oro));

        ImageIcon img2 = new ImageIcon(getClass().getResource("./img/cesta1.jpg"));
        LaminaConImagenContenedor laminaConImagen2 = new LaminaConImagenContenedor(img2);
        panel2.add(laminaConImagen2,createConstraints(0,0,2,4,1,0.28,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,0,0,new Insets(0, 0, 0, 0)));

        nombreProducto2 = new JLabel("Cesta Gourmet 2");
        nombreProducto2.setFont(new Font("Arial",Font.BOLD,20));
        panel2.add(nombreProducto2,createConstraints(2,0,1,1,0.5,0.1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,5,new Insets(0, 30, 0, 0)));

        textArea2 = new JTextArea("Este lote de Navidad contiene:\r\n" + //
                "-Bebidas:\r\n" + //
                "1 Botella 75 cl cava brut reserva Segura Viudas\r\n" + //
                "-Charcutería:\r\n" + //
                "1 Pieza 5 - 5,5 kg aprox. paleta ibérica de cebo envasada\r\n" + //
                "-Conservas y Otros:\r\n" + //
                "1 Bolsa 70 g nueces mondadas Gancedo\r\n"
                );
        textArea2.setEditable(false);
        textArea2.setFont(new Font("Arial",Font.PLAIN,14));
        panel2.add(textArea2,createConstraints(2,1,1,1,0.5,0.6,
		GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTHWEST,-100,0,new Insets(0, 30, 0, 0)));
        
        if (tipoCliente.equals("esporadico")) {
            txtprecio2 = new JLabel("480€");
            txtprecio2.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio2.setForeground(oro);
        }else if (tipoCliente.equals("club")) {
            txtprecio2 = new JLabel("394€");
            txtprecio2.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio2.setForeground(Color.MAGENTA);
        }else if (tipoCliente.equals("premium")) {
            txtprecio2 = new JLabel("320€");
            txtprecio2.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio2.setForeground(Color.CYAN);
        }
        panel2.add(txtprecio2,createConstraints(2,2,1,1,0.5,0.1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,0,0,new Insets(0, 30, 0, 0)));

        //Cantidades
        panelCantidades2 = new JPanel();
        panelCantidades2.setLayout(new FlowLayout());
        panelCantidades2.setBackground(Color.WHITE);
        panel2.add(panelCantidades2,createConstraints(2,3,1,1,0.5,0.2,
		GridBagConstraints.VERTICAL,GridBagConstraints.WEST,0,0,new Insets(0, 30, 0, 0)));
        value2 =  new SpinnerNumberModel(0,0,999,1);
        spinner2 = new JSpinner(value2);
        addCarrito2 = new JButton("Añadir al carrito");
        addCarrito2.setBackground(Color.GREEN);
        panelCantidades2.add(spinner2);
        panelCantidades2.add(addCarrito2);
        addCarrito2.addActionListener(oyenteAddCarrito);



        //PANEL 3
        panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panelCentral.add(panel3,createConstraints(0,2,1,1,1,0.28,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,0,0,new Insets(5, 0, 0, 0)));
        panel3.setBackground(Color.white);
        panel3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, oro));

        ImageIcon img3 = new ImageIcon(getClass().getResource("./img/mejoresproductos.jpg"));
        LaminaConImagenContenedor laminaConImagen3 = new LaminaConImagenContenedor(img3);
        panel3.add(laminaConImagen3,createConstraints(0,0,2,4,1,0.28,
		GridBagConstraints.BOTH,GridBagConstraints.WEST,0,0,new Insets(0, 0, 0, 0)));

        nombreProducto3 = new JLabel("Cesta Gourmet 3");
        nombreProducto3.setFont(new Font("Arial",Font.BOLD,20));
        panel3.add(nombreProducto3,createConstraints(2,0,1,1,0.5,0.1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,0,5,new Insets(0, 30, 0, 0)));

        textArea3 = new JTextArea("Este lote de Navidad contiene:\r\n" + //
                "-Bebidas:\r\n" + //
                "1 Botella 75 cl cava brut reserva Segura Viudas\r\n" + //
                "-Charcutería:\r\n" + //
                "1 Pieza 5 - 5,5 kg aprox. paleta ibérica de cebo envasada\r\n" + //
                "-Conservas y Otros:\r\n" + //
                "1 Bolsa 70 g nueces mondadas Gancedo\r\n"
                );
        textArea3.setEditable(false);
        textArea3.setFont(new Font("Arial",Font.PLAIN,14));
        panel3.add(textArea3,createConstraints(2,1,1,1,0.5,0.6,
		GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTHWEST,-100,0,new Insets(0, 30, 0, 0)));
        
        if (tipoCliente.equals("esporadico")) {
            txtprecio3 = new JLabel("569€");
            txtprecio3.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio3.setForeground(oro);
        }else if (tipoCliente.equals("club")) {
            txtprecio3 = new JLabel("512€");
            txtprecio3.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio3.setForeground(Color.MAGENTA);
        }else if (tipoCliente.equals("premium")) {
            txtprecio3 = new JLabel("474€");
            txtprecio3.setFont(new Font("Arial",Font.BOLD,24));
            txtprecio3.setForeground(Color.CYAN);
        }
        panel3.add(txtprecio3,createConstraints(2,2,1,1,0.5,0.1,
		GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,0,0,new Insets(0, 30, 0, 0)));

        //Cantidades
        panelCantidades3 = new JPanel();
        panelCantidades3.setLayout(new FlowLayout());
        panelCantidades3.setBackground(Color.WHITE);
        panel3.add(panelCantidades3,createConstraints(2,3,1,1,0.5,0.2,
		GridBagConstraints.VERTICAL,GridBagConstraints.WEST,0,0,new Insets(0, 30, 0, 0)));
        value3 =  new SpinnerNumberModel(0,0,999,1);
        spinner3 = new JSpinner(value3);
        addCarrito3 = new JButton("Añadir al carrito");
        addCarrito3.setBackground(Color.green);
        panelCantidades3.add(spinner3);
        panelCantidades3.add(addCarrito3);
        addCarrito3.addActionListener(oyenteAddCarrito);


        //panel4Vacio
        panel4Vacio = new JPanel();
        panel4Vacio.setLayout(new GridBagLayout());
        panelCentral.add(panel4Vacio,createConstraints(0,3,1,1,1,0.16,
		GridBagConstraints.BOTH,GridBagConstraints.CENTER,0,0,new Insets(0, 0, 0, 0)));

        //PANEL DERECHO
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.WHITE);
        panelDerecho.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, oro));
        c.add(panelDerecho,createConstraints(2,1,1,1,0.2,1,
		GridBagConstraints.BOTH,GridBagConstraints.NORTH,10,0,new Insets(0, 10, 0, 0)));

        if (tipoCliente.equals("esporadico")) {
            labelPanelDerecho = new JLabel("<html>Los clientes esporádicos,<br> no disponen de cupones</html>");
            labelPanelDerecho.setFont(new Font("Arial",Font.BOLD,18));

            panelDerecho.add(labelPanelDerecho,createConstraints(0,0,1,1,1,0.5,
		    GridBagConstraints.BOTH,GridBagConstraints.NORTH,0,10,new Insets(0, 0, 0, 0)));
    
        }else if (tipoCliente.equals("club")) {
            labelPanelDerecho = new JLabel("Cupones clientes club: ");
            labelPanelDerecho.setFont(new Font("Arial",Font.BOLD,18));
            panelClienteClub = new JPanel();
            panelClienteClub.setLayout(new GridLayout(2,1));
            labelClienteClub = new JLabel("15% de descuento");
            labelClienteClub.setFont(new Font("Arial",Font.BOLD,18));
            btnCuponclub = new JButton("Activar Cupón");
            btnCuponclub.setForeground(Color.WHITE);
            btnCuponclub.setBackground(Color.red);
            btnCuponclub.setFont(new Font("Arial",Font.BOLD,18));

            panelDerecho.add(labelPanelDerecho,createConstraints(0,0,1,1,0.2,0.5,
		    GridBagConstraints.BOTH,GridBagConstraints.NORTH,0,5,new Insets(0, 0, 0, 0)));

            panelDerecho.add(panelClienteClub,createConstraints(0,1,1,1,0.2,0.5,
		    GridBagConstraints.BOTH,GridBagConstraints.NORTH,10,0,new Insets(0, 0, 0, 0)));

            panelClienteClub.add(labelClienteClub);
            panelClienteClub.add(btnCuponclub);
            

        }else if (tipoCliente.equals("premium")) {
            labelPanelDerecho = new JLabel("Cupones clientes premium:");
            labelPanelDerecho.setFont(new Font("Arial",Font.BOLD,18));
            panelClientePremium = new JPanel();
            panelClientePremium.setLayout(new GridLayout(2,1));
            labelClientePremium = new JLabel("25% de descuento");
            labelClientePremium.setFont(new Font("Arial",Font.BOLD,18));
            btnCuponPremium = new JButton("Activar Cupón");
            btnCuponPremium.setForeground(Color.WHITE);
            btnCuponPremium.setBackground(Color.red);
            btnCuponPremium.setFont(new Font("Arial",Font.BOLD,18));

            panelDerecho.add(labelPanelDerecho,createConstraints(0,0,1,1,0.2,0.5,
		    GridBagConstraints.BOTH,GridBagConstraints.NORTH,0,5,new Insets(0, 0, 0, 0)));

            panelDerecho.add(panelClientePremium,createConstraints(0,1,1,1,0.2,0.5,
		    GridBagConstraints.BOTH,GridBagConstraints.NORTH,10,0,new Insets(0, 0, 0, 0)));

            panelClientePremium.add(labelClientePremium);
            panelClientePremium.add(btnCuponPremium);
        }



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
                        int ipadx,
                        int ipady,
                        Insets insets) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = gridx;
                constraints.gridy = gridy;
                constraints.gridwidth = gridwidth;
                constraints.gridheight = gridheight;
                constraints.weightx = weightx;
                constraints.weighty = weighty;
                constraints.ipadx = ipadx;
                constraints.ipady = ipady;
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
		g.drawImage(image.getImage(),0,0,150, 75,null);
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