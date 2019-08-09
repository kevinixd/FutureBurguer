/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import static controlador.ProductoSeleccionado.productoSeleccionado;
import dao.DaoProductos;
import dao.DaoView_DetalleCombo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import vista.formulariosdesayunos.JintDsy;
import vista.formulariosdesayunos.jIntDesayunos;

/**
 *
 * @author javam2019
 */
public class DesayunosControlador implements ActionListener {

    //Array para productos
    ArrayList<Productos> listaProducto = new ArrayList<>();

    //Formularios a utilizar
    jIntDesayunos desayunos = new jIntDesayunos();
    JintDsy opciones = new JintDsy();

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();
    DaoView_DetalleCombo dao2= new DaoView_DetalleCombo();

    private List<JButton> lista2 = new ArrayList();
    private short clasificacion;
    private int productoId;
    

    public DesayunosControlador(jIntDesayunos desayunos) {
        //this.controladorPrincipal=controladorPrincipal;
        this.desayunos = desayunos;
        crearDesayunos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lista2.get(0)) {
            productoSeleccionado = listaProducto.get(0);
            principal.EscritorioPrincipal.add(opciones);
            opciones.setVisible(true);
            opciones.setLocation(300, 100);
            opciones.setSize(910, 550);
            
        }

        if (e.getSource() == lista2.get(1)) {
            productoSeleccionado = listaProducto.get(1);
            System.out.println("Producto: " + productoSeleccionado.toString());
        }

        if (e.getSource() == lista2.get(2)) {
            productoSeleccionado = listaProducto.get(2);
        }

    }

    public void crearDesayunos() {
        listaProducto.clear();
        clasificacion = 1006;

        for (Productos producto : dao.verProductos(clasificacion)) {

            //Agregamos todas las propiedades de producto al ArrayList
            listaProducto.add(producto);
            JButton boton = new JButton(producto.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\desayunos\\";
            ImageIcon desayImg= new ImageIcon(ruta + producto.getImagen());
            
            ImageIcon desayunosRed= new ImageIcon(desayImg.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(desayunosRed);
            boton.addActionListener(this);
            desayunos.add(boton);
            lista2.add(boton);
            //principal.jPnlMenus.updateUI();

        }
    }
    
    public void asignarProducto(){
        
    }

}
