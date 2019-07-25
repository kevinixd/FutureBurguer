package modelo;

public class Clasificaciones {

    private short clasificacion_id;

    private String nombreClafisicacion;
    
    //constructores

    public Clasificaciones(short clasificacion_id, String nombreClafisicacion) {
        this.clasificacion_id = clasificacion_id;
        this.nombreClafisicacion = nombreClafisicacion;
    }

    public Clasificaciones() {
    }
    
    
    
    //getter  y setter

    public short getClasificacion_id() {
        return clasificacion_id;
    }

    public void setClasificacion_id(short clasificacion_id) {
        this.clasificacion_id = clasificacion_id;
    }

    public String getNombreClafisicacion() {
        return nombreClafisicacion;
    }

    public void setNombreClafisicacion(String nombreClafisicacion) {
        this.nombreClafisicacion = nombreClafisicacion;
    }

    

   

}
