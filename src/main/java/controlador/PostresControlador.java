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
import vista.formulariospostres.jIntPostres;

/**
 *
 * @author javam2019
 */
public class PostresControlador implements ActionListener{

    jIntPostres postres = new jIntPostres();
    DaoProductos dao = new DaoProductos();
    private List<JButton> listaPostres = new ArrayList();
    private short clasificacion;

    public PostresControlador(jIntPostres postres) {
        this.postres = postres;
        crearPostres();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void crearPostres(){
        clasificacion = 1004;
        
        for (Productos producto : dao.verProductos(clasificacion)) {
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\postres\\";
            boton.setIcon(new ImageIcon(ruta + producto.getImagen()));
            boton.addActionListener(this);
            postres.add(boton);
            listaPostres.add(boton);
        }
    }
}
