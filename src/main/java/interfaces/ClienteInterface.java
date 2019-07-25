package interfaces;

import modelo.Cliente;

public interface ClienteInterface {
    public String agregarCliente(Cliente cliente);
    public String eliminarCliente(Cliente cliente);
    public String modificarCliente(Cliente cliente);
    public Cliente buscarCliente(int tel);
    
}
