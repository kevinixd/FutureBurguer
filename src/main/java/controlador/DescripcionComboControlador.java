/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 * Esta clase mostrara al usuario la descripcion del combo
 * que ordeno el cliente.
 * 
 * @author futureBurguer
 */

import static controlador.PrincipalControlador.principal;
import static controlador.VariablesEstaticas.clasificacion;
import static controlador.VariablesEstaticas.productoID;
import dao.DaoProductos;
import dao.DaoTamanios;
import dao.DaoView_DetalleCombo;
import dao.DaoView_ProductosTamanios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.DetallePedido;
import modelo.Productos;
import modelo.Tamanios;
import modelo.View_Descripcioncombo;
import modelo.View_productosTamanios;
import vista.JintDescripcionCombo;
import vista.JintOpcion;
import modelo.View_Ordenes;
import static controlador.VariablesEstaticas.verDetalle;
import static controlador.VariablesEstaticas.cantidad;
import static controlador.VariablesEstaticas.index;
import java.text.DecimalFormat;
import vista.JintCarrito;

public class DescripcionComboControlador implements ActionListener {

    //Frames a utilizar
    JintDescripcionCombo vista;
    JintCarrito carrito = new JintCarrito();
    JintOpcion opcion = new JintOpcion();
    DefaultComboBoxModel tamaniosComboBox = new DefaultComboBoxModel();
    DefaultComboBoxModel productosComboBox;

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();
    DaoTamanios dao2 = new DaoTamanios();
    DaoView_DetalleCombo dao3 = new DaoView_DetalleCombo();
    DaoView_ProductosTamanios dao4 = new DaoView_ProductosTamanios();

    //Modelos a utilizar
    View_Descripcioncombo descripcion = new View_Descripcioncombo();
    View_productosTamanios bebidaID = new View_productosTamanios();
    View_productosTamanios snackID = new View_productosTamanios();

    //Controlador a utlizar
    OpcionesControlador controlador;
    CarritoControlador controladorCarrito;

    //Mostrar solo dos decimales
    DecimalFormat formato1 = new DecimalFormat("#.00");
    private ArrayList<View_Descripcioncombo> listaCombo = new ArrayList();

//datos reales a guardar en la base de datos
    private ArrayList<View_Descripcioncombo> listaComboRenovada = new ArrayList();

    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    //Variable para la cantidad del JtextField
    private int cantidadTxt = 0;

    //Variable para la cantidad que se actualiza en el JtextField
    private int cantidadActualizada = 1;

    //Variable para acumular la cantidad de productos
    private int acumulador = 0;

    //Datos para la consulta sobre los precios
    private String tamanios;
    private String snack;
    private String producto;

    public DescripcionComboControlador(JintDescripcionCombo vista) {
        cantidadTxt = 1;
        this.vista = vista;
        llenarTamanios();
        llenarBebidas();
        addListeners();
        esconderEtiquetas();
        //Llenar cantidadTxt en jTextFieldCantidad
        vista.jTxtCantidad.setText(String.valueOf(cantidadTxt));
        vista.jTxtCantidad.setEnabled(false);
        asignarDatosCombos();
        verPrecioTamanio();
        deshabilitarBotonCantidad();
    }

    public void addListeners() {
        vista.JBtnRegresar.addActionListener(this);
        vista.jBtnAñadir.addActionListener(this);
        vista.jCmbBebida.addActionListener(this);
        vista.jCmbTamanioCombo.addActionListener(this);
        vista.jBtnMas.addActionListener(this);
        vista.jBtnMenos.addActionListener(this);
    }

