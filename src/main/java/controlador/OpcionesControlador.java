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
    JintOpcion opcion = new JintOpcion();
    JintDescripcionCombo combo = new JintDescripcionCombo();
    JintDescripcionProducto producto = new JintDescripcionProducto();

    //Modelos a utilizar:
    View_productosTamanios producTamanios = new View_productosTamanios();
    View_Descripcioncombo descripcion = new View_Descripcioncombo();

    //Daos a utilizar
    DaoView_ProductosTamanios dao3 = new DaoView_ProductosTamanios();
    DaoView_DetalleCombo dao4 = new DaoView_DetalleCombo();

    // Ruta para imagenes
    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\vistaProductos\\";
    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    public OpcionesControlador(JintOpcion opcion) {
        this.opcion = opcion;
        opcion.jBtnCombo.addActionListener(this);
        opcion.jBtnIndividual.addActionListener(this);
        asignarCombo();
        asignarProducto();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == opcion.jBtnCombo) {
            DescripcionComboControlador controlador = new DescripcionComboControlador(combo);
            principal.EscritorioPrincipal.add(combo);
            combo.setVisible(true);
            combo.setLocation(300, 100);
            combo.setSize(910, 550);
        }

        if (e.getSource() == opcion.jBtnIndividual) {
            View_productosTamaniosControlador controladorProductos = new View_productosTamaniosControlador(producto);
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(300, 100);
            producto.setSize(910, 550);
        }
    }

    //Metodo para asignar imagen de individual a los botones
    public void asignarProducto() {
        producTamanios = dao3.verProductoDetalle(productoID);
        ImageIcon icono = new ImageIcon(rutaProducto + producTamanios.getProductoImgView());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
        opcion.jBtnIndividual.setIcon(iconoRed);
    }

    public void asignarCombo() {
        descripcion = dao4.verImagenCombo(productoID);
        if (descripcion.getImagenDetalleCombo() != null) {
            ImageIcon icono = new ImageIcon(rutaCombo + descripcion.getImagenDetalleCombo());
            ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            opcion.jBtnCombo.setIcon(iconoRed);
        } else {
            opcion.jBtnCombo.setVisible(false);
            opcion.jLabelCombo.setVisible(false);
            opcion.JLabelSolo.setBounds(100, 100, 74, 21);
        }
    }

}
