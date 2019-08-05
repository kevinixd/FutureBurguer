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
import vista.jIntComboIndividualHamburguesas;
import vista.jIntHamburguesas;

/**
 *
 * @author javam2019
 */
public class HamburguesasControlador implements ActionListener {

    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    jIntComboIndividualHamburguesas comboIndividual = new jIntComboIndividualHamburguesas();
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
        hamburguesas.removeAll();
        hamburguesas = null;
        if (e.getSource() == lista.get(0)) {
            comboIndividual = new jIntComboIndividualHamburguesas();
            principal.jPnlMenus.add(comboIndividual);
            comboIndividual.setSize(910, 550);
            comboIndividual.setVisible(true);
            

        }
        if (e.getSource() == lista.get(1)) {
            JOptionPane.showMessageDialog(principal, "bhjbhjbhjbh");
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
            principal.jPnlMenus.updateUI();

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