    public void esconderEtiquetas() {
        vista.jLblAdvertenciaSnack.setVisible(false);
        vista.jLblAdvertenciaPrincipal.setVisible(false);
        vista.jLblAdvertenciaBebida.setVisible(false);
        vista.jLblAdvertenciaCombo.setVisible(false);
        vista.jLblPrincipalID.setVisible(false);
        vista.jLblBebidaID.setVisible(false);
        vista.jLblSnackId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        *Si selecciona comboBox
        *Si selecciona grande
        *buscar codigo pt donde el tamanio_id sea igual a el item seleccionado 
        *el resultado de esabusqueda
        *vista.jLblSnackId.setText(String.valueOf(listaCombo.get(1).getProductoTamanioId()));
        *vista.jLblBebidaID.setText(String.valueOf(listaCombo.get(2).getProductoTamanioId()));        
         */

        if (e.getSource() == vista.jCmbTamanioCombo) {

            //Encontrar ID de Bebida por ComboBox Tamanio
            verPrecioTamanio();

            //Mostramos un asterico para demostrar el cambio en el precio
            vista.jLblAdvertenciaSnack.setVisible(true);
            vista.jLblAdvertenciaPrincipal.setVisible(true);
            vista.jLblAdvertenciaBebida.setVisible(true);
            vista.jLblAdvertenciaCombo.setVisible(true);
        }

        if (e.getSource() == vista.jCmbBebida) {

            //Encontrar ID de Bebida por ComboBox Tamanio
            verPrecioTamanio();

            //Mostramos un asterisco para demostrar el cambio en el precio
            vista.jLblAdvertenciaBebida.setVisible(true);
        }

        if (e.getSource() == vista.jBtnMas) {
            cantidadTxt++;
            vista.jTxtCantidad.setText(String.valueOf(cantidadTxt));
        }

        if (e.getSource() == vista.jBtnMenos) {
            cantidadTxt--;
            vista.jTxtCantidad.setText(String.valueOf(cantidadTxt));
        }

        if (e.getSource() == vista.JBtnRegresar) {
            controlador = new OpcionesControlador(opcion);
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(320, 105);
            opcion.setSize(1500, 750);
        }

        if (e.getSource() == vista.jBtnAñadir) {
            asignarDatos();
            agregarCantidad();
            controladorCarrito = new CarritoControlador(carrito);
            principal.EscritorioPrincipal.add(carrito);
            carrito.setVisible(true);
            carrito.setLocation(320, 105);
            carrito.setSize(1500, 750);
        }

        cantidadActualizada = Integer.parseInt(vista.jTxtCantidad.getText());
        asignarPrecios();
        deshabilitarBotonCantidad();

    }

    //Asignar precio e iD por busqueda de tamanio
    public void verPrecioTamanio() {
        tamanios = String.valueOf(vista.jCmbTamanioCombo.getSelectedItem());
        producto = String.valueOf(vista.jCmbBebida.getSelectedItem());
        snack = String.valueOf(vista.jLblSnackCombo.getText());

        bebidaID = dao4.verProductoId(tamanios, producto);
        vista.jLblBebidaID.setText(String.valueOf(bebidaID.getPtIdView()));
        vista.jLblPrecioBebida.setText(String.valueOf((bebidaID.getPrecioView() * cantidadActualizada) - ((bebidaID.getPrecioView() * cantidadActualizada)) * (listaCombo.get(0).getDescuento() / 100)));
        //Encontrar ID de Snack
        snackID = dao4.verProductoId(tamanios, snack);
        vista.jLblSnackId.setText(String.valueOf(snackID.getPtIdView()));
        vista.jLblSnackPrecio.setText(String.valueOf((snackID.getPrecioView() * cantidadActualizada) - ((snackID.getPrecioView() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))));

        //Asignar precio Total a la etiqueta de Precio
        vista.jLblPrecioCombo.setText(String.valueOf(String.valueOf(((listaCombo.get(0).getPrecio() + bebidaID.getPrecioView()
                + snackID.getPrecioView() * cantidadActualizada) - ((listaCombo.get(0).getPrecio() + bebidaID.getPrecioView()
                + snackID.getPrecioView() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))))));

    }

