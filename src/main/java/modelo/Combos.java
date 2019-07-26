
package modelo;


public class Combos {
    
    private int combo_id;
    private String combonombre;
    private double combodescuento;
    private byte tipo_combo_id;

    public Combos() {
    }

    public Combos(int combo_id, String combonombre, byte combodescuento, byte tipo_combo_id) {
        this.combo_id = combo_id;
        this.combonombre = combonombre;
        this.combodescuento = combodescuento;
        this.tipo_combo_id = tipo_combo_id;
    }

    public int getCombo_id() {
        return combo_id;
    }

    public void setCombo_id(int combo_id) {
        this.combo_id = combo_id;
    }

    public String getCombonombre() {
        return combonombre;
    }

    public void setCombonombre(String combonombre) {
        this.combonombre = combonombre;
    }

    public double getCombodescuento() {
        return combodescuento;
    }

    public void setCombodescuento(double combodescuento) {
        this.combodescuento = combodescuento;
    }

    public byte getTipo_combo_id() {
        return tipo_combo_id;
    }

    public void setTipo_combo_id(byte tipo_combo_id) {
        this.tipo_combo_id = tipo_combo_id;
    }
    
    
    
    
}
