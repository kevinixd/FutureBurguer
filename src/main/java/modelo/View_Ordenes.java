/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class View_Ordenes {
    
    private int numero_orden;
    private byte mesaOrden;
    private String tipoComboOrden;
    private String productoOrden;
    private String tamanioOrden;
    private int cantidadOrden;
    private String descripcionOrden;
    private float precioOrden;

    public View_Ordenes() {
    }

    public View_Ordenes(int numero_orden, byte mesaOrden, String tipoComboOrden, String productoOrden, String tamanioOrden, int cantidadOrden, String descripcionOrden, float precioOrden) {
        this.numero_orden = numero_orden;
        this.mesaOrden = mesaOrden;
        this.tipoComboOrden = tipoComboOrden;
        this.productoOrden = productoOrden;
        this.tamanioOrden = tamanioOrden;
        this.cantidadOrden = cantidadOrden;
        this.descripcionOrden = descripcionOrden;
        this.precioOrden = precioOrden;
    }

    public int getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(int numero_orden) {
        this.numero_orden = numero_orden;
    }

    public byte getMesaOrden() {
        return mesaOrden;
    }

    public void setMesaOrden(byte mesaOrden) {
        this.mesaOrden = mesaOrden;
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
