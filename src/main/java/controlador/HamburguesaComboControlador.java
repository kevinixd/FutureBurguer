/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import dao.DaoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import vista.formularioshamburguesas.jIntCIH1;
import vista.formularioshamburguesas.jIntOrdenarH1;

/**
 *
 * @author javam2019
 */
public class HamburguesaComboControlador implements ActionListener{

    jIntCIH1 comboInd1 = new jIntCIH1();
    jIntOrdenarH1 orden1 = new jIntOrdenarH1();
    private short clasificacion;
    
    String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\hamburguesas\\";
    
    public HamburguesaComboControlador(jIntCIH1 comboInd1){
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
            orden1.pack();
        }
    }
    
}
