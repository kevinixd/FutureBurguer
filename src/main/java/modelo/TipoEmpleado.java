
package modelo;

/* 
 *esta clase es un reflejo de la tabla tipo empleado de la base de datos
 * @author futureburguer
 */
public class TipoEmpleado{
    
    private byte tipoEmpleadoId;
    private String tipoEmpleado;
    
    //construtores

    public TipoEmpleado() {
    }

    public TipoEmpleado(byte tipoEmpleadoId, String tipoEmpleado) {
        this.tipoEmpleadoId = tipoEmpleadoId;
        this.tipoEmpleado = tipoEmpleado;
    }
    
    //getter y setter
    public byte getTipoEmpleadoId() {
        return tipoEmpleadoId;
    }

    public void setTipoEmpleadoId(byte tipoEmpleadoId) {
        this.tipoEmpleadoId = tipoEmpleadoId;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
    
}
