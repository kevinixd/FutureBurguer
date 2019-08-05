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
import vista.jIntDesayunos;

/**
 *
 * @author javam2019
 */
public class DesayunosControlador implements ActionListener{
    
    jIntDesayunos desayunos = new jIntDesayunos();
    DaoProductos dao = new DaoProductos();
    private List<JButton> lista2 = new ArrayList();
    private short clasificacion;

    public DesayunosControlador(jIntDesayunos desayunos) {
        this.desayunos = desayunos;
        crearDesayunos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("hola");
    }
    
    public void crearDesayunos(){
        
        clasificacion = 1006;
       
        for (Productos producto : dao.verProductos(clasificacion)) {
           
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\desayunos\\";
            System.out.println("Ruta: "+ ruta);
            boton.setIcon(new ImageIcon(ruta + producto.getImagen()));
            boton.addActionListener(this);
            desayunos.add(boton);
            lista2.add(boton);
            principal.jPnlMenus.updateUI();
            
            
        }
    }
    
}
