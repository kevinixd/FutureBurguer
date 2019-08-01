package modelo;

public class Productos {

    private int producto_id;
    private String productonombre;
    private String productodescripcion;
    private int clasificacion_id;
    private String imagen;

    public Productos() {
    }

    public Productos(int producto_id, String productonombre, String productodescripcion, int clasificacion_id, String imagen) {
        this.producto_id = producto_id;
        this.productonombre = productonombre;
        this.productodescripcion = productodescripcion;
        this.clasificacion_id = clasificacion_id;
        this.imagen = imagen;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int produco_id) {
        this.producto_id = produco_id;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    

}
