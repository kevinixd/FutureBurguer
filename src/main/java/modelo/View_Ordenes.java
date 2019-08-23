
package modelo;
/**
 *esta clase es un reflejo de la tabla ordenes de la base de datos
 *@author futureburguer
 */

public class View_Ordenes {
    
    private int detalle_pedidoOrden;
    private int numero_orden;
    private String direccion;
    private int productoTamanioIdOrden;
    private String productoOrden;
    private String tamanioOrden;
    private int cantidadOrden;
    private float precioOrden;

    //constructores
    
    public View_Ordenes() {
    }

    public View_Ordenes(int detalle_pedidoOrden,int numero_orden, String direccion, int productoTamanioIdOrden, String tipoComboOrden, String productoOrden, String tamanioOrden, int cantidadOrden, String descripcionOrden, float precioOrden) {
        this.detalle_pedidoOrden= detalle_pedidoOrden;
        this.numero_orden = numero_orden;
        this.direccion= direccion;
        this.productoTamanioIdOrden= productoTamanioIdOrden;
        this.productoOrden = productoOrden;
        this.tamanioOrden = tamanioOrden;
        this.cantidadOrden = cantidadOrden;
        this.precioOrden = precioOrden;
    }

    //getter y setter

    public int getDetalle_pedidoOrden() {
        return detalle_pedidoOrden;
    }

    public void setDetalle_pedidoOrden(int detalle_pedidoOrden) {
        this.detalle_pedidoOrden = detalle_pedidoOrden;
    }
        
    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getProductoTamanioIdOrden() {
        return productoTamanioIdOrden;
    }

    public void setProductoTamanioIdOrden(int productoTamanioIdOrden) {
        this.productoTamanioIdOrden = productoTamanioIdOrden;
    }
    

    public String getProductoOrden() {
        return productoOrden;
    }

    public void setProductoOrden(String productoOrden) {
        this.productoOrden = productoOrden;
    }

    public String getTamanioOrden() {
        return tamanioOrden;
    }

    public void setTamanioOrden(String tamanioOrden) {
        this.tamanioOrden = tamanioOrden;
    }

    public int getCantidadOrden() {
        return cantidadOrden;
    }

    public void setCantidadOrden(int cantidadOrden) {
        this.cantidadOrden = cantidadOrden;
    }

    public float getPrecioOrden() {
        return precioOrden;
    }

    public void setPrecioOrden(float precioOrden) {
        this.precioOrden = precioOrden;
    }
    
    
}
