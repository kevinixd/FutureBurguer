
package modelo;


public class EstadosPedidos {

    private byte estadopedido_id;
    private String estadopedidonombre;

    public EstadosPedidos() {
    }

    public EstadosPedidos(byte estadopedido_id, String estadopedidonombre) {
        this.estadopedido_id = estadopedido_id;
        this.estadopedidonombre = estadopedidonombre;
    }

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
