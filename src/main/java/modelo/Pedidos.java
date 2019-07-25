
package modelo;

import java.sql.Date;


public class Pedidos {
    
    private byte pedido_id;
    private Date fecha;
    private Date hora;
    private int mesa_id;
    private byte estadopedido_id;
    private byte cliente_id;
    private int empleado_id;

    public Pedidos() {
    }

    public Pedidos(byte pedido_id, Date fecha, Date hora, int mesa_id, byte estadopedido_id, byte cliente_id, int empleado_id) {
        this.pedido_id = pedido_id;
        this.fecha = fecha;
        this.hora = hora;
        this.mesa_id = mesa_id;
        this.estadopedido_id = estadopedido_id;
        this.cliente_id = cliente_id;
        this.empleado_id = empleado_id;
    }

    public byte getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(byte pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(int mesa_id) {
        this.mesa_id = mesa_id;
    }

    public byte getEstadopedido_id() {
        return estadopedido_id;
    }

    public void setEstadopedido_id(byte estadopedido_id) {
        this.estadopedido_id = estadopedido_id;
    }

    public byte getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(byte cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }
    
    
    
    
}
