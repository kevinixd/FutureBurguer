/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import dao.DaoDescripcionCombo;
import dao.DaoProductos;
import dao.DaoView_DetalleCombo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import modelo.View_Descripcioncombo;
import vista.formularioshamburguesas.jIntCIH1;
import vista.formularioshamburguesas.jIntOrdenarH1;

/**
 *
 * @author javam2019
 */
public class HamburguesaComboControlador implements ActionListener {

    jIntCIH1 comboInd1 = new jIntCIH1();
    jIntOrdenarH1 orden1 = new jIntOrdenarH1();
    View_Descripcioncombo datos = new View_Descripcioncombo();
    
    ArrayList<View_Descripcioncombo> lista = new ArrayList();

    DaoView_DetalleCombo dao = new DaoView_DetalleCombo();
    private short clasificacion;

    String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    public HamburguesaComboControlador(jIntCIH1 comboInd1) {
        this.comboInd1 = comboInd1;
        comboInd1.jBtnCH1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboInd1.jBtnCH1) {
            orden1 = new jIntOrdenarH1();
            principal.EscritorioPrincipal.add(orden1);
            orden1.setLocation(300, 100);
            orden1.setSize(910, 550);
            orden1.setVisible(true);
            cargarCombo1();
        }
    }

    public void cargarCombo1() {
        lista = dao.verProductos(2001);
        orden1.jLblNombreComboH1.setText(lista.get(0).getNombreCombo());
        orden1.jLblImgH1.setIcon(new ImageIcon(ruta + lista.get(0).getImagenDetalleCombo()));
        orden1.jLblNombreH1.setText(lista.get(0).getProductoCombo());
        orden1.jLblPapaH1.setText(lista.get(1).getProductoCombo());
        orden1.jLblBebidaH1.setText(lista.get(2).getProductoCombo());
    }
}
