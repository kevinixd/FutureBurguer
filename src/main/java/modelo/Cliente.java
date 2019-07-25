
package modelo;


public class Cliente {
    
    private int clienteid;
   private int  clientenit;
   private String clientenombre;
   private String clienteapellido;
   private int clientetelefono;
   private String clientedireccion;

    public Cliente() {
    }

    public Cliente(int clienteid, int clientenit, String clientenombre, String clienteapellido, int clientetelefono, String clientedireccion) {
        this.clienteid = clienteid;
        this.clientenit = clientenit;
        this.clientenombre = clientenombre;
        this.clienteapellido = clienteapellido;
        this.clientetelefono = clientetelefono;
        this.clientedireccion = clientedireccion;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getClientenit() {
        return clientenit;
    }

    public void setClientenit(int clientenit) {
        this.clientenit = clientenit;
    }

    public String getClientenombre() {
        return clientenombre;
    }

    public void setClientenombre(String clientenombre) {
        this.clientenombre = clientenombre;
    }

    public String getClienteapellido() {
        return clienteapellido;
    }

    public void setClienteapellido(String clienteapellido) {
        this.clienteapellido = clienteapellido;
    }

    public int getClientetelefono() {
        return clientetelefono;
    }

    public void setClientetelefono(int clientetelefono) {
        this.clientetelefono = clientetelefono;
    }

    public String getClientedireccion() {
        return clientedireccion;
    }

    public void setClientedireccion(String clientedireccion) {
        this.clientedireccion = clientedireccion;
    }

    

   
}
