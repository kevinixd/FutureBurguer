package dao;

import interfaces.EmpleadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Empleados;

public class DaoEmpleados implements EmpleadosInterface {
    
    Conexion cn = new Conexion();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    private String sql = null;
    
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
