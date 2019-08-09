/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import vista.formulariossnacks.jIntSnacks;

/**
 *
 * @author javam2019
 */
public class SnacksControlador implements ActionListener{
    
    jIntSnacks snacks = new jIntSnacks();
    DaoProductos dao = new DaoProductos();
    private List<JButton> listaSnacks = new ArrayList();
    private short clasificacion;

    public SnacksControlador(jIntSnacks snacks) {
        this.snacks = snacks;
        crearSnacks();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void crearSnacks(){
        clasificacion = 1005;
        
        for (Productos producto : dao.verProductos(clasificacion)) {
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\snacks\\";
            ImageIcon snackImg=new ImageIcon(ruta + producto.getImagen());
            
            ImageIcon snackImgRed= new ImageIcon(snackImg.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(snackImgRed);
            boton.addActionListener(this);
            snacks.add(boton);
            listaSnacks.add(boton);
        }
    }
}
