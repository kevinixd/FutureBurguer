package vista;

import controlador.EmpleadoControlador;
import controlador.PrincipalControlador;

public class Ejecutable {
    public static void main(String[] args) {
        JfrmLogin vista = new JfrmLogin();
        EmpleadoControlador controlador_empleado = new EmpleadoControlador(vista);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
