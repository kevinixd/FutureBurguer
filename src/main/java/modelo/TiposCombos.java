package modelo;
/*
 *esta clase es un reflejo de la tabla tipos combos de la base de datos
 * @author futureburguer
 */

public class TiposCombos {
    
    private byte tipoComboId;
    private String nombre;
    
    //constructores

    public TiposCombos() {
    }

    public TiposCombos(byte tipoComboId, String nombre) {
        this.tipoComboId = tipoComboId;
        this.nombre = nombre;
    }
    
    //getter y setter
    public byte getTipoComboId() {
        return tipoComboId;
    }

    public void setTipoComboId(byte tipoComboId) {
        this.tipoComboId = tipoComboId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
}
