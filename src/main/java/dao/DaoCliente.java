package dao;

import interfaces.ClienteInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 * Clase para administrar clientes contiene los procesos de CRUD
 *
 * @author FutureBurguer
 */
public class DaoCliente implements ClienteInterface {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private String mensaje;
    private String sql = null;
    
    Cliente cliente= new Cliente();

    /**
     * Metodo para agregar cliente a la base de datos
     *
     * @param cliente objeto de cliente, datos proporcionados por usario
     * @return mensaje "datos ingresados" cuando la insersion tiene exito, al
     * existir error retorna un texto con el error retorna un texto con el error
     * dado
     * @return mensaje "datos ingresados" cuando la insersion tiene exito, al existir error retorna un texto con el error
     * retorna un texto con el error dado.
     * 
     * @author FutureBurguer
     */
    @Override
    public String agregarCliente(Cliente cliente) {
        con.abrirConexion();
        sql = "insert into clientes(nit,nombre,apellido,telefono,direccion) values(?,?,?,?,?)";
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setString(1, cliente.getClientenit());
            ps.setString(2, cliente.getClientenombre());
            ps.setString(3, cliente.getClienteapellido());
            ps.setInt(4, cliente.getClientetelefono());
            ps.setString(5, cliente.getClientedireccion());
            ps.executeUpdate();
            mensaje = "¡Cliente agregado!";
        } catch (Exception e) {
            System.out.println("Error en daoAgregarCliente");
        } finally {
            con.cerrarConexion();
        }
        return mensaje;
    }

    /**
     * Elimina de la base de datos clientes
     *
     * @param cliente datos del objeto definidos por el usuario
     * @return un mensaje indicando si se elimino el registro o si no se puede
     * eliminar con el mensaje de error
     */
    @Override
    public String eliminarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param cliente datos del objeto definidos por el usuario
     * @return un mensaje indicando que se modificaron los datos del cliente
     */
    @Override
    public String modificarCliente(int clienteID) {
        con.abrirConexion();
        sql = "update clientes set nit=?, nombre=?, apellido=?, telefono=?, direccion=? where cliente_id=?";
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setString(1, cliente.getClientenit());
            ps.setString(2, cliente.getClientenombre());
            ps.setString(3, cliente.getClienteapellido());
            ps.setInt(4, cliente.getClientetelefono());
            ps.setString(5, cliente.getClientedireccion());
            ps.setInt(6, cliente.getClienteid());
            mensaje = "¡Cliente Modificado con Exito!";
        } catch (SQLException ex) {
            System.out.println("Error en dao Modificar Cliente " + ex);
        } finally {
            con.cerrarConexion();
        }
        return mensaje;
    }

    /**
     * Busca el cliente en la base de datos si es que existe
     *
     * @param tel datos del objeto definidos por el usuario
     * @return objeto de tipo cliente para visualizar los datos buscados de un
     * cliente en especifico
     */
    @Override
    public Cliente buscarCliente(int tel) {
        Cliente cl = new Cliente();
        con.abrirConexion();
        sql = "select * from clientes where telefono=?";
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setInt(1, tel);
            rs = ps.executeQuery();
            rs.next();
            cl.setClienteid(rs.getInt("cliente_id"));
            cl.setClientetelefono(rs.getInt("telefono"));
            cl.setClientenombre(rs.getString("nombre"));
            cl.setClienteapellido(rs.getString("apellido"));
            cl.setClientenit(rs.getString("nit"));
            cl.setClientedireccion(rs.getString("direccion"));
            rs.close();

        } catch (Exception e) {
        } finally {
            con.cerrarConexion();
        }

        return cl;
    }

}
