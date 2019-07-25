/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import vista.JfrmPrincipal;
import vista.jPnlCombos;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    JfrmPrincipal principal = new JfrmPrincipal();
    jPnlCombos combos;

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        imagenes();
        principal.jBtnCombos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            combos = new jPnlCombos();
            combos.setSize(910, 550);
            imagenesPanelCombos();
            principal.jPnlMenus.add(combos);
            principal.jPnlMenus.revalidate();
            principal.jPnlMenus.repaint();
            //principal.jPnlMenus.remove(combos);
        }
    }
    
    /*
    *Método para asignar imagenes a cada boton
    */
    public void imagenes() {
        principal.jBtnCombos.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\snacks.png"));
    }

    public void imagenesPanelCombos(){
        combos.jBtnCombo1.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo2.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo3.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo4.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo5.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo6.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
    }
}
