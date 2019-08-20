package interfaces;
/**
 * esta interfaz va  mostrar los detalles de los combos. 
 * @author futureburguer
 */

import java.util.ArrayList;
import modelo.View_Descripcioncombo;

public interface View_DetalleComboInterface {

    public ArrayList<View_Descripcioncombo> verProductos(int productoId);
    
    public View_Descripcioncombo verImagenCombo(int productoId);
}
