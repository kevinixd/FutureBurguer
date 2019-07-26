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
import vista.jPnlComboIndividual;
import vista.jPnlCombos;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    public static JfrmPrincipal principal = new JfrmPrincipal();
    //menu principal
    private int estado = 0;
    //panel de submentus
    jPnlCombos combos = new jPnlCombos();

    //panel de combo individual
    jPnlComboIndividual combosIndividual = new jPnlComboIndividual();

    jPnlComboIndividual comboIndividual;

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        imagenes();
        principal.jBtnCombos.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            CombosControlador controladorCombos = new CombosControlador(combos, principal);
            crearCombos();

        }
        if (e.getSource() == principal.jBtnBebidas) {

            principal.jPnlMenus.removeAll();
            principal.jPnlMenus.repaint();
            combosIndividual.setSize(910, 550);
            imagenesPanelCombos();
            //cargar el menu de combos
            principal.jPnlMenus.add(combosIndividual);
            principal.jPnlMenus.revalidate();
            principal.jPnlMenus.repaint();
        }
    }

    public void crearCombos() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.repaint();

        combos.setSize(910, 550);
        imagenesPanelCombos();
        //cargar el menu de combos
        principal.jPnlMenus.add(combos);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();
    }

    /*
    *Método para asignar imagenes a cada boton
     */
    public void imagenes() {
        String ruta = System.getProperty("user.dir");
        principal.jBtnCombos.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\snacks.png"));
    }

    public void imagenesPanelCombos() {
        combos.jBtnCombo1.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo2.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo3.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo4.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo5.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo6.setIcon(new ImageIcon("C:\\Users\\javam2019\\Documents\\GitHub\\FutureBurguer\\src\\main\\java\\img\\combos.png"));
    }

}
