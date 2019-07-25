package modelo;

public class Cliente {
    String nombre;
    String apellido;
    int tel;
    String dire;
    String nit;

    public Cliente(String nombre, String apellido, int tel, String dire, String nit) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tel = tel;
        this.dire = dire;
        this.nit = nit;
    }

    public Cliente() {
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    
}


