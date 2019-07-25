package vista;

import controlador.ClienteControlador;

public class Prueba {
    public static void main(String[] args) {
        JfrmCliente vista = new JfrmCliente();
        ClienteControlador controlador = new ClienteControlador(vista);
        vista.setVisible(true);
        
    }
}
