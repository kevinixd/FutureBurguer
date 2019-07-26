
package modelo;


public class TipoCombos {
    private byte tipo_combo_id;
    private String nombre;

    public TipoCombos() {
    }

    public TipoCombos(byte tipo_combo_id, String nombre) {
        this.tipo_combo_id = tipo_combo_id;
        this.nombre = nombre;
    }

    public byte getTipo_combo_id() {
        return tipo_combo_id;
    }

    public void setTipo_combo_id(byte tipo_combo_id) {
        this.tipo_combo_id = tipo_combo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
    
}
