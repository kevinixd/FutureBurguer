/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 * Esta clase almacenara todos los productos seleccionado de la orden que se
 * efectue.
 *
 * @author futureBurguer
 */
import static controlador.PrincipalControlador.principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.DetallePedido;
import modelo.View_Ordenes;
import vista.JintCarrito;
import vista.JintCliente;
import static controlador.VariablesEstaticas.verDetalle;
import static controlador.VariablesEstaticas.cantidad;
import dao.agregar;
import java.awt.Color;
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
    private String[] titulos = {"Cantidad", "Producto ID", "Producto", "Tamaño", "Precio", "Editar", "Eliminar"};
    DefaultTableModel tablaCarrito = new DefaultTableModel(titulos, 0);

    private byte pedido_id = 10;
    private JButton eliminar;
    private JButton modificar;
    private float sumaPrecio;

    public CarritoControlador(JintCarrito carrito) {
        this.carrito = carrito;
        carrito.jBtnCancelar.addActionListener(this);
        carrito.jBtnOrdenar.addActionListener(this);
        eliminar = new JButton();
        modificar = new JButton();
        eliminar.setBackground(Color.RED);
        eliminar.setFont(new java.awt.Font("Dialog", 1, 30));
        eliminar.setText("Eliminar");
        modificar.setBackground(Color.YELLOW);
        modificar.setFont(new java.awt.Font("Dialog", 1, 30));
        modificar.setText("Modificar");
        verCarrito();
        asignarPrecioTotal();
        dimensionesTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == carrito.jBtnCancelar) {
            verDetalle.clear();
        }

        if (e.getSource() == carrito.jBtnOrdenar) {
            controladorCliente = new ClienteControlador(cliente);
            principal.EscritorioPrincipal.add(cliente);
            cliente.setVisible(true);
            cliente.setLocation(320, 105);
            cliente.setSize(1500, 750);
        }

        verCarrito();
    }

    /**
     * Método para limpiar y/o actualizar los datos de la tabla
     */
    public void limpiarTabla() {
        int a = tablaCarrito.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tablaCarrito.removeRow(i);
        }
    }

    /**
     * Método para ver todos los datos del carrito mientras se van agregando al
     * arrayList
     */
    public void verCarrito() {
        limpiarTabla();
        carrito.jTlbCarrito.setDefaultRenderer(Object.class, new RenderTabla());
        Object[] filas = new Object[7];
        for (View_Ordenes orden : verDetalle) {
            filas[0] = orden.getCantidadOrden();
            filas[1] = orden.getProductoTamanioIdOrden();
            filas[2] = orden.getProductoOrden();
            filas[3] = orden.getTamanioOrden();
            filas[4] = "Q." + orden.getPrecioOrden();
            filas[5] = modificar;
            filas[6] = eliminar;
            tablaCarrito.addRow(filas);
            sumaPrecio += orden.getPrecioOrden();
        }
        carrito.jTlbCarrito.setModel(tablaCarrito);
    }

    /**
     * Método para asignar el precio total, o sease la suma del precio de todos
     * los productos
     */
    public void asignarPrecioTotal() {
        carrito.jLblTotal.setText("Q." + String.valueOf(sumaPrecio));
    }

    /**
     * Método para esconder valores en la tabla
     */
    public void dimensionesTabla() {
        carrito.jTlbCarrito.getColumnModel().getColumn(0).setMaxWidth(100);
        carrito.jTlbCarrito.getColumnModel().getColumn(1).setMaxWidth(0);
        carrito.jTlbCarrito.getColumnModel().getColumn(1).setMinWidth(0);
        carrito.jTlbCarrito.getColumnModel().getColumn(2).setMaxWidth(360);
        carrito.jTlbCarrito.getColumnModel().getColumn(3).setMaxWidth(250);
        carrito.jTlbCarrito.getColumnModel().getColumn(4).setMaxWidth(200);
        carrito.jTlbCarrito.getColumnModel().getColumn(5).setMaxWidth(250);
        carrito.jTlbCarrito.getColumnModel().getColumn(6).setMaxWidth(250);

    }

}
