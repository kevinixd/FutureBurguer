/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.clasificacion;
import static controlador.ProductoSeleccionado.productoID;
import static controlador.PrincipalControlador.principal;
import static controlador.ProductoSeleccionado.productoSeleccionado;
import dao.DaoProductos;
import dao.DaoView_DetalleCombo;
import dao.DaoView_ProductosTamanios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Productos;
import modelo.ProductosTamanios;
import modelo.View_Descripcioncombo;
import modelo.View_productosTamanios;
import vista.JintOpcion;

import vista.formularioshamburguesas.jIntHamburguesas;
import vista.JintDescripcionCombo;

/**
 *
 * @author javam2019
 */
public class HamburguesasControlador implements ActionListener {

    //Array para productos
    ArrayList<Productos> listaProducto = new ArrayList<>();

    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    JintOpcion opcion = new JintOpcion();

    DaoProductos dao = new DaoProductos();

    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\hamburguesas\\";

    private List<JButton> lista = new ArrayList();
    private int clasificacionProducto;

    public HamburguesasControlador(jIntHamburguesas hamburguesas) {
        this.hamburguesas = hamburguesas;
        crearHamburguesas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        productoID = 0;
        clasificacion = 0;
        if (e.getSource() == lista.get(0)) {
            productoSeleccionado = listaProducto.get(0);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }

        if (e.getSource() == lista.get(1)) {
            productoSeleccionado = listaProducto.get(1);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }

        if (e.getSource() == lista.get(2)) {
            productoSeleccionado = listaProducto.get(2);
            productoID = productoSeleccionado.getProducto_id();
            JOptionPane.showMessageDialog(principal, productoID);
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }

        if (e.getSource() == lista.get(3)) {
            productoSeleccionado = listaProducto.get(3);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }
        OpcionesControlador controlador = new OpcionesControlador(opcion);

    }

    public void crearHamburguesas() {
        listaProducto.clear();
        clasificacionProducto = 1001;
        for (Productos producto : dao.verProductos(clasificacionProducto)) {

            //agregar cada producto al array list del producto
            listaProducto.add(producto);

            //Asignar nombre a los botones
            JButton boton = new JButton(producto.getProductonombre());

            //Asignar imagen a los botones
            ImageIcon icono = new ImageIcon(rutaProducto + producto.getImagen());
            ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(iconoRed);
            boton.addActionListener(this);
            hamburguesas.add(boton);
            lista.add(boton);
        }
    }
}
