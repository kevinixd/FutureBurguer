package dao;

import interfaces.ClienteInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cliente;
/**
 * Clase para administrar clientes contiene los procesos de CRUD
 * @author FutureBurguer
 */
public class DaoCliente implements ClienteInterface {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private String mensaje;
    private String sql = null;

    /**
     * Metodo para agregar cliente a la base de datos
     *
     * @param cliente objeto de cliente, datos proporcionados por usario
     * @return mensaje "datos ingresados" cuando la insersion tiene exito, al existir error retorna un texto con el error
     * retorna un texto con el error dado
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
            mensaje = "Datos Ingresados";

        } catch (Exception e) {
            mensaje = ("Error en Agregar Cliente " + e);
        } finally {
            con.cerrarConexion();
        }
        return mensaje;
    }

    /**
     *Elimina de la base de datos clientes
     * @param cliente datos del objeto definidos por el usuario
     * @return un mensaje indicando si se elimino el registro o si no se puede eliminar con el mensaje de error
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
    public String modificarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Busca el cliente en la base de datos si es que existe
     * @param tel datos del objeto definidos por el usuario
     * @return objeto de tipo cliente para visualizar los datos buscados de un cliente en especifico  
     */

    @Override
    public Cliente buscarCliente(int tel) {
        Cliente cl = new Cliente();
        sql = "select * from clientes where telefono=?";
        con.abrirConexion();
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setInt(1, tel);
            rs = ps.executeQuery();
            rs.next();
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
