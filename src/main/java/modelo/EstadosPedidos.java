
package modelo;
/*
 * esta clase es un reflejo de la tabla estadospedidos de la base de datos
 * @author futureburguer
 */

public class EstadosPedidos {

    private byte estadopedido_id;
    private String estadopedidonombre;
    
    
    //constructores
    public EstadosPedidos() {
    }

    public EstadosPedidos(byte estadopedido_id, String estadopedidonombre) {
        this.estadopedido_id = estadopedido_id;
        this.estadopedidonombre = estadopedidonombre;
    }

    //getter y setter
    public byte getEstadopedido_id() {
        return estadopedido_id;
    }

    public void setEstadopedido_id(byte estadopedido_id) {
        this.estadopedido_id = estadopedido_id;
    }

    public String getEstadopedidonombre() {
        return estadopedidonombre;
    }

    public void setEstadopedidonombre(String estadopedidonombre) {
        this.estadopedidonombre = estadopedidonombre;
    }
    
    
    
    
}
