
package interfaces;
/**
 * esta intefaz mostrara los productos.
 * esta intefaz mostrara las bebidas.
 * esta  interfaz mostrara las bebidas desayunos.
 * 
 * @author futureburguer
 */

import java.util.ArrayList;
import modelo.Productos;

public interface ProductosInterface {
    
    public ArrayList<Productos> verProductos(int id);

    public ArrayList<Productos> verBebidas();
    
    public ArrayList<Productos> verBebidasDesayuno();
}
