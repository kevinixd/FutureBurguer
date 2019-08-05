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
import vista.jIntBebidasFrias;

/**
 *
 * @author javam2019
 */
public class BebidasFriasControlador implements ActionListener{
    
    jIntBebidasFrias bebidas = new jIntBebidasFrias();
    DaoProductos dao = new DaoProductos();
    private List<JButton> lista3 = new ArrayList();
    private short clasificacion;

    public BebidasFriasControlador(jIntBebidasFrias bebidas) {
        this.bebidas = bebidas;
        crearBebidas();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void crearBebidas() {
        
        clasificacion = 1002;
        for (Productos producto : dao.verProductos(clasificacion)) {
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\bebidas\\bebidasfrias\\";
            boton.setIcon(new ImageIcon(ruta + producto.getImagen()));
            boton.addActionListener(this);
            bebidas.add(boton);
            lista3.add(boton);
            //principal.jPnlMenus.updateUI();
            
        }
    }
}
