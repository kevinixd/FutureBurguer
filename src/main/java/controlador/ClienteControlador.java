package controlador;

import dao.DaoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.JfrmCliente;

public class ClienteControlador implements ActionListener {

    JfrmCliente fromCliente;
    DaoCliente dao = new DaoCliente();
    Cliente cl = new Cliente();
    String mensaje;
    
    public ClienteControlador(JfrmCliente fromCliente){
        this.fromCliente=fromCliente;
        fromCliente.jBtnAgregar.addActionListener(this);
        fromCliente.jBtnBuscar.addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fromCliente.jBtnAgregar) {
             guardarCliente();
        }
        
        if (e.getSource()==fromCliente.jBtnBuscar) {
            buscarCliente();
        }
    }
    
    
    public void guardarCliente(){
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
    
    public void buscarCliente(){
        int tel = Integer.parseInt(fromCliente.jTxtTel.getText());
        cl = dao.buscarCliente(tel);
        fromCliente.jTxtNombre.setText(cl.getClientenombre());
        fromCliente.jTxtApellido.setText(cl.getClienteapellido());
        fromCliente.jTxtTel.setText(String.valueOf(cl.getClientetelefono()));
        fromCliente.jTxtDire.setText(cl.getClientedireccion());
        fromCliente.jTxtNit.setText(cl.getClientenit());
    }
    
}
