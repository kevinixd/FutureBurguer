/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import static controlador.ProductoSeleccionado.clasificacion;
import static controlador.ProductoSeleccionado.productoID;
import dao.DaoProductos;
import dao.DaoTamanios;
import dao.DaoView_DetalleCombo;
import dao.DaoView_ProductosTamanios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.Productos;
import modelo.Tamanios;
import modelo.View_Descripcioncombo;
import modelo.View_productosTamanios;
import vista.JintDescripcionCombo;
import vista.JintOpcion;

public class DescripcionComboControlador implements ActionListener {

    //Frames a utilizar
    JintDescripcionCombo vista;
    JintOpcion opcion= new JintOpcion();
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

    private ArrayList<View_Descripcioncombo> listaCombo = new ArrayList();

//datos reales a guardar en la base de datos
    private ArrayList<View_Descripcioncombo> listaComboRenovada = new ArrayList();

    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    private int cantidad = 0;

    public DescripcionComboControlador(JintDescripcionCombo vista) {
        cantidad = 1;
        this.vista = vista;
        vista.jLblDescpCombo.setSize(productoID, productoID);
        llenarTamanios();
        llenarBebidas();
        addListeners();
        esconderEtiquetas();
        //Llenar cantidad en jTextFieldCantidad
        vista.jTxtCantidad.setText(String.valueOf(cantidad));
        asignarDatosCombos();
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
        vista.jLblAdvertencia.setVisible(false);
        vista.jLblAdvertencia1.setVisible(false);
        vista.jLblAdvertencia2.setVisible(false);
        vista.jLblAdvertencia3.setVisible(false);
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
        String tamanios = String.valueOf(vista.jCmbTamanioCombo.getSelectedItem());
        String producto = String.valueOf(vista.jCmbBebida.getSelectedItem());
        String snack = String.valueOf(vista.jLblSnackCombo.getText());

        if (e.getSource() == vista.jCmbTamanioCombo) {

            //Encontrar ID de Bebida por ComboBox Tamanio
            bebidaID = dao4.verProductoId(tamanios, producto);
            vista.jLblBebidaID.setText(String.valueOf(bebidaID.getPtIdView()));
            vista.jLblPrecioBebida.setText(String.valueOf("Q. " + bebidaID.getPrecioView()));
            //Encontrar ID de Snack
            snackID = dao4.verProductoId(tamanios, snack);
            vista.jLblSnackId.setText(String.valueOf(snackID.getPtIdView()));
            vista.jLblSnackPrecio.setText(String.valueOf("Q. " + snackID.getPrecioView()));

            //Asignar precio Total a la etiqueta de Precio
            vista.jLblPrecio.setText(String.valueOf("Q."
                    + String.valueOf(listaCombo.get(0).getPrecio() + bebidaID.getPrecioView()
                            + snackID.getPrecioView())));

            //Mostramos un asterico para demostrar el cambio en el precio
            vista.jLblAdvertencia.setVisible(true);
            vista.jLblAdvertencia1.setVisible(true);
            vista.jLblAdvertencia2.setVisible(true);
            vista.jLblAdvertencia3.setVisible(true);
        }

        if (e.getSource() == vista.jCmbBebida) {

            //Encontrar ID de Bebida por ComboBox Bebida
            bebidaID = dao4.verProductoId(tamanios, producto);
            vista.jLblBebidaID.setText(String.valueOf(bebidaID.getPtIdView()));
        }

        if (e.getSource() == vista.jBtnMas) {
            cantidad++;
            vista.jTxtCantidad.setText(String.valueOf(cantidad));
        }
        if (e.getSource() == vista.jBtnMenos) {
            cantidad--;
            vista.jTxtCantidad.setText(String.valueOf(cantidad));
        }
        
        if(e.getSource()==vista.JBtnRegresar){
            controlador= new OpcionesControlador(opcion);
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }
        deshabilitarBotonCantidad();

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
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(190, -1, java.awt.Image.SCALE_DEFAULT));

        //Imagen del combo
        vista.jLblImgCombo.setIcon(iconoRed);

        //Precio del combo
        vista.jLblPrecio.setText("Q." + String.valueOf(listaCombo.get(0).getPrecio() + listaCombo.get(1).getPrecio() + listaCombo.get(2).getPrecio()));

        //Descripcion del combo
        vista.jLblDescpCombo.setText(String.valueOf(listaCombo.get(0).getDescripcionCombo()));

        //Principal Datos
        vista.jLblProductPrincipal.setText(String.valueOf(listaCombo.get(0).getProductoCombo()));
        vista.jLblPrincipalID.setText(String.valueOf(listaCombo.get(0).getProductoTamanioId()));
        vista.jLblPrecioPrincipal.setText(String.valueOf("Q." + listaCombo.get(0).getPrecio()));

        //Snack datos
        vista.jLblSnackCombo.setText(String.valueOf(listaCombo.get(1).getProductoCombo()));
        vista.jLblSnackId.setText(String.valueOf(listaCombo.get(1).getProductoTamanioId()));
        vista.jLblSnackPrecio.setText(String.valueOf("Q." + listaCombo.get(1).getPrecio()));

        //Bebida datos
        vista.jLblBebidaID.setText(String.valueOf(listaCombo.get(2).getProductoTamanioId()));
        vista.jLblPrecioBebida.setText(String.valueOf("Q." + listaCombo.get(2).getPrecio()));

        //Principal ID
        listaComboRenovada = listaCombo;
    }
}
