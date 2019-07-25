
package modelo;


public class Productos {
    
    private int produco_id;
    private String productonombre;
    private String productodescripcion;
    private int clasificacion_id;

    public Productos() {
    }

    public Productos(int produco_id, String productonombre, String productodescripcion, int clasificacion_id) {
        this.produco_id = produco_id;
        this.productonombre = productonombre;
        this.productodescripcion = productodescripcion;
        this.clasificacion_id = clasificacion_id;
    }

    public int getProduco_id() {
        return produco_id;
    }

    public void setProduco_id(int produco_id) {
        this.produco_id = produco_id;
    }

    public String getProductonombre() {
        return productonombre;
    }

    public void setProductonombre(String productonombre) {
        this.productonombre = productonombre;
    }

    public String getProductodescripcion() {
        return productodescripcion;
    }

    public void setProductodescripcion(String productodescripcion) {
        this.productodescripcion = productodescripcion;
    }

    public int getClasificacion_id() {
        return clasificacion_id;
    }

    public void setClasificacion_id(int clasificacion_id) {
        this.clasificacion_id = clasificacion_id;
    }
    
    
    
    
    
}
