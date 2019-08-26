
package modelo;
/**
 * esta clase es un reflejo de la tabla tamaños de la base de datos
 * @author futureburguer
 */

public class Tamanios {
    
    private byte tamanio_id;
    private String tamanionombre;
    private String tamaniodescripcion;
    
    
//constructores
    public Tamanios() {
    }

    public Tamanios(byte tamanio_id, String tamanionombre, String tamaniodescripcion) {
        this.tamanio_id = tamanio_id;
        this.tamanionombre = tamanionombre;
        this.tamaniodescripcion = tamaniodescripcion;
    }

    
    //getter y setter
    public byte getTamanio_id() {
        return tamanio_id;
    }

    public void setTamanio_id(byte tamanio_id) {
        this.tamanio_id = tamanio_id;
    }

    public String getTamanionombre() {
        return tamanionombre;
    }

    public void setTamanionombre(String tamanionombre) {
        this.tamanionombre = tamanionombre;
    }

    public String getTamaniodescripcion() {
        return tamaniodescripcion;
    }

    public void setTamaniodescripcion(String tamaniodescripcion) {
        this.tamaniodescripcion = tamaniodescripcion;
    }
    
    
    
}
