/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.DetallePedido;
import modelo.View_Ordenes;
import vista.JintCarrito;
import vista.JintCliente;
import static controlador.ProductoSeleccionado.insertarPedido;
import static controlador.ProductoSeleccionado.verDetalle;
import javax.swing.JButton;

public class CarritoControlador implements ActionListener {

    //Frames a utlizar
    JintCarrito carrito = new JintCarrito();
    JintCliente cliente = new JintCliente();

    //Controladores a utlizar
    ClienteControlador controladorCliente;

    //Modelos a utilizar
    DetallePedido orden = new DetallePedido();

    //Tabla
    private String[] titulos = {"Cantidad", "Producto", "Tamaño", "Precio", "Editar", "Eliminar"};
    DefaultTableModel tablaCarrito = new DefaultTableModel(titulos, 0);

    private byte pedido_id = 10;
    private JButton eliminar;
    private JButton modificar;

    public CarritoControlador(JintCarrito carrito) {
        this.carrito = carrito;
        carrito.jBtnCancelar.addActionListener(this);
        carrito.jBtnOrdenar.addActionListener(this);
        eliminar= new JButton();
        modificar= new JButton();
        eliminar.setFont(new java.awt.Font("Dialog", 1, 30));
        eliminar.setText("Eliminar");
        modificar.setFont(new java.awt.Font("Dialog", 1, 30));
        modificar.setText("Modificar");
        carrito.jTlbCarrito.setRowMargin(12);
        verCarrito();
        dimensionesTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void verCarrito() {
        Object[] filas = new Object[6];
        for (View_Ordenes orden : verDetalle) {
            filas[0] = orden.getCantidadOrden();
            filas[1] = orden.getProductoOrden();
            filas[2] = orden.getTamanioOrden();
            filas[3] = "Q." + orden.getPrecioOrden();
            filas[4] = modificar;
            filas[5] = eliminar;
            tablaCarrito.addRow(filas);
        }
        carrito.jTlbCarrito.setModel(tablaCarrito);
    }
    
    public void dimensionesTabla(){
        carrito.jTlbCarrito.getColumnModel().getColumn(0).setMaxWidth(100);
        carrito.jTlbCarrito.getColumnModel().getColumn(1).setMaxWidth(360);
        carrito.jTlbCarrito.getColumnModel().getColumn(2).setMaxWidth(250);
        carrito.jTlbCarrito.getColumnModel().getColumn(3).setMaxWidth(200);
        carrito.jTlbCarrito.getColumnModel().getColumn(4).setMaxWidth(250);
        carrito.jTlbCarrito.getColumnModel().getColumn(5).setMaxWidth(250);
        
    }

}
