package modelo;

/**
 * esta clase es un reflejo de la tabla detalle pedido de la base de datos
 * @author futurebuguer
 */

public class DetallePedido {

    private byte detallepedido_id;
    private byte pedido_id;
    private int producto_tamanio_id;
    private byte cantidad;
    private float precio;

    //constructores
    public DetallePedido() {
    }

    public DetallePedido(byte detallepedido_id, byte pedido_id, int producto_tamaño_id, byte cantidad, float precio) {
        this.detallepedido_id = detallepedido_id;
        this.pedido_id = pedido_id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //getter y setter
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

    public int getProducto_tamaño_id() {
        return producto_tamanio_id;
    }

    public void setProducto_tamaño_id(int producto_tamanio_id) {
        this.producto_tamanio_id = producto_tamanio_id;
    }

    public byte getCantidad() {
        return cantidad;
    }

    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
