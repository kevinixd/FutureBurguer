package controlador;

import dao.DaoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.JintCliente;

public class ClienteControlador implements ActionListener {

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
        asignarImagenes();
        validarCampos();
        fromCliente.jLblClienteID.setVisible(false);
        validarCamposLlenos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fromCliente.jBtnAgregarCliente) {
            guardarCliente();
        }

        if (e.getSource() == fromCliente.jBtnBuscar) {
            buscarCliente();
            validarCamposLlenos();
        }

        if (e.getSource() == fromCliente.jBtnModificar) {
            modificarCliente();
        }
    }

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
     * Método para borrar cajas de texto
     */
    public void borrarCajas() {
        fromCliente.jTxtNombre.setText("");
        fromCliente.jTxtApellido.setText("");
        fromCliente.jTxtTel.setText("");
        fromCliente.jTxtDire.setText("");
        fromCliente.jTxtNit.setText("");
    }

    /**
     * Método para modificar datos del cliente
     */
    public void modificarCliente() {
        int clienteID = Integer.parseInt(fromCliente.jLblClienteID.getText());
        asignarDatos();
        mensaje = dao.modificarCliente(clienteID);
        JOptionPane.showMessageDialog(fromCliente, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para asignar los datos de las cajas de texto a los valores del
     * modelo
     */
    public void asignarDatos() {
        cl.setClientenombre(fromCliente.jTxtNombre.getText());
        cl.setClienteapellido(fromCliente.jTxtApellido.getText());
        cl.setClientetelefono(Integer.parseInt(fromCliente.jTxtTel.getText()));
        cl.setClientedireccion(fromCliente.jTxtDire.getText());
        cl.setClientenit(fromCliente.jTxtNit.getText());
    }

    /**
     * Método para poder buscar un cliente por medio del numero de télefono
     */
    public void buscarCliente() {
        int tel = Integer.parseInt(fromCliente.jTxtTel.getText());
        cl = dao.buscarCliente(tel);

        if (cl.getClientenombre() == null) {
            JOptionPane.showMessageDialog(fromCliente, "Cliente no encontrado" + nl + "Se necesita agregarlo", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            fromCliente.jLblClienteID.setText(String.valueOf(cl.getClienteid()));
            fromCliente.jTxtNombre.setText(cl.getClientenombre());
            fromCliente.jTxtApellido.setText(cl.getClienteapellido());
            fromCliente.jTxtTel.setText(String.valueOf(cl.getClientetelefono()));
            fromCliente.jTxtDire.setText(cl.getClientedireccion());
            fromCliente.jTxtNit.setText(cl.getClientenit());
        }
    }

    public void validarCampos() {
        //Validar Campos
        ValidarCampos validar = new ValidarCampos();
        validar.ValidarSoloLetras(fromCliente.jTxtNombre);
        validar.ValidarSoloLetras(fromCliente.jTxtApellido);
        validar.ValidarSoloNumeros(fromCliente.jTxtTel);
    }

    public void validarCamposLlenos() {
        fromCliente.jBtnOrdenarCliente.setEnabled(!fromCliente.jTxtNombre.getText().isEmpty()
                && !fromCliente.jTxtApellido.getText().isEmpty()
                && !fromCliente.jTxtTel.getText().isEmpty()
                && !fromCliente.jTxtDire.getText().isEmpty());
    }

}
