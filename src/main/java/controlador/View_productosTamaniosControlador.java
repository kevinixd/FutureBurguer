/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.VariablesEstaticas.clasificacion;
import static controlador.PrincipalControlador.principal;
import static controlador.VariablesEstaticas.cantidad;
import static controlador.VariablesEstaticas.index;
import static controlador.VariablesEstaticas.productoID;
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
import static controlador.VariablesEstaticas.verDetalle;
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
    JintCarrito carrito = new JintCarrito();

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

    //Variable para la cantidadTxt
    private int cantidadTxt = 0;

    //Variable para multiplicar la cantidadTxt mediante el boton de mas
    private int cantidadActualizada = 1;

    //Acumulador para la cantidadTxt
    private int acumulador = 0;

    public View_productosTamaniosControlador(JintDescripcionProducto vista) {
        cantidadTxt = 1;
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
        deshabilitarBotonCantidad();
        vista.JlblAdvertencia.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jCmbTamanioProducto) {
            vista.jLblTamanio.setText(String.valueOf(vista.jCmbTamanioProducto.getSelectedItem()));
            asignarDatosporTamanio();
        }

        if (e.getSource() == vista.jBtnAñadirProduc) {
            asignarDatosCarrito();
            agregarCantidad();
            carritoControlador = new CarritoControlador(carrito);
            principal.EscritorioPrincipal.add(carrito);
            carrito.setVisible(true);
            carrito.setLocation(320, 105);
            carrito.setSize(1500, 750);
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
            cantidadTxt++;
            vista.jTxtCantidad.setText(String.valueOf(cantidadTxt));
        }
        if (e.getSource() == vista.jBtnMenos) {
            cantidadTxt--;
            vista.jTxtCantidad.setText(String.valueOf(cantidadTxt));
        }
        deshabilitarBotonCantidad();

        cantidadActualizada = Integer.parseInt(vista.jTxtCantidad.getText());
        vista.jLblPrecioProducto.setText(String.valueOf(producTamanios.getPrecioView() * cantidadActualizada));
    }

    //Deshabilitar botones Mas y Menos dependiendo de la cantidadTxt
    public void deshabilitarBotonCantidad() {
        if (cantidadTxt > 14) {
            vista.jBtnMas.setEnabled(false);
            vista.jTxtCantidad.setText(String.valueOf(cantidadTxt));
        } else if (cantidadTxt == 1) {
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
        vista.jLblPrecioProducto.setText(String.valueOf(producTamanios.getPrecioView() * cantidadActualizada));

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
        vista.jLblPrecioProducto.setText(String.valueOf(producTamanios.getPrecioView() * cantidadActualizada));
        vista.jLblPtId.setText(String.valueOf(producTamanios.getPtIdView()));
        vista.JlblAdvertencia.setVisible(true);
    }

    public void asignarDatosCarrito() {
        View_Ordenes carrito = new View_Ordenes();
        carrito.setProductoTamanioIdOrden(Integer.parseInt(vista.jLblPtId.getText()));
        carrito.setCantidadOrden(Integer.parseInt(vista.jTxtCantidad.getText()));
        carrito.setProductoOrden(vista.jLblNombreProducto.getText());
        carrito.setTamanioOrden(String.valueOf(vista.jLblTamanio.getText()));
        carrito.setPrecioOrden(Float.parseFloat(vista.jLblPrecioProducto.getText()));
        verDetalle.add(carrito);
    }

    public void agregarCantidad() {
        for (int i = index; i <= verDetalle.size() - 1; i++) {
            acumulador = verDetalle.get(i).getCantidadOrden();
            cantidad = cantidad + acumulador;
            index++;
        }
        principal.jLblCantidadProductos.setText("+" + String.valueOf(cantidad));
    }
}
