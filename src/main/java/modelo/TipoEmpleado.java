/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author javam2019
 */
public class TipoEmpleado{
    
    private byte tipoEmpleadoId;
    private String tipoEmpleado;

    public TipoEmpleado() {
    }

    public TipoEmpleado(byte tipoEmpleadoId, String tipoEmpleado) {
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