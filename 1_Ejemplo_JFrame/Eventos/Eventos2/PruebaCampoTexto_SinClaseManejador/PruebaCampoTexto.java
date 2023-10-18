/*  Demostraci�n de la clase JTextField. En este ejemplo la funcionalidad y el diseño está implementado en un único archivo
 La clase principal PruebaCampoTexto es un JFrame, por lo tanto hereda todas las características y métodos de un JFrame
 Para dar funcionalidad :
 1.- Implementamos la interfaz ActionListener
 2.- Sobreescribir los métodos de dicha interfaz, en este caso sólo tenemos un métod ActionPerformed
 3.- Poner los componentes a la escucha AddActionListener, el cual manda como argumento la palabra reservada this, y ejecuta el 
 método ActionPerformed (ActionEvent evento), En este caso el this hace referencia al componente sobre el que se produce dicho evento
 que es cada uno de los cuadros de texto. En dicha función recibe el cuadro de texto sobre el que hacemos clic y con los métodos asociados
 al ActionEvent (getActionCommand, getSource, etc) obtenemos toda la información que necesitamos.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaCampoTexto extends JFrame implements ActionListener
{
   private JTextField campoTexto1, campoTexto2, campoTexto3;
   private JPasswordField campoContrasenia;

   // configurar GUI
   public PruebaCampoTexto()
   {
      super( "Prueba de JTextField y JPasswordField" );

      Container contenedor = getContentPane();
      contenedor.setLayout( new FlowLayout() );

      // crear campo de texto con tama�o predeterminado
      campoTexto1 = new JTextField( 10 );
      contenedor.add( campoTexto1 );

      // crear campo de texto con texto predeterminado
      campoTexto2 = new JTextField( "Escriba el texto aqu�" );
      contenedor.add( campoTexto2 );

      // crear campo de texto con texto predeterminado,
      // 20 elementos visibles y sin manejador de eventos
      campoTexto3 = new JTextField( "Campo de texto no editable", 20 );
      campoTexto3.setEditable( false );
      campoTexto3.setToolTipText("No se edita");
      contenedor.add( campoTexto3 );

      // crear campo de contraseña con texto predeterminado
      campoContrasenia = new JPasswordField( "Texto oculto" );
      contenedor.add( campoContrasenia );

      
      campoTexto1.addActionListener( this );
      campoTexto2.addActionListener( this );
      campoTexto3.addActionListener( this );
      campoContrasenia.addActionListener( this );

      setSize( 325, 100 );
      setVisible( true );

   } // fin del constructor de PruebaCampoTexto

   public static void main( String args[] )
   { 
      JFrame.setDefaultLookAndFeelDecorated(true);
      PruebaCampoTexto aplicacion = new PruebaCampoTexto();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   

   @Override
   public void actionPerformed(ActionEvent evento) {
      // TODO Auto-generated method stub
      String cadena = "";

      // el usuario oprime Intro en objeto JTextField campoTexto1
      if ( evento.getSource() == campoTexto1 )
         cadena = "campoTexto1: " + evento.getActionCommand();

      // el usuario oprime Intro en objeto JTextField campoTexto2
      else if ( evento.getSource() == campoTexto2 )
         cadena = "campoTexto2: " + evento.getActionCommand();

      // el usuario oprimie Intro en objeto JTextField campoTexto3
      else if ( evento.getSource() == campoTexto3 )
         cadena = "campoTexto3: " + evento.getActionCommand();

      // el usuario oprimie Intro en objeto JTextField campoContrasenia
      else if ( evento.getSource() == campoContrasenia ) {
         cadena = "campoContrasenia: " + 
            new String( campoContrasenia.getPassword() );
      }

      JOptionPane.showMessageDialog( null, cadena,"Resultados",JOptionPane.CANCEL_OPTION);
   }

} // fin de la clase PruebaCampoTexto