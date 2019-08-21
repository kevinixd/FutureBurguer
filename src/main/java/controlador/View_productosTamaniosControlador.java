/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.clasificacion;
import static controlador.PrincipalControlador.principal;
import static controlador.ProductoSeleccionado.productoID;
import dao.DaoTamanios;
import dao.DaoView_ProductosTamanios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.DetallePedido;
import modelo.Tamanios;
import modelo.View_productosTamanios;
import vista.JintDescripcionProducto;
import vista.JintOpcion;
import vista.formulariosbebidas.jIntBebidasCalientes;
import vista.formulariosbebidas.jIntBebidasFrias;
import vista.formulariospostres.jIntPostres;
import vista.formulariossnacks.jIntSnacks;
import static controlador.ProductoSeleccionado.insertarPedido;
import modelo.View_Ordenes;
import vista.JintCarrito;

/**
 *
 * @author qobis
 */
public class View_productosTamaniosControlador implements ActionListener {

    //Frames a utlizar
    JintOpcion opcion = new JintOpcion();
    JintDescripcionProducto vista;
    jIntBebidasCalientes bebidaCaliente = new jIntBebidasCalientes();
    jIntBebidasFrias bebidasFrias = new jIntBebidasFrias();
    jIntPostres postres = new jIntPostres();
    jIntSnacks snack = new jIntSnacks();
    JintCarrito carrito= new JintCarrito();

    DefaultComboBoxModel tamanio = new DefaultComboBoxModel();

    //Daos a utlizar
    DaoView_ProductosTamanios dao = new DaoView_ProductosTamanios();
    DaoTamanios dao2 = new DaoTamanios();

    //Modelos a utlizar
    View_productosTamanios producTamanios = new View_productosTamanios();

    //Controlador a utilizar
    OpcionesControlador controlador;
    BebidasCalienteControlador bcControlador;
    BebidasFriasControlador bfControlador;
    PostresControlador postreControlador;
    SnacksControlador snackControlador;
    CarritoControlador carritoControlador;

    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\vistaProductos\\";

    private int cantidad = 0;

    private int cantidadActualizada = 1;

    public View_productosTamaniosControlador(JintDescripcionProducto vista) {
        cantidad = 1;
        this.vista = vista;
        vista.JBtnRegresarProduc.addActionListener(this);
        vista.jBtnAñadirProduc.addActionListener(this);
        vista.jBtnMas.addActionListener(this);
        vista.jBtnMenos.addActionListener(this);
        vista.jCmbTamanioProducto.addActionListener(this);
        vista.jLblWarningProducto.setVisible(false);
        llenarTamanios();
        asignarDatosProductos();
        asignarDatosporTamanio();
        vista.JlblAdvertencia.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jCmbTamanioProducto) {
            vista.jLblTamanio.setText(String.valueOf(vista.jCmbTamanioProducto.getSelectedItem()));
            asignarDatosporTamanio();
        }

        if (e.getSource() == vista.jBtnAñadirProduc) {
            asignarDatosPedido();

        }

        if (e.getSource() == vista.JBtnRegresarProduc) {
            if (clasificacion == 1001 || clasificacion == 1006) {
                controlador = new OpcionesControlador(opcion);
                principal.EscritorioPrincipal.add(opcion);
                opcion.setVisible(true);
                opcion.setLocation(320, 105);
                opcion.setSize(1500, 750);

            } else if (clasificacion == 1002) {
                bfControlador = new BebidasFriasControlador(bebidasFrias);
                principal.EscritorioPrincipal.add(bebidasFrias);
                bebidasFrias.setVisible(true);
                bebidasFrias.setLocation(320, 105);
                bebidasFrias.setSize(1500, 750);

            } else if (clasificacion == 1003) {
                bcControlador = new BebidasCalienteControlador(bebidaCaliente);
                principal.EscritorioPrincipal.add(bebidaCaliente);
                bebidaCaliente.setVisible(true);
                bebidaCaliente.setLocation(320, 105);
                bebidaCaliente.setSize(1500, 750);

            } else if (clasificacion == 1004) {
                postreControlador = new PostresControlador(postres);
                principal.EscritorioPrincipal.add(postres);
                postres.setVisible(true);
                postres.setLocation(320, 105);
                postres.setSize(1500, 750);

            } else if (clasificacion == 1005) {
                snackControlador = new SnacksControlador(snack);
                principal.EscritorioPrincipal.add(snack);
                snack.setVisible(true);
                snack.setLocation(320, 105);
                snack.setSize(1500, 750);
            }
        }

        if (e.getSource() == vista.jBtnMas) {
            cantidad++;
            vista.jTxtCantidad.setText(String.valueOf(cantidad));
        }
        if (e.getSource() == vista.jBtnMenos) {
            cantidad--;
            vista.jTxtCantidad.setText(String.valueOf(cantidad));
        }
        deshabilitarBotonCantidad();

        cantidadActualizada = Integer.parseInt(vista.jTxtCantidad.getText());
        vista.jLblPrecioCombo.setText(String.valueOf(producTamanios.getPrecioView() * cantidadActualizada));
    }

    //Deshabilitar botones Mas y Menos dependiendo de la cantidad
    public void deshabilitarBotonCantidad() {
        if (cantidad > 14) {
            vista.jBtnMas.setEnabled(false);
            vista.jTxtCantidad.setText(String.valueOf(cantidad));
        } else if (cantidad == 1) {
            vista.jBtnMenos.setEnabled(false);
        } else {
            vista.jBtnMenos.setEnabled(true);
            vista.jBtnMas.setEnabled(true);
        }
    }

    public void llenarTamanios() {
        for (Tamanios verTamanio : dao2.verTamanios()) {
            tamanio.addElement(verTamanio.getTamanionombre());
        }
        vista.jCmbTamanioProducto.setModel(tamanio);
    }

    public void asignarDatosProductos() {
        producTamanios = dao.verProductoDetalle(productoID);
        vista.jLblNombreProducto.setText(String.valueOf(producTamanios.getProductoView()));
        ImageIcon icono = new ImageIcon(rutaProducto + producTamanios.getProductoImgView());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(210, -1, java.awt.Image.SCALE_DEFAULT));
        vista.jLblImgProducto.setIcon(iconoRed);
        vista.jLblDescpProducto.setText(String.valueOf(producTamanios.getProductoDescpView()));
        vista.jLblPrecioCombo.setText(String.valueOf(producTamanios.getPrecioView() * cantidadActualizada));

        //Asignamos el Tamanio al label para luego realizar la busqueda
        vista.jLblTamanio.setText(String.valueOf(producTamanios.getTamanioView()));

        //Comprobamos si el tamaño es unico, de tal manera que si es asi se deshabilita el combo Box
        if (producTamanios.getTamanioView().equals("Único")) {
            vista.jCmbTamanioProducto.setEnabled(false);
            vista.jLblWarningProducto.setVisible(true);
            vista.jLblTamanio.setText(String.valueOf("Unico"));
        }
    }

    public void asignarDatosporTamanio() {
        String tamanio = String.valueOf(vista.jLblTamanio.getText());
        producTamanios = dao.verPorTamanio(productoID, tamanio);
        vista.jLblPrecioCombo.setText(String.valueOf(producTamanios.getPrecioView() * cantidadActualizada));
        vista.jLblPtId.setText(String.valueOf(producTamanios.getPtIdView()));
        vista.JlblAdvertencia.setVisible(true);
    }

    public void asignarDatosPedido() {
        DetallePedido pedido = new DetallePedido();
        pedido.setProducto_tamaño_id(Integer.parseInt(vista.jLblPtId.getText()));
        pedido.setCantidad(Byte.parseByte(vista.jTxtCantidad.getText()));
        pedido.setPrecio(Float.parseFloat(vista.jLblPrecioCombo.getText()));
        insertarPedido.add(pedido);
    }
    
    public void asignarDatosCarrito(){
        View_Ordenes carrito= new View_Ordenes();
        carrito.setCantidadOrden(Integer.parseInt(vista.jTxtCantidad.getText()));
        carrito.setProductoOrden(vista.jLblNombreProducto.getText());
        carrito.setTamanioOrden(String.valueOf(vista.jLblTamanio.getText()));
        carrito.setProductoTamanioIdOrden(Integer.parseInt(vista.jLblPtId.getText()));
    }
}
