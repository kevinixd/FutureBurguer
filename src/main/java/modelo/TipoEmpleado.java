/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

<<<<<<< HEAD
public class TIpoEmpleado {
=======
/**
 *
 * @author javam2019
 */
public class TipoEmpleado{
>>>>>>> 666500d43986367b795edae0196d85bc8b8a9468
    
    private byte tipoEmpleadoId;
    private String tipoEmpleado;

    public TIpoEmpleado() {
    }

    public TIpoEmpleado(byte tipoEmpleadoId, String tipoEmpleado) {
        this.tipoEmpleadoId = tipoEmpleadoId;
        this.tipoEmpleado = tipoEmpleado;
    }

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
