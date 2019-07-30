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
import vista.jPnlBebidas;
import vista.jPnlBebidasFrias;
import vista.jPnlComboIndividual;
import vista.jPnlHamburguesas;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    public static JfrmPrincipal principal = new JfrmPrincipal();
    jPnlHamburguesas hamburguesa = new jPnlHamburguesas();
    jPnlComboIndividual comboIndividual = new jPnlComboIndividual();
    jPnlBebidas bebida = new jPnlBebidas();
    jPnlBebidasFrias bebidaFria = new jPnlBebidasFrias();

    //Ruta para las imagenes
    String ruta = System.getProperty("user.dir");

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        imgPrincipal();
        principal.jBtnCombos.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);
        hamburguesa.jBtnCombo1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            crearCombos();
            
        }
        if (e.getSource() == principal.jBtnBebidas) {
            crearBebidas();
        }
        
        if (e.getSource() == hamburguesa.jBtnCombo1) {
            crearComboIndividual();
        }
    }

    public void crearCombos() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.add(hamburguesa);
        imgPanelCombos();
        hamburguesa.setSize(910, 550);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();
    }

    public void crearBebidas() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.add(bebida);
        imgPanelBebidas();
        bebida.setSize(910, 550);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();
    }

    public void crearComboIndividual() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.add(comboIndividual);
        imgPanelComboIndividual();
        comboIndividual.setSize(910, 550);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();
    }

    /*
    *Método para asignar imagenes a cada boton
     */
    public void imgPrincipal() {

        principal.jBtnCombos.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Bebidas\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Postres\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Snacks\\snacks.png"));
    }

    public void imgPanelCombos() {
        hamburguesa.jBtnCombo1.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h1.png"));
        hamburguesa.jBtnCombo2.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h2.png"));
        hamburguesa.jBtnCombo3.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h3.png"));
        hamburguesa.jBtnCombo4.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h4.png"));
        hamburguesa.jBtnCombo5.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h5.png"));
        hamburguesa.jBtnCombo6.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h6.png"));
    }
    
    public void imgPanelBebidas(){
        bebida.jBtnCalientes.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Bebidas\\bebidacaliente.png"));
        bebida.jBtnFrias.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Bebidas\\bebidas.png"));
    }
    
    public void imgPanelComboIndividual(){
        comboIndividual.jBtnCombo.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
        comboIndividual.jBtnIndividual.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\individual.png"));
    }
}
