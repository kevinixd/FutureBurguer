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
    
}
