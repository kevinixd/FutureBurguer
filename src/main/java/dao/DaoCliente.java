package dao;

import interfaces.ClienteInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cliente;

public class DaoCliente implements ClienteInterface {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private String mensaje;
    private String sql=null;
    
    @Override
    public String agregarCliente(Cliente cliente) {
        con.abrirConexion();
        sql="insert into clientes(nit,nombre,apellido,telefono,direccion) values(?,?,?,?,?)";
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
            mensaje =("Error en Agregar Cliente " + e);
        }finally{
            con.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String eliminarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        }finally{
            con.cerrarConexion();
        }
        
        return cl;
    }
    
}
