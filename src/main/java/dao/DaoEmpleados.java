package dao;

import interfaces.EmpleadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Empleados;

/**
 * Clase para obtener datos del empleado para el login
 * @author FutureBurguer
 */
public class DaoEmpleados implements EmpleadosInterface {
    
    Conexion cn = new Conexion();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    private String sql = null;
    
    /**
     * 
     * @param empleado datos del objeto definidos por el usuario
     * @return Objeto de tipo empleado para obtener los datos de un empleado en especifico 
     */
    @Override
    public Empleados confirmarUsuario(Empleados empleado) {
        Empleados emp = new Empleados();
        try {            
            cn.abrirConexion();
            sql = "select * from empleados where correo=? and contrasenia=MD5(?)";
            ejecutar = cn.getCon().prepareStatement(sql);
            ejecutar.setString(1, empleado.getEmpleadocorreo());
            ejecutar.setString(2, empleado.getContraseña());
            resultado = ejecutar.executeQuery();
            resultado.next();
            emp = new Empleados();
            emp.setEmpleadocorreo(resultado.getString("correo"));
            emp.setEmpleadonombre(resultado.getString("nombre"));
            emp.setContraseña(resultado.getString("contrasenia"));
            emp.setTipoempleado_id(resultado.getByte("tipoempleado_id"));
            resultado.close();
        } catch (Exception e) {
            System.out.println("Error al leer datos: " + e);
            emp.setEmpleadocorreo(null);
        } finally {
            cn.cerrarConexion();
        }
        return emp;
    }
    
}
