/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.productoID;
import dao.DaoTamanios;
import dao.DaoView_ProductosTamanios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.Tamanios;
import modelo.View_productosTamanios;
import vista.JintDescripcionProducto;

/**
 *
 * @author qobis
 */
public class View_productosTamaniosControlador implements ActionListener {

    JintDescripcionProducto vista;

    DefaultComboBoxModel tamanio = new DefaultComboBoxModel();

    //Daos a utlizar
    DaoView_ProductosTamanios dao = new DaoView_ProductosTamanios();
    DaoTamanios dao2 = new DaoTamanios();

    //Modelos a utlizar
    View_productosTamanios producTamanios = new View_productosTamanios();

    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\vistaProductos\\";

    public View_productosTamaniosControlador(JintDescripcionProducto vista) {
        this.vista = vista;
        vista.JBtnRegresarProduc.addActionListener(this);
        vista.jBtnAñadirProduc.addActionListener(this);
        vista.jCmbTamanioProducto.addActionListener(this);
        vista.jLblWarningProducto.setVisible(false);
        llenarTamanios();
        asignarDatosProductos();
        vista.JlblAdvertencia.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jCmbTamanioProducto){
            asignarDatosporTamanio();
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
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(190, -1, java.awt.Image.SCALE_DEFAULT));
        vista.jLblImgProducto.setIcon(iconoRed);
        vista.jLblDescpProducto.setText(String.valueOf(producTamanios.getProductoDescpView()));
        vista.jLblPrecioCombo.setText("Q." + String.valueOf(producTamanios.getPrecioView()));
        
        //Comprobamos si el tamaño es unico, de tal manera que si es asi se deshabilita el combo Box
        if(producTamanios.getTamanioView().equals("Único")){
            vista.jCmbTamanioProducto.setEnabled(false);
            vista.jLblWarningProducto.setVisible(true);
        }
    }

    public void asignarDatosporTamanio(){
        String tamanio= String.valueOf(vista.jCmbTamanioProducto.getSelectedItem());
        producTamanios=dao.verPorTamanio(productoID, tamanio);
        vista.jLblPrecioCombo.setText("Q." + String.valueOf(producTamanios.getPrecioView()));
        vista.JlblAdvertencia.setVisible(true);
    }
}
