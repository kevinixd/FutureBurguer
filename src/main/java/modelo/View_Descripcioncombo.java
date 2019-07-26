package modelo;

public class View_Descripcioncombo {

    private int detallescombosId;
    private int comboId;
    private String nombreCombo;
    private int productoTamanioId;
    private String productoCombo;
    private String tamanioCombo;
    private float precio;

    public View_Descripcioncombo(int detallescombosId, int comboId, String nombreCombo, int productoTamanioId, String productoCombo, String tamanioCombo, float precio) {
        this.detallescombosId = detallescombosId;
        this.comboId = comboId;
        this.nombreCombo = nombreCombo;
        this.productoTamanioId = productoTamanioId;
        this.productoCombo = productoCombo;
        this.tamanioCombo = tamanioCombo;
        this.precio = precio;
    }

    public View_Descripcioncombo() {
    }

    public int getDetallescombosId() {
        return detallescombosId;
    }

    public void setDetallescombosId(int detallescombosId) {
        this.detallescombosId = detallescombosId;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public int getProductoTamanioId() {
        return productoTamanioId;
    }

    public void setProductoTamanioId(int productoTamanioId) {
        this.productoTamanioId = productoTamanioId;
    }

    public String getProductoCombo() {
        return productoCombo;
    }

    public void setProductoCombo(String productoCombo) {
        this.productoCombo = productoCombo;
    }

    public String getTamanioCombo() {
        return tamanioCombo;
    }

    public void setTamanioCombo(String tamanioCombo) {
        this.tamanioCombo = tamanioCombo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
