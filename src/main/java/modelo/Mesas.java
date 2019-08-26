
package modelo;
/**
 * esta clase es un reflejo de la tabla mesas de la base de datos
 * @author futureburguer
 */

public class Mesas {
    
    private int mesa_id;
    private byte numero_mesa;
    
    
    //constructores
    public Mesas() {
    }

    public Mesas(int mesa_id, byte numero_mesa) {
        this.mesa_id = mesa_id;
        this.numero_mesa = numero_mesa;
    }

    //getter y setter
    public int getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(int mesa_id) {
        this.mesa_id = mesa_id;
    }

    public byte getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(byte numero_mesa) {
        this.numero_mesa = numero_mesa;
    }
    
    
    
    
    
    
}
