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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.Productos;
import modelo.Tamanios;
import modelo.View_Descripcioncombo;
import vista.JintDescripcionCombo;

public class DescripcionComboControlador implements ActionListener {

    JintDescripcionCombo vista;
    DefaultComboBoxModel tamaniosComboBox = new DefaultComboBoxModel();
    DefaultComboBoxModel productosComboBox;

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();
    DaoTamanios dao2 = new DaoTamanios();
    DaoView_DetalleCombo dao3= new DaoView_DetalleCombo();

    //Modelos a utilizar
    View_Descripcioncombo descripcion= new View_Descripcioncombo();
    
    private ArrayList<View_Descripcioncombo> listaCombo= new ArrayList();
    
//datos reales a guardar en la base de datos
    private ArrayList<View_Descripcioncombo> listaComboRenovada= new ArrayList();
    
    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";
    
    public DescripcionComboControlador(JintDescripcionCombo vista) {
        this.vista = vista;
        vista.JBtnRegresar.addActionListener(this);
        vista.jBtnAñadir.addActionListener(this);
        llenarTamanios();
        llenarBebidas();
        asignarDatosCombos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        Si selecciona comboBox
        Si selecciona grande
        buscar codigo pt donde el tamanio_id sea igual a el item seleccionado 
        el resultado de esabusqueda
        vista.jLblSnackId.setText(String.valueOf(listaCombo.get(1).getProductoTamanioId()));
        vista.jLblBebidaID.setText(String.valueOf(listaCombo.get(2).getProductoTamanioId()));
        
        */
    }

    public void llenarTamanios() {
        for (Tamanios tamanios : dao2.verTamanios()) {
            tamaniosComboBox.addElement(tamanios.getTamanionombre());
        }
        vista.jCmbTamanioCombo.setModel(tamaniosComboBox);
    }

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
    
    public void asignarDatosCombos(){
        listaCombo=dao3.verProductos(productoID);
        vista.jLblNombreCombo.setText(String.valueOf(listaCombo.get(0).getNombreCombo()));
        ImageIcon icono= new ImageIcon(rutaCombo + listaCombo.get(0).getImagenDetalleCombo());
        ImageIcon iconoRed= new ImageIcon(icono.getImage().getScaledInstance(190, -1, java.awt.Image.SCALE_DEFAULT));
        vista.jLblImgCombo.setIcon(iconoRed);
        vista.jLblPrecioCombo.setText("Q." + String.valueOf(listaCombo.get(0).getPrecio() + listaCombo.get(1).getPrecio() + listaCombo.get(2).getPrecio()));
        vista.jLblDescpCombo.setText(String.valueOf(listaCombo.get(0).getDescripcionCombo()));
        vista.jLblSnackCombo.setText(String.valueOf(listaCombo.get(1).getProductoCombo()));
        vista.jLblSnackId.setText(String.valueOf(listaCombo.get(1).getProductoTamanioId()));
        vista.jLblBebidaID.setText(String.valueOf(listaCombo.get(2).getProductoTamanioId()));
        listaComboRenovada = listaCombo;
    }
    

}
