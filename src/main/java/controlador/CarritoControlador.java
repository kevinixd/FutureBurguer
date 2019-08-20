/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.agregarCarrito;
import modelo.DetallePedido;
import vista.JintCarrito;
import vista.JintCliente;

public class CarritoControlador {

    //Frames a utlizar
    JintCarrito carrito = new JintCarrito();
    JintCliente cliente = new JintCliente();

    //Controladores a utlizar
    ClienteControlador controladorCliente;

    //Modelos a utilizar
    DetallePedido orden = new DetallePedido();

    private byte pedido_id=1;

    public CarritoControlador(JintCarrito carrito) {
        this.carrito = carrito;
    }

    public void agregarDetallePedido() {
        pedido_id++;
        for (int i = 0; i < agregarCarrito.size() - 1; i++) {
            orden.setPedido_id(pedido_id);
            orden.setProducto_tamaño_id(agregarCarrito.get(i).getProducto_tamaño_id());
            orden.setCantidad(agregarCarrito.get(i).getCantidad());
            orden.setPrecio(agregarCarrito.get(i).getPrecio());            
        }
        
    }

}