    //Asignar SOLO precios dependiendo del tamaño
    public void asignarPrecios() {
        //Precio Bebida
        vista.jLblPrecioBebida.setText(String.valueOf((bebidaID.getPrecioView() * cantidadActualizada) - ((bebidaID.getPrecioView() * cantidadActualizada)) * (listaCombo.get(0).getDescuento() / 100)));

        //Precio Snack
        vista.jLblSnackPrecio.setText(String.valueOf((snackID.getPrecioView() * cantidadActualizada) - ((snackID.getPrecioView() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))));

        //Precio Producto Principal
        vista.jLblPrecioPrincipal.setText(String.valueOf((listaCombo.get(0).getPrecio() * cantidadActualizada) - ((listaCombo.get(0).getPrecio() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))));

        //Precio Total
        vista.jLblPrecioCombo.setText(String.valueOf(String.valueOf(((listaCombo.get(0).getPrecio() + bebidaID.getPrecioView()
                + snackID.getPrecioView() * cantidadActualizada) - ((listaCombo.get(0).getPrecio() + bebidaID.getPrecioView()
                + snackID.getPrecioView() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))))));
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

    //Metodo para llenar el comboBox de tamaños
    public void llenarTamanios() {
        for (Tamanios tamanios : dao2.verTamanios()) {
            tamaniosComboBox.addElement(tamanios.getTamanionombre());
        }
        vista.jCmbTamanioCombo.setModel(tamaniosComboBox);
    }

    //Metodo para llenar el comboBox de Bebidas
    public void llenarBebidas() {
        if (clasificacion == 1001) {
            productosComboBox = new DefaultComboBoxModel();
            for (Productos verBebida : dao.verBebidas()) {
                productosComboBox.addElement(verBebida.getProductonombre());
            }
        } else if (clasificacion == 1006) {
            productosComboBox = new DefaultComboBoxModel();
            for (Productos verBebida : dao.verBebidasDesayuno()) {
                productosComboBox.addElement(verBebida.getProductonombre());
            }
        }
        vista.jCmbBebida.setModel(productosComboBox);
    }

    //Asignar datos a los elementos del frame para ver la descripcion de los Combox
    public void asignarDatosCombos() {
        listaCombo = dao3.verProductos(productoID);

        //Nombre del combo
        vista.jLblNombreCombo.setText(String.valueOf(listaCombo.get(0).getNombreCombo()));
        ImageIcon icono = new ImageIcon(rutaCombo + listaCombo.get(0).getImagenDetalleCombo());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(230, -1, java.awt.Image.SCALE_DEFAULT));
        vista.jLblDescuento.setText(String.valueOf(listaCombo.get(0).getDescuento()) + "% de Descuento");

        //Imagen del combo
        vista.jLblImgCombo.setIcon(iconoRed);

        //Precio del combo
        vista.jLblPrecioCombo.setText(String.valueOf((listaCombo.get(0).getPrecio() + listaCombo.get(1).getPrecio() + listaCombo.get(2).getPrecio())
                - ((listaCombo.get(0).getPrecio() + listaCombo.get(1).getPrecio() + listaCombo.get(2).getPrecio()) * (listaCombo.get(0).getDescuento() / 100))));

        //Descripcion del combo
        vista.jLblDescpCombo.setText(String.valueOf(listaCombo.get(0).getDescripcionCombo()));

        //Principal Datos
        vista.jLblProductPrincipal.setText(String.valueOf(listaCombo.get(0).getProductoCombo()));
        vista.jLblPrincipalID.setText(String.valueOf(listaCombo.get(0).getProductoTamanioId()));
        vista.jLblPrecioPrincipal.setText(String.valueOf((listaCombo.get(0).getPrecio() * cantidadActualizada) - ((listaCombo.get(0).getPrecio() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))));
        vista.jLblPrincipalTamanio.setText(String.valueOf(listaCombo.get(0).getTamanioCombo()));

        //Snack datos
        vista.jLblSnackCombo.setText(String.valueOf(listaCombo.get(1).getProductoCombo()));
        vista.jLblSnackId.setText(String.valueOf(listaCombo.get(1).getProductoTamanioId()));
        vista.jLblSnackPrecio.setText(String.valueOf((listaCombo.get(1).getPrecio() * cantidadActualizada) - ((listaCombo.get(1).getPrecio() * cantidadActualizada) * (listaCombo.get(0).getDescuento() / 100))));

        //Bebida datos
        vista.jLblBebidaID.setText(String.valueOf(listaCombo.get(2).getProductoTamanioId()));
        vista.jLblPrecioBebida.setText(String.valueOf((listaCombo.get(2).getPrecio() * cantidadActualizada) - ((listaCombo.get(2).getPrecio() * cantidadActualizada) * (listaCombo.get(2).getDescuento() / 100))));
    }

    

    /**
     * Metodo para asinarDatos al Carrito de Compras
     */
    public void asignarDatos() {
        //Datos Principal
        View_Ordenes orden = new View_Ordenes();
        orden.setProductoTamanioIdOrden(Integer.parseInt(vista.jLblPrincipalID.getText()));
        orden.setCantidadOrden(Integer.parseInt(vista.jTxtCantidad.getText()));
        orden.setProductoOrden(String.valueOf(vista.jLblProductPrincipal.getText()));
        orden.setTamanioOrden(String.valueOf(vista.jLblPrincipalTamanio.getText()));
        orden.setPrecioOrden(Float.parseFloat(vista.jLblPrecioPrincipal.getText()));
        verDetalle.add(orden);

        //Datos bebida
        orden = new View_Ordenes();
        orden.setProductoTamanioIdOrden(Integer.parseInt(vista.jLblBebidaID.getText()));
        orden.setCantidadOrden(Integer.parseInt(vista.jTxtCantidad.getText()));
        orden.setProductoOrden(String.valueOf(vista.jCmbBebida.getSelectedItem()));
        orden.setTamanioOrden(String.valueOf(vista.jCmbTamanioCombo.getSelectedItem()));
        orden.setPrecioOrden(Float.parseFloat(vista.jLblPrecioBebida.getText()));
        verDetalle.add(orden);

        //Datos acompañamiento
        orden = new View_Ordenes();
        orden.setProductoTamanioIdOrden(Integer.parseInt(vista.jLblSnackId.getText()));
        orden.setCantidadOrden(Integer.parseInt(vista.jTxtCantidad.getText()));
        orden.setProductoOrden(String.valueOf(vista.jLblSnackCombo.getText()));
        orden.setTamanioOrden(String.valueOf(vista.jCmbTamanioCombo.getSelectedItem()));
        orden.setPrecioOrden(Float.parseFloat(vista.jLblSnackPrecio.getText()));
        verDetalle.add(orden);
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
