public class AplicacionUsuarios {
    VentanaInicioSesion ventanaInicioSesion;
    VentanaOferta ventanaOferta;


    public void ejecutar(){
        ventanaInicioSesion = new VentanaInicioSesion(this);
        ventanaInicioSesion.setVisible(true);
    }


    public void mostrarVentanaOfertas(String tipoCliente,String nombreCliente,AplicacionUsuarios app){
                ventanaOferta = new VentanaOferta(tipoCliente,nombreCliente,app);
                ventanaOferta.setVisible(true);
    }

    public void cerrarSesion(AplicacionUsuarios app){
            ventanaInicioSesion.setVisible(false);
            ventanaOferta.setVisible(false);
            ejecutar();
    }

}
