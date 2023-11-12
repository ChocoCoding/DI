public class AplicacionUsuarios {
    VentanaInicioSesion ventanaInicioSesion;
    VentanaOfertas ventanaOfertas;


    public void ejecutar(){
        ventanaInicioSesion = new VentanaInicioSesion(this);
        ventanaInicioSesion.setVisible(true);
    }


    public void mostrarVentanaOferta(String tipoCliente,String nombreCliente,AplicacionUsuarios app){
                ventanaOfertas = new VentanaOfertas(tipoCliente,nombreCliente,app);
                ventanaOfertas.setVisible(true);
    }

    public void cerrarSesion(AplicacionUsuarios app){
            ventanaInicioSesion.setVisible(false);
            ventanaOfertas.setVisible(false);
            ejecutar();
    }

}
