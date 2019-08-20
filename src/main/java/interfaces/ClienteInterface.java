package interfaces;
/**
 * esta interfaz va agregar, eliminar , modificar y buscar a  clientes.
 * @author futureburguer
 */

import modelo.Cliente;

public interface ClienteInterface {
    public String agregarCliente(Cliente cliente);
    public String eliminarCliente(Cliente cliente);
    public String modificarCliente(Cliente cliente);
    public Cliente buscarCliente(int tel);
    
}
