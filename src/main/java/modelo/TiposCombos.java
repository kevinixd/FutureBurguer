package modelo;

public class TiposCombos {
    
    private byte tipoComboId;
    private String nombre;

    public TiposCombos() {
    }

    public TiposCombos(byte tipoComboId, String nombre) {
        this.tipoComboId = tipoComboId;
        this.nombre = nombre;
    }

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
