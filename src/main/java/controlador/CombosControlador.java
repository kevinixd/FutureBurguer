/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import vista.JfrmPrincipal;
import vista.jPnlComboIndividual;
import vista.jPnlCombos;

/**
 *
 * @author javam2019
 */
public class CombosControlador implements ActionListener{

    jPnlCombos combos;
    //elemento a mostrar al seleccionar un combo
    jPnlComboIndividual comboIndividual;
    PrincipalControlador controlador;

    //obtener caracteristicas de controlador principal
    JfrmPrincipal principal;

    public CombosControlador(jPnlCombos combos, JfrmPrincipal principal) {
        this.combos = combos;
        combos.jBtnCombo1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combos.jBtnCombo1) {
            System.out.println("Exito");

            //principal = new JfrmPrincipal();
            //combos = new jPnlCombos();
            principal.jPnlMenus.removeAll();
            principal.jPnlMenus.repaint();

            //comboIndividual = new jPnlComboIndividual();
//            comboIndividual.setSize(910,550);
//            imagenesPanelComboIndividual();
//            principal.jPnlMenus.add(comboIndividual);
//            principal.jPnlMenus.revalidate();
//            principal.jPnlMenus.repaint();
        }
    }

    public void imagenesPanelComboIndividual() {
        comboIndividual.jBtnCombo.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        comboIndividual.jBtnIndividual.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\individual.png"));
    }

}
