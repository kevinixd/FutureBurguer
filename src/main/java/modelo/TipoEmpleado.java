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
    
    private byte tipoempleado_id;
    private String tipo_empleado;

    public TipoEmpleado() {
        
    }

    public TipoEmpleado(byte tipoempleado_id, String tipo_empleado) {
        this.tipoempleado_id = tipoempleado_id;
        this.tipo_empleado = tipo_empleado;
    }

    public byte getTipoempleado_id() {
        return tipoempleado_id;
    }

    public void setTipoempleado_id(byte tipoempleado_id) {
        this.tipoempleado_id = tipoempleado_id;
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }
    
    

    
    
    
}
