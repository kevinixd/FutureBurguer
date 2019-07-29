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
import vista.jPnlBebidasFrias;
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
    jPnlComboIndividual combosIndividual = new jPnlComboIndividual();
    jPnlBebidasFrias bebidas = new jPnlBebidasFrias();

    //Ruta para las imagenes
    String ruta = System.getProperty("user.dir");

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        imagenes();
        principal.jBtnCombos.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);
        combos.jBtnCombo1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            principal.jPnlMenus.removeAll();
            principal.jPnlMenus.add(combos);
            combos.setSize(910, 550);
            imagenesPanelCombos();
            principal.jPnlMenus.revalidate();
            principal.jPnlMenus.repaint();
        }
        if (e.getSource() == principal.jBtnBebidas) {

            principal.jPnlMenus.removeAll();
            principal.jPnlMenus.repaint();
            bebidas.setSize(910, 550);
            imagenesPanelCombos();
            //cargar el menu de combos
            principal.jPnlMenus.add(bebidas);
            principal.jPnlMenus.revalidate();
            principal.jPnlMenus.repaint();
        }
        if (e.getSource() == combos.jBtnCombo1) {
            principal.jPnlMenus.removeAll();
            principal.jPnlMenus.add(combosIndividual);
            combosIndividual.setSize(910, 550);
            principal.jPnlMenus.revalidate();
            principal.jPnlMenus.repaint();
        }
    }

    public void crearBebidas() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.repaint();
    }

    /*
    *Método para asignar imagenes a cada boton
     */
    public void imagenes() {

        principal.jBtnCombos.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\snacks.png"));
    }

    public void imagenesPanelCombos() {
        combos.jBtnCombo1.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo2.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo3.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo4.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo5.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
        combos.jBtnCombo6.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\combos.png"));
    }

}
