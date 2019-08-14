/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.productoID;
import dao.DaoProductos;
import dao.DaoView_DetalleCombo;
import dao.DaoView_ProductosTamanios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import modelo.View_Descripcioncombo;
import modelo.View_productosTamanios;
import vista.JintOpcion;
import vista.JintDescripcionCombo;
import vista.JintDescripcionProducto;

/**
 *
 * @author Futureburguer
 */
public class OpcionesControlador implements ActionListener {
    
    //Formularios a utilizar
    JintOpcion opcion= new JintOpcion();
    JintDescripcionCombo combo= new JintDescripcionCombo();
    JintDescripcionProducto producto= new JintDescripcionProducto();
    
    //Daos a utlizar
    DaoProductos dao= new DaoProductos();
    DaoView_ProductosTamanios dao2= new DaoView_ProductosTamanios();
    DaoView_DetalleCombo dao3= new DaoView_DetalleCombo();
    
    //Modelos a utilizar:
    View_productosTamanios producTamanios= new View_productosTamanios();
    View_Descripcioncombo descripcion= new View_Descripcioncombo();

    private ArrayList<View_Descripcioncombo> listaCombo= new ArrayList();
    
    
    public OpcionesControlador(JintOpcion opcion) {
        this.opcion = opcion;
        opcion.jBtnCombo.addActionListener(this);
        opcion.jBtnIndividual.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==opcion.jBtnCombo){
            asignarDatosCombos();
            combo.setVisible(true);
            combo.setLocation(300, 100);
            combo.setSize(910, 550);
        }
    }

    public void asignarDatosCombos(){
        listaCombo=dao3.verProductos(productoID);
        combo.jLblNombreCombo.setText(String.valueOf(listaCombo.get(0).getNombreCombo()));
        ImageIcon icono= new ImageIcon(listaCombo.get(0).getImagenDetalleCombo());
        ImageIcon iconoRed= new ImageIcon(icono.getImage().getScaledInstance(200, -1, java.awt.Image.SCALE_DEFAULT));
        combo.jLblImgCombo.setIcon(iconoRed);
        combo.jLblPrecioCombo.setText(String.valueOf(listaCombo.get(0).getPrecio() + listaCombo.get(1).getPrecio() + listaCombo.get(2).getPrecio()));
        combo.jLblDescpCombo.setText(String.valueOf(listaCombo.get(0).getDescripcionCombo()));
        combo.jLblSnackCombo.setText(String.valueOf(listaCombo.get(1).getProductoCombo()));
    }
    
    
}
