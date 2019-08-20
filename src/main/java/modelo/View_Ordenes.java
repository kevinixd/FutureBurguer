
package modelo;
/**
 *esta clase es un reflejo de la tabla ordenes de la base de datos
 *@author futureburguer
 */

public class View_Ordenes {
    
    private int numero_orden;
    private String direccion;
    private String tipoComboOrden;
    private String productoOrden;
    private String tamanioOrden;
    private int cantidadOrden;
    private String descripcionOrden;
    private float precioOrden;

    //constructores
    
    public View_Ordenes() {
    }

    public View_Ordenes(int numero_orden, String direccion, String tipoComboOrden, String productoOrden, String tamanioOrden, int cantidadOrden, String descripcionOrden, float precioOrden) {
        this.numero_orden = numero_orden;
        this.direccion= direccion;
        this.tipoComboOrden = tipoComboOrden;
        this.productoOrden = productoOrden;
        this.tamanioOrden = tamanioOrden;
        this.cantidadOrden = cantidadOrden;
        this.descripcionOrden = descripcionOrden;
        this.precioOrden = precioOrden;
    }

    //getter y setter
    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public String getMesaOrden() {
        return direccion;
    }

    public void setMesaOrden(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoComboOrden() {
        return tipoComboOrden;
    }

    public void setTipoComboOrden(String tipoComboOrden) {
        this.tipoComboOrden = tipoComboOrden;
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

    public String getDescripcionOrden() {
        return descripcionOrden;
    }

    public void setDescripcionOrden(String descripcionOrden) {
        this.descripcionOrden = descripcionOrden;
    }

    public float getPrecioOrden() {
        return precioOrden;
    }

    public void setPrecioOrden(float precioOrden) {
        this.precioOrden = precioOrden;
    }
    
    
}
