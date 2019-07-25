
package modelo;


public class DetallesCombos {
    
    private int detallescombos_id;
    private int combodetalle_id;
    private int producto_tamaño_id;

    public DetallesCombos() {
        
    }

    public DetallesCombos(int detallescombos_id, int combodetalle_id, int producto_tamaño_id) {
        this.detallescombos_id = detallescombos_id;
        this.combodetalle_id = combodetalle_id;
        this.producto_tamaño_id = producto_tamaño_id;
    }

    public int getDetallescombos_id() {
        return detallescombos_id;
    }

    public void setDetallescombos_id(int detallescombos_id) {
        this.detallescombos_id = detallescombos_id;
    }

    public int getCombodetalle_id() {
        return combodetalle_id;
    }

    public void setCombodetalle_id(int combodetalle_id) {
        this.combodetalle_id = combodetalle_id;
    }

    public int getProducto_tamaño_id() {
        return producto_tamaño_id;
    }

    public void setProducto_tamaño_id(int producto_tamaño_id) {
        this.producto_tamaño_id = producto_tamaño_id;
    }
    
    

    
    
    
    
    
}
