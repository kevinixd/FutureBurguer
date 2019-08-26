/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.PrincipalControlador.principal;
import static controlador.VariablesEstaticas.clasificacion;
import static controlador.VariablesEstaticas.productoID;
import static controlador.VariablesEstaticas.productoSeleccionado;
import dao.DaoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import vista.JintDescripcionProducto;
import vista.formulariospostres.jIntPostres;

/**
 *Esta clase listara el producto postres  y se encargara de que
 * el ususario seleccione el tipo de postre que decea el cliente. 
 * 
 *  @author FutureBurguer.
 */
public class PostresControlador implements ActionListener {

    //Array para los productos
    ArrayList<Productos> listaProductos = new ArrayList<>();

    //Frames a utilizar
    jIntPostres postres = new jIntPostres();
    JintDescripcionProducto producto = new JintDescripcionProducto();

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();

    private List<JButton> listaPostres = new ArrayList();
    private int clasificacionPostre;
    private String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\postres\\";

    public PostresControlador(jIntPostres postres) {
        this.postres = postres;
        crearPostres();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        productoID = 0;
        clasificacion = 0;
        if (e.getSource() == listaPostres.get(0)) {
            productoSeleccionado = listaProductos.get(0);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(1)) {
            productoSeleccionado = listaProductos.get(1);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(2)) {
            productoSeleccionado = listaProductos.get(2);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(3)) {
            productoSeleccionado = listaProductos.get(3);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(4)) {
            productoSeleccionado = listaProductos.get(4);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(5)) {
            productoSeleccionado = listaProductos.get(5);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(6)) {
            productoSeleccionado = listaProductos.get(6);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(7)) {
            productoSeleccionado = listaProductos.get(7);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaPostres.get(8)) {
            productoSeleccionado = listaProductos.get(8);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }

        View_productosTamaniosControlador controlador = new View_productosTamaniosControlador(producto);

    }

    /**
     * Metodo para crear los botones correspondientes a los postres
     */
    public void crearPostres() {
        listaProductos.clear();
        clasificacionPostre = 1004;

        for (Productos producto : dao.verProductos(clasificacionPostre)) {
            JButton boton = new JButton(producto.getProductonombre());

            listaProductos.add(producto);

            ImageIcon postreImg = new ImageIcon(ruta + producto.getImagen());

            ImageIcon postreImgRed = new ImageIcon(postreImg.getImage().getScaledInstance(150, -1, java.awt.Image.SCALE_DEFAULT));

            boton.setIcon(postreImgRed);
            boton.addActionListener(this);
            postres.add(boton);
            listaPostres.add(boton);
        }
    }
}
