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
import vista.jIntHamburguesas;

/**
 *
 * @author javam2019
 */
public class HamburguesasControlador implements ActionListener {
    
    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    DaoProductos dao = new DaoProductos();
    private List<JButton> lista = new ArrayList();
    private short clasificacion;

    public HamburguesasControlador(jIntHamburguesas hamburguesas) {
        this.hamburguesas = hamburguesas;
        crearHamburguesas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lista.get(0)) {
            JOptionPane.showMessageDialog(principal, "bhbjbh");
        }
        if (e.getSource() == lista.get(1)) {
            JOptionPane.showMessageDialog(principal, "bhjbhjbhjbh");
        }
    }

    public void crearHamburguesas() {
        
        clasificacion = 1001;
        for (Productos producto : dao.verProductos(clasificacion)) {
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\hamburguesas\\";
            System.out.println("Ruta: "+ ruta);
            boton.setIcon(new ImageIcon(ruta + producto.getImagen()));
            boton.addActionListener(this);
            hamburguesas.add(boton);
            lista.add(boton);
            principal.jPnlMenus.updateUI();
            
        }
    }

}
