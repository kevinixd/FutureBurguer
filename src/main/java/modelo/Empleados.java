
package modelo;

/**
 *esta clase es un reflejo de la tabla empleados de la base de datos
 * @author fututeburguer
 */
public class Empleados {
    private int empleado_id;
    private String empleadonombre;
    private String empleadoapellido;
    private int empleadotelefono;
    private String empleadodireccion;
    private String empleadocorreo;
    private String contraseña;
    private byte tipoempleado_id;
    
    
    //constructores

    public Empleados() {
    }

    public Empleados(int empleado_id, String empleadonombre, String empleadoapellido, int empleadotelefono, String empleadodireccion, String empleadocorreo, String contraseña, byte tipoempleado_id) {
        this.empleado_id = empleado_id;
        this.empleadonombre = empleadonombre;
        this.empleadoapellido = empleadoapellido;
        this.empleadotelefono = empleadotelefono;
        this.empleadodireccion = empleadodireccion;
        this.empleadocorreo = empleadocorreo;
        this.contraseña = contraseña;
        this.tipoempleado_id = tipoempleado_id;
    }

    
    //getter y setter
    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public String getEmpleadonombre() {
        return empleadonombre;
    }

    public void setEmpleadonombre(String empleadonombre) {
        this.empleadonombre = empleadonombre;
    }

    public String getEmpleadoapellido() {
        return empleadoapellido;
    }

    public void setEmpleadoapellido(String empleadoapellido) {
        this.empleadoapellido = empleadoapellido;
    }

    public int getEmpleadotelefono() {
        return empleadotelefono;
    }

    public void setEmpleadotelefono(int empleadotelefono) {
        this.empleadotelefono = empleadotelefono;
    }

    public String getEmpleadodireccion() {
        return empleadodireccion;
    }

    public void setEmpleadodireccion(String empleadodireccion) {
        this.empleadodireccion = empleadodireccion;
    }

    public String getEmpleadocorreo() {
        return empleadocorreo;
    }

    public void setEmpleadocorreo(String empleadocorreo) {
        this.empleadocorreo = empleadocorreo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public byte getTipoempleado_id() {
        return tipoempleado_id;
    }

    public void setTipoempleado_id(byte tipoempleado_id) {
        this.tipoempleado_id = tipoempleado_id;
    }
    
    
    
    
}
