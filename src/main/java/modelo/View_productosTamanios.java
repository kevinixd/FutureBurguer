/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class View_productosTamanios {

    private short ptIdView;
    private int productoIdView;
    private String productoView;
    private String productoImgView;
    private String productoDescpView;
    private String tamanioView;
    private double precioView;

    public View_productosTamanios() {
    }

    public View_productosTamanios(short ptIdView, int productoIdView, String productoView, String productoImgView, String productoDescpView, String tamanioView, double precioView) {
        this.ptIdView = ptIdView;
        this.productoIdView = productoIdView;
        this.productoView = productoView;
        this.productoImgView = productoImgView;
        this.productoDescpView= productoDescpView;
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

    public String getProductoImgView() {
        return productoImgView;
    }

    public void setProductoImgView(String productoImgView) {
        this.productoImgView = productoImgView;
    }

    public int getProductoIdView() {
        return productoIdView;
    }

    public void setProductoIdView(int productoIdView) {
        this.productoIdView = productoIdView;
    }

    public String getProductoDescpView() {
        return productoDescpView;
    }

    public void setProductoDescpView(String productoDescpView) {
        this.productoDescpView = productoDescpView;
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
