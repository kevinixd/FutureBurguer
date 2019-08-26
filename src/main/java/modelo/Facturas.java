
package modelo;

/**
 * esta clase es un reflejo de la tabla facturas de la base de datos
 * @author futureburguer
 */
import java.sql.Date;


public class Facturas {
    
    private byte nopedido;
    private int factura_id;
    private int serie;
    private byte nit;
    private String nombre;
    private float total;
    private Date fecha;
    
    
//constructores
    public Facturas() {
    }

    public Facturas(byte nopedido, int factura_id, int serie, byte nit, String nombre, float total, Date fecha) {
        this.nopedido = nopedido;
        this.factura_id = factura_id;
        this.serie = serie;
        this.nit = nit;
        this.nombre = nombre;
        this.total = total;
        this.fecha = fecha;
    }

    
    //getter y setter
    public byte getNopedido() {
        return nopedido;
    }

    public void setNopedido(byte nopedido) {
        this.nopedido = nopedido;
    }

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public byte getNit() {
        return nit;
    }

    public void setNit(byte nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
    
}
