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
import modelo.Productos;
import vista.formulariosbebidas.jIntBebidasFrias;
import vista.formulariosbebidas.jIntDrink1;

//import vista.jIntBebidasFrias;
//import vista.jIntDrink1;

/**
 *
 * @author javam2019
 */
public class BebidasFriasControlador implements ActionListener{
    
    jIntBebidasFrias bebidasFrias = new jIntBebidasFrias();
    jIntDrink1 bebida1 = new jIntDrink1();

    DaoProductos dao = new DaoProductos();
    
    private short clasificacion;
    
    private List<JButton> listaF = new ArrayList();

    public BebidasFriasControlador(jIntBebidasFrias bebidasFrias) {
        this.bebidasFrias = bebidasFrias;
        crearBebidasFrias();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listaF.get(0)) {
            bebida1 = new jIntDrink1();
            principal.EscritorioPrincipal.add(bebida1);
            bebida1.setLocation(300, 100);
            bebida1.setSize(910, 550);
            bebida1.setVisible(true);
        }
        
    }
    
    public void crearBebidasFrias() {

        clasificacion = 1002;
        for (Productos producto : dao.verProductos(clasificacion)) {
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\bebidas\\bebidasfrias\\";
            boton.setIcon(new ImageIcon(ruta + producto.getImagen()));
            boton.addActionListener(this);
            bebidasFrias.add(boton);
            listaF.add(boton);
            //principal.jPnlMenus.updateUI();
        }
    }
    
}
