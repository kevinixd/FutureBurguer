/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Empleados;
import vista.JfrmLogin;
import vista.JfrmPrincipal;
import static controlador.VariablesEstaticas.usuario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.input.KeyCode;

/**
 * Clase donde el empleado tiene que inicial secion en la aplicaicon, para ello
 * tiene que ingresar su usuario y su contraseña, y esta clase se encargara de
 * verificar sus datos y validar campos.
 *
 * @author javam2019
 */
public class EmpleadoControlador implements ActionListener, KeyListener {

    JfrmLogin fromLogin;
    DaoEmpleados dao = new DaoEmpleados();
    Empleados emp = new Empleados();

    private int comprobarCampos = 0;
    private boolean verificar = false;

    public EmpleadoControlador(JfrmLogin fromLogin) {
        this.fromLogin = fromLogin;
        fromLogin.jBtnEntrar.addActionListener(this);
        fromLogin.jTxtPass.addKeyListener(this);
        fromLogin.jTxtUser.addKeyListener(this);
        fromLogin.jTxtUser.requestFocus();
        fromLogin.jLblError.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fromLogin.jBtnEntrar) {
            validarCampos();
            verificarUsuario();
            System.out.println(comprobarCampos);
        }
    }

    /**
     * Método para asignar datos al modelo por medio de los TextField
     */
    public void datos() {
        emp.setEmpleadocorreo(String.valueOf(fromLogin.jTxtUser.getText()));
        emp.setContraseña(String.valueOf(fromLogin.jTxtPass.getText()));
    }

    /**
     * Método para verificar si los datos ingresados por el usuario son
     * correctos y si es así se le permite el ingreso al sistema en dado caso el
     * empleado sea de tipo Repartidor y/o Motorista se le mostrará un mensaje
     * en el que dirá que el formulario no está en construccion o que no tiene
     * acceso al sistema
     */
    public void verificarUsuario() {
        if (verificar == false) {
            Empleados p = new Empleados();
            datos();
            p = dao.confirmarUsuario(emp);

            //Se verifican si los datos son correctos
            if ((p.getEmpleadonombre() != null) && (p.getTipoempleado_id() == 1)) {
                JfrmPrincipal vista = new JfrmPrincipal();
                PrincipalControlador controladorPrincipal = new PrincipalControlador(vista);

                //Se le asigna un tamaño para la pantalla completa
                vista.setExtendedState(6);

                //Asignamos el nombre y apellido a la etiqueta del formulario principal
                vista.jLblUsuario.setText(p.getEmpleadonombre() + "" + p.getEmpleadoapellido());
                vista.setVisible(true);

                //Escondemos el formulario del Login
                fromLogin.hide();
            } else if ((p.getEmpleadonombre() != null) && (p.getTipoempleado_id() == 2)) {
                //SI el usuario es tipo repartidor mostramos el mensaje:
                JOptionPane.showMessageDialog(fromLogin, "No tiene accesso al sistema");
            } else {
                //Si los valores son erroneos mostramos el mensaje:
                JOptionPane.showMessageDialog(fromLogin, "Datos Incorrectos");
            }
        }

    }

    /**
     * Método para validar los campos del frame y si estos contienen valores
     * correctos y predeterminados
     */
    public void validarCampos() {

        //Variable para aumentar si alguno de los campos está erroneo
        comprobarCampos = 0;

        if (fromLogin.jTxtUser.getText().isEmpty() && fromLogin.jTxtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(fromLogin, "Campo contraseña y usuario requerido");

            //Cada vez que se comete un error esta variable aumenta
            comprobarCampos++;

        } else if (fromLogin.jTxtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(fromLogin, "Campo Contraseña requerido");

            //Cada vez que se comete un error esta variable aumenta
            comprobarCampos++;

        } else if (fromLogin.jTxtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(fromLogin, "Campos usuario requerido");

            //Cada vez que se comete un error esta variable aumenta
            comprobarCampos++;

        } else if (!fromLogin.jTxtUser.getText().contains("@") || !fromLogin.jTxtUser.getText().contains(".")) {
            fromLogin.jLblError.setText("Correo Invalido");

            //Cada vez que se comete un error esta variable aumenta
            comprobarCampos++;

        } else {
            fromLogin.jLblError.setText(" ");
        }

        //Si la variable es diferente de cero asignamos true, mostrando que si hay errores
        if (comprobarCampos != 0) {
            verificar = true;
        } else {

            //De lo contrario, se asigna false
            verificar = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        /*
        *Para hacer el programa más amigable al usuario hacemos que por medio de la tecla enter vaya cambiando el foco
        *de los textField para al fin llegar al boton
         */
        if (e.getSource() == fromLogin.jTxtUser) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                fromLogin.jTxtPass.requestFocus();
            }
        }

        if (e.getSource() == fromLogin.jTxtPass) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                fromLogin.jBtnEntrar.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
