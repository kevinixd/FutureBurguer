package controlador;

import dao.DaoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.JintCliente;

/**
 * Esta clase tiene como accion agregar a un nuevo cliente, y a buscar a los
 * clientes agregados, por medio de un formulario a mostrar.
 *
 * @author futureBurguer
 */
public class ClienteControlador implements ActionListener, KeyListener {

    //Formulario
    JintCliente fromCliente;
    DaoCliente dao = new DaoCliente();
    Cliente cl = new Cliente();

    private String mensaje;
    private String ruta = System.getProperty("user.dir");
    private String nl = System.getProperty("line.separator");

    public ClienteControlador(JintCliente fromCliente) {
        this.fromCliente = fromCliente;
        fromCliente.jBtnOrdenarCliente.addActionListener(this);
        fromCliente.jBtnBuscar.addActionListener(this);
        fromCliente.jBtnModificar.addActionListener(this);
        fromCliente.jBtnAgregarCliente.addActionListener(this);
        setKeyListeners();
        asignarImagenes();
        validarCampos();
        validarCamposParaAgregar();
        fromCliente.jLblClienteID.setVisible(true);
        fromCliente.jBtnAgregarCliente.setEnabled(false);
    }

    public void setKeyListeners() {
        fromCliente.jTxtApellido.addKeyListener(this);
        fromCliente.jTxtDire.addKeyListener(this);
        fromCliente.jTxtNit.addKeyListener(this);
        fromCliente.jTxtNombre.addKeyListener(this);
        fromCliente.jTxtTel.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fromCliente.jBtnAgregarCliente) {
            guardarCliente();
            validarCamposLlenos();
        }

        if (e.getSource() == fromCliente.jBtnBuscar) {
            buscarCliente();
            validarCamposLlenos();
        }

        if (e.getSource() == fromCliente.jBtnModificar) {
            modificarCliente();
            validarCamposLlenos();
        }
    }

    /**
     * Metodo para asignar imagenes a los botones dentro del formulario
     */
    public void asignarImagenes() {
        ImageIcon mod = new ImageIcon(ruta + "\\src\\main\\java\\img\\Modificar.png");
        ImageIcon add = new ImageIcon(ruta + "\\src\\main\\java\\img\\Agregar.png");
        ImageIcon modRed = new ImageIcon(mod.getImage().getScaledInstance(100, -1, java.awt.Image.SCALE_DEFAULT));
        ImageIcon addRed = new ImageIcon(add.getImage().getScaledInstance(100, -1, java.awt.Image.SCALE_DEFAULT));
        fromCliente.jBtnAgregarCliente.setIcon(addRed);
        fromCliente.jBtnModificar.setIcon(modRed);
    }

    /**
     * Método para guardar datos del cliente en la base de datos
     */
    public void guardarCliente() {
        asignarDatos();
        mensaje = dao.agregarCliente(cl);
        JOptionPane.showMessageDialog(fromCliente, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para modificar datos del cliente
     */
    public void modificarCliente() {
        cl.setClienteid(Integer.parseInt(fromCliente.jLblClienteID.getText()));
        mensaje = dao.modificarCliente(cl);
        JOptionPane.showMessageDialog(fromCliente, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para asignar los datos de las cajas de texto a los valores del
     * modelo
     */
    public void asignarDatos() {
        cl.setClientenit(String.valueOf(fromCliente.jTxtNit.getText()));
        cl.setClientenombre(String.valueOf(fromCliente.jTxtNombre.getText()));
        cl.setClienteapellido(String.valueOf(fromCliente.jTxtApellido.getText()));
        cl.setClientetelefono(Integer.parseInt(fromCliente.jTxtTel.getText()));
        cl.setClientedireccion(String.valueOf(fromCliente.jTxtDire.getText()));
    }

    /**
     * Método para poder buscar un cliente por medio del numero de télefono
     */
    public void buscarCliente() {
        int tel = Integer.parseInt(fromCliente.jTxtTel.getText());
        cl = dao.buscarCliente(tel);

        if (cl.getClientenombre() != null) {
            fromCliente.jLblClienteID.setText(String.valueOf(cl.getClienteid()));
            fromCliente.jTxtNombre.setText(String.valueOf(cl.getClientenombre()));
            fromCliente.jTxtApellido.setText(String.valueOf(cl.getClienteapellido()));
            fromCliente.jTxtTel.setText(String.valueOf(cl.getClientetelefono()));
            fromCliente.jTxtDire.setText(String.valueOf(cl.getClientedireccion()));
            fromCliente.jTxtNit.setText(String.valueOf(cl.getClientenit()));
            fromCliente.jBtnAgregarCliente.setEnabled(false);
        } else {
            fromCliente.jBtnAgregarCliente.setEnabled(true);
            JOptionPane.showMessageDialog(fromCliente, "Cliente no encontrado" + nl + "Se necesita agregarlo", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método para validar los datos correctos de los campos
     */
    public void validarCampos() {
        //Validar Campos
        ValidarCampos validar = new ValidarCampos();
        validar.ValidarSoloLetras(fromCliente.jTxtNombre);
        validar.ValidarSoloLetras(fromCliente.jTxtApellido);
        validar.ValidarSoloNumeros(fromCliente.jTxtTel, 8);
    }

    /**
     * Método para validar que todos los campos estén llenos
     */
    public void validarCamposLlenos() {
        fromCliente.jBtnOrdenarCliente.setEnabled(!fromCliente.jTxtNombre.getText().isEmpty()
                && !fromCliente.jTxtApellido.getText().isEmpty()
                && !fromCliente.jTxtTel.getText().isEmpty()
                && !fromCliente.jTxtDire.getText().isEmpty());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        validarCamposParaAgregar();
    }

    public void validarCamposParaAgregar() {
        fromCliente.jBtnAgregarCliente.setEnabled(!fromCliente.jTxtNombre.getText().isEmpty()
                && !fromCliente.jTxtApellido.getText().isEmpty()
                && !fromCliente.jTxtTel.getText().isEmpty()
                && !fromCliente.jTxtDire.getText().isEmpty()
                && !fromCliente.jTxtNit.getText().isEmpty());
        fromCliente.jBtnOrdenarCliente.setEnabled(!fromCliente.jTxtNombre.getText().isEmpty()
                && !fromCliente.jTxtApellido.getText().isEmpty()
                && !fromCliente.jTxtTel.getText().isEmpty()
                && !fromCliente.jTxtDire.getText().isEmpty()
                && !fromCliente.jTxtNit.getText().isEmpty());
    }
}
