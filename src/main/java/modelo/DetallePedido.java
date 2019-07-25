
package modelo;


public class DetallePedido {
    
    private byte detallepedido_id;
    private byte pedido_id;
    private byte tipo_combo_id;
    private int  producto_tamaño_id;
    private byte cantidad;
    private String descripcion;
    private float precio;

    public DetallePedido() {
    }

    public DetallePedido(byte detallepedido_id, byte pedido_id, byte tipo_combo_id, int producto_tamaño_id, byte cantidad, String descripcion, float precio) {
        this.detallepedido_id = detallepedido_id;
        this.pedido_id = pedido_id;
        this.tipo_combo_id = tipo_combo_id;
        this.producto_tamaño_id = producto_tamaño_id;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public byte getDetallepedido_id() {
        return detallepedido_id;
    }

    public void setDetallepedido_id(byte detallepedido_id) {
        this.detallepedido_id = detallepedido_id;
    }

    public byte getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(byte pedido_id) {
        this.pedido_id = pedido_id;
    }

    public byte getTipo_combo_id() {
        return tipo_combo_id;
    }

    public void setTipo_combo_id(byte tipo_combo_id) {
        this.tipo_combo_id = tipo_combo_id;
    }

    public int getProducto_tamaño_id() {
        return producto_tamaño_id;
    }

    public void setProducto_tamaño_id(int producto_tamaño_id) {
        this.producto_tamaño_id = producto_tamaño_id;
    }

    public byte getCantidad() {
        return cantidad;
    }

    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
 
    
    
    
    
    
    
}
