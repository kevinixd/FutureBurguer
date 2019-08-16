package modelo;

public class View_Descripcioncombo {

    private int detallescombosId;
    private int comboId;
    private String descripcionCombo;
    private double descuento;
    private String nombreCombo;
    private String imagenDetalleCombo;
    private int productoTamanioId;
    private int productoComboId;
    private String productoCombo;
    private String tamanioCombo;
    private double precio;

    public View_Descripcioncombo(int detallescombosId, int comboId, String descripcionCombo, double descuento, String imagenDetalleCombo,
            String nombreCombo, int productoTamanioId, int productoComboId, String productoCombo, String tamanioCombo, float precio) {
        this.detallescombosId = detallescombosId;
        this.comboId = comboId;
        this.descripcionCombo = descripcionCombo;
        this.descuento = descuento;
        this.imagenDetalleCombo = imagenDetalleCombo;
        this.nombreCombo = nombreCombo;
        this.productoTamanioId = productoTamanioId;
        this.productoComboId = productoComboId;
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

    public String getDescripcionCombo() {
        return descripcionCombo;
    }

    public void setDescripcionCombo(String descripcionCombo) {
        this.descripcionCombo = descripcionCombo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getImagenDetalleCombo() {
        return imagenDetalleCombo;
    }

    public void setImagenDetalleCombo(String imagenDetalleCombo) {
        this.imagenDetalleCombo = imagenDetalleCombo;
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

    public int getProductoComboId() {
        return productoComboId;
    }

    public void setProductoComboId(int productoComboId) {
        this.productoComboId = productoComboId;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "View_Descripcioncombo{" + "detallescombosId=" + detallescombosId + ", comboId=" + comboId + ", nombreCombo=" + nombreCombo + ", imagenDetalleCombo=" + imagenDetalleCombo + ", productoTamanioId=" + productoTamanioId + ", productoComboId=" + productoComboId + ", productoCombo=" + productoCombo + ", tamanioCombo=" + tamanioCombo + ", precio=" + precio + '}';
    }

}
