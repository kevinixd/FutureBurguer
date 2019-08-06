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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Productos;
import vista.formularioshamburguesas.jIntCIH1;
import vista.formularioshamburguesas.jIntCIH2;
import vista.formularioshamburguesas.jIntCIH3;
import vista.formularioshamburguesas.jIntCIH4;
import vista.formularioshamburguesas.jIntHamburguesas;

/**
 *
 * @author javam2019
 */
public class HamburguesasControlador implements ActionListener {

    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    jIntCIH1 comboInd1 = new jIntCIH1();
    jIntCIH2 comboInd2 = new jIntCIH2();
    jIntCIH3 comboInd3 = new jIntCIH3();
    jIntCIH4 comboInd4 = new jIntCIH4();
    DaoProductos dao = new DaoProductos();
    private List<JButton> lista = new ArrayList();
    private short clasificacion;
    // Ruta para imagenes
    String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\hamburguesas\\";

    public HamburguesasControlador(jIntHamburguesas hamburguesas) {
        this.hamburguesas = hamburguesas;
        crearHamburguesas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        hamburguesas = null;
        if (e.getSource() == lista.get(0)) {
            comboInd1 = new jIntCIH1();
            principal.EscritorioPrincipal.add(comboInd1);
            comboInd1.setLocation(300, 100);
            comboInd1.setSize(910, 550);
            comboInd1.setVisible(true);
            comboInd1.jBtnCH1.setIcon(new ImageIcon(ruta + "combo.png"));
            comboInd1.jBtnIH1.setIcon(new ImageIcon(ruta + "2001.png"));
        }
        if (e.getSource() == lista.get(1)) {
            comboInd2 = new jIntCIH2();
            principal.EscritorioPrincipal.add(comboInd2);
            comboInd2.setLocation(300, 100);
            comboInd2.setSize(910, 550);
            comboInd2.setVisible(true);
            comboInd2.jBtnCH2.setIcon(new ImageIcon(ruta + "combo.png"));
            comboInd2.jBtnIH2.setIcon(new ImageIcon(ruta + "2002.png"));
        }
        if (e.getSource() == lista.get(2)) {
            comboInd3 = new jIntCIH3();
            principal.EscritorioPrincipal.add(comboInd3);
            comboInd3.setLocation(300, 100);
            comboInd3.setSize(910, 550);
            comboInd3.setVisible(true);
            comboInd3.jBtnCH3.setIcon(new ImageIcon(ruta + "combo.png"));
            comboInd3.jBtnIH3.setIcon(new ImageIcon(ruta + "2003.png"));
        }
        if (e.getSource() == lista.get(3)) {
            comboInd4 = new jIntCIH4();
            principal.EscritorioPrincipal.add(comboInd4);
            comboInd4.setLocation(300, 100);
            comboInd4.setSize(910, 550);
            comboInd4.setVisible(true);
            comboInd4.jBtnCH4.setIcon(new ImageIcon(ruta + "combo.png"));
            comboInd4.jBtnIH4.setIcon(new ImageIcon(ruta + "2004.png"));
        }
    }

    public void crearHamburguesas() {

        clasificacion = 1001;
        for (Productos producto : dao.verProductos(clasificacion)) {
            
            JButton boton = new JButton(producto.getProductonombre());
            boton.setIcon(new ImageIcon(ruta + producto.getImagen()));
            boton.addActionListener(this);
            hamburguesas.add(boton);
            lista.add(boton);
            //principal.jPnlMenus.updateUI();

        }
    }

    /*
    public void crearComboIndividual() {
       
       for (int i = 0; i < 2; i++) {
            JButton individual = new JButton("Individual");
            individual.setIcon(new ImageIcon(ruta + "individual.png"));
            individual.addActionListener(this);
            hamburguesas.add(individual);
            principal.jPnlMenus.updateUI();
       }
    }
     */
}