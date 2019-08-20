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
    JintCliente fromCliente = new JintCliente();
    DaoCliente dao = new DaoCliente();
    Cliente cl = new Cliente();

    private String mensaje;
    private String ruta = System.getProperty("user.dir");

    public ClienteControlador(JintCliente fromCliente) {
        this.fromCliente = fromCliente;
        fromCliente.jBtnOrdenarCliente.addActionListener(this);
        fromCliente.jBtnBuscar.addActionListener(this);
        ImageIcon mod = new ImageIcon(ruta + "\\src\\main\\java\\img\\Modificar.png");
        ImageIcon add = new ImageIcon(ruta + "\\src\\main\\java\\img\\Agregar.png");
        ImageIcon modRed = new ImageIcon(mod.getImage().getScaledInstance(100, -1, java.awt.Image.SCALE_DEFAULT));
        ImageIcon addRed = new ImageIcon(add.getImage().getScaledInstance(100, -1, java.awt.Image.SCALE_DEFAULT));
        fromCliente.jBtnOrdenarCliente.setIcon(addRed);
        fromCliente.jBtnModificar.setIcon(modRed);
        validarCampos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fromCliente.jBtnOrdenarCliente) {
            guardarCliente();
        }

        if (e.getSource() == fromCliente.jBtnBuscar) {
            buscarCliente();
        }
    }

    public void guardarCliente() {
        cl.setClientenombre(fromCliente.jTxtNombre.getText());
        cl.setClienteapellido(fromCliente.jTxtApellido.getText());
        cl.setClientetelefono(Integer.parseInt(fromCliente.jTxtTel.getText()));
        cl.setClientedireccion(fromCliente.jTxtDire.getText());
        cl.setClientenit(fromCliente.jTxtNit.getText());
        mensaje = dao.agregarCliente(cl);
        JOptionPane.showMessageDialog(fromCliente, mensaje);
        fromCliente.jTxtNombre.setText("");
        fromCliente.jTxtApellido.setText("");
        fromCliente.jTxtTel.setText("");
        fromCliente.jTxtDire.setText("");
        fromCliente.jTxtNit.setText("");
    }

    public void buscarCliente() {
        int tel = Integer.parseInt(fromCliente.jTxtTel.getText());
        cl = dao.buscarCliente(tel);
        fromCliente.jTxtNombre.setText(cl.getClientenombre());
        fromCliente.jTxtApellido.setText(cl.getClienteapellido());
        fromCliente.jTxtTel.setText(String.valueOf(cl.getClientetelefono()));
        fromCliente.jTxtDire.setText(cl.getClientedireccion());
        fromCliente.jTxtNit.setText(cl.getClientenit());
    }

    public void validarCampos() {
        //Validar Campos
        ValidarCampos validar = new ValidarCampos();
        validar.ValidarSoloLetras(fromCliente.jTxtNombre);
        validar.ValidarSoloLetras(fromCliente.jTxtApellido);
        validar.ValidarSoloNumeros(fromCliente.jTxtTel);
    }

}
