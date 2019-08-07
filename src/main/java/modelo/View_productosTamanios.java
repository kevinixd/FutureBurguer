/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class View_productosTamanios {

    private short ptIdView;
    private String productoView;
    private int productoIdView;
    private String tamanioView;
    private double precioView;

    public View_productosTamanios() {
    }

    public View_productosTamanios(short ptIdView, String productoView, int productoIdView, String tamanioView, double precioView) {
        this.ptIdView = ptIdView;
        this.productoView = productoView;
        this.productoIdView = productoIdView;
        this.tamanioView = tamanioView;
        this.precioView = precioView;
    }

    public short getPtIdView() {
        return ptIdView;
    }

    public void setPtIdView(short ptIdView) {
        this.ptIdView = ptIdView;
    }

    public String getProductoView() {
        return productoView;
    }

    public void setProductoView(String productoView) {
        this.productoView = productoView;
    }

    public int getProductoIdView() {
        return productoIdView;
    }

    public void setProductoIdView(int productoIdView) {
        this.productoIdView = productoIdView;
    }

    public String getTamanioView() {
        return tamanioView;
    }

    public void setTamanioView(String tamanioView) {
        this.tamanioView = tamanioView;
    }

    public double getPrecioView() {
        return precioView;
    }

    public void setPrecioView(double precioView) {
        this.precioView = precioView;
    }

}
