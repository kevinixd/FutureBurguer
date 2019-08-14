/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import static controlador.ProductoSeleccionado.productoSeleccionado;
import dao.DaoProductos;
import dao.DaoView_DetalleCombo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.Productos;
import modelo.View_Descripcioncombo;
import vista.formularioshamburguesas.JintOrdenarH1;
import vista.formularioshamburguesas.jIntCIH1;

/**
 *
 * @author javam2019
 */
public class HamburguesaComboControlador implements ActionListener {

    //Formularios a utilizar
    jIntCIH1 comboInd1 = new jIntCIH1();
    JintOrdenarH1 orden1= new JintOrdenarH1();

    //Modelos a utilizar
    View_Descripcioncombo datos = new View_Descripcioncombo();
    View_Descripcioncombo valor = new View_Descripcioncombo();
    
    ArrayList<View_Descripcioncombo> lista = new ArrayList();
    ArrayList<Productos> listaProducto = new ArrayList<>();

    //Dao
    DaoView_DetalleCombo dao = new DaoView_DetalleCombo();
    DaoProductos dao2= new DaoProductos();

    //Combos
    DefaultComboBoxModel bebidas= new DefaultComboBoxModel();
    
    private short clasificacion;

    String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    public HamburguesaComboControlador(jIntCIH1 comboInd1) {
        this.comboInd1 = comboInd1;
        comboInd1.jBtnCH1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboInd1.jBtnCH1) {
            orden1 = new JintOrdenarH1();
            principal.EscritorioPrincipal.add(orden1);
            orden1.setLocation(300, 100);
            orden1.setSize(910, 550);
            orden1.setVisible(true);
            cargarCombo1();


            if (productoSeleccionado == listaProducto.get(0)) {
                cargarCombo1();
            } else if (productoSeleccionado == listaProducto.get(1)) {
                cargarCombo2();
            }
            System.out.println("Jupiter");
        }
    }

    /**
     * Se obtiene los datos del combo seleccionado y la lista obtiene las
     * posiciones de la consulta
     */
    public void cargarCombo1() {
        lista = dao.verProductos(2001);
        orden1.jLblNombreCombo.setText(lista.get(0).getNombreCombo());
        ImageIcon icono = new ImageIcon(ruta + lista.get(0).getImagenDetalleCombo());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
        orden1.jLblImgCombo.setIcon(iconoRed);
        cargarBebidas();
        orden1.jLblNombreCombo.setText(lista.get(0).getProductoCombo());
        orden1.jLblSnackCombo.setText(lista.get(1).getProductoCombo());
        orden1.jLblPrecioCombo.setText("Q47.00");
        principal.EscritorioPrincipal.add(orden1);
        orden1.setLocation(300, 100);
        orden1.setSize(910, 550);
        orden1.setVisible(true);
    }

    public void cargarCombo2() {
        lista = dao.verProductos(2002);
        orden1.jLblNombreCombo.setText(lista.get(0).getNombreCombo());
        orden1.jLblImgCombo.setIcon(new ImageIcon(ruta + lista.get(0).getImagenDetalleCombo()));
        orden1.jLblNombreCombo.setText(lista.get(0).getProductoCombo());
        orden1.jLblSnackCombo.setText(lista.get(1).getProductoCombo());
        cargarBebidas();
        orden1.jLblPrecioCombo.setText("Q50.00");
        principal.EscritorioPrincipal.add(orden1);
        orden1.setLocation(300, 100);
        orden1.setSize(910, 550);
        orden1.setVisible(true);
    }

    public void cargarBebidas() {
        for (Productos producto : dao2.verBebidas()) {
            bebidas.addElement(producto.getProductonombre());
        }
        orden1.jCmbBebida.setModel(bebidas);
    }
}
