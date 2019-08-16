/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

public class DescripcionComboControlador implements ActionListener {

    JintDescripcionCombo vista;
    DefaultComboBoxModel tamaniosComboBox = new DefaultComboBoxModel();
    DefaultComboBoxModel productosComboBox;
    DefaultComboBoxModel cantidad = new DefaultComboBoxModel();

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();
    DaoTamanios dao2 = new DaoTamanios();
    DaoView_DetalleCombo dao3 = new DaoView_DetalleCombo();
    DaoView_ProductosTamanios dao4 = new DaoView_ProductosTamanios();

    //Modelos a utilizar
    View_Descripcioncombo descripcion = new View_Descripcioncombo();
    View_productosTamanios bebidaID = new View_productosTamanios();
    View_productosTamanios snackID = new View_productosTamanios();

    private ArrayList<View_Descripcioncombo> listaCombo = new ArrayList();

//datos reales a guardar en la base de datos
    private ArrayList<View_Descripcioncombo> listaComboRenovada = new ArrayList();

    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    public DescripcionComboControlador(JintDescripcionCombo vista) {
        this.vista = vista;
        vista.JBtnRegresar.addActionListener(this);
        vista.jBtnAñadir.addActionListener(this);
        vista.jCmbBebida.addActionListener(this);
        vista.jCmbTamanioCombo.addActionListener(this);
        vista.jLblDescpCombo.setSize(productoID, productoID);
        llenarTamanios();
        llenarBebidas();
       // llenarCantidad();
        asignarDatosCombos();
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

            //Encontrar ID de Snack
            snackID = dao4.verProductoId(tamanios, snack);
            vista.jLblSnackId.setText(String.valueOf(snackID.getPtIdView()));
        }

        if (e.getSource() == vista.jCmbBebida) {

            //Encontrar ID de Bebida por ComboBox Bebida
            bebidaID = dao4.verProductoId(tamanios, producto);
            vista.jLblBebidaID.setText(String.valueOf(bebidaID.getPtIdView()));
        }

        //Asignar precio Total a la etiqueta de Precio
        vista.jLblPrecio.setText(String.valueOf("Q."
                + String.valueOf(listaCombo.get(0).getPrecio() + bebidaID.getPrecioView()
                        + snackID.getPrecioView())));
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
        vista.jLblNombreCombo.setText(String.valueOf(listaCombo.get(0).getNombreCombo()));
        ImageIcon icono = new ImageIcon(rutaCombo + listaCombo.get(0).getImagenDetalleCombo());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(190, -1, java.awt.Image.SCALE_DEFAULT));
        vista.jLblImgCombo.setIcon(iconoRed);
        vista.jLblPrecio.setText("Q." + String.valueOf(listaCombo.get(0).getPrecio() + listaCombo.get(1).getPrecio() + listaCombo.get(2).getPrecio()));
        vista.jLblDescpCombo.setText(String.valueOf(listaCombo.get(0).getDescripcionCombo()));
        vista.jLblProductPrincipal.setText(String.valueOf(listaCombo.get(0).getProductoCombo()));
        vista.jLblSnackCombo.setText(String.valueOf(listaCombo.get(1).getProductoCombo()));
        vista.jLblSnackId.setText(String.valueOf(listaCombo.get(1).getProductoTamanioId()));
        vista.jLblBebidaID.setText(String.valueOf(listaCombo.get(2).getProductoTamanioId()));
        listaComboRenovada = listaCombo;
    }

    /*public void llenarCantidad(){
        for (int i = 1; i < 16; i++) {
            cantidad.addElement(i);
        }
        vista.jCmbCantidad.setModel(cantidad);
    }*/
}
