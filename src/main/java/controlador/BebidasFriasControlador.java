/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.clasificacion;
import static controlador.ProductoSeleccionado.productoID;
import static controlador.ProductoSeleccionado.productoSeleccionado;
import static controlador.PrincipalControlador.principal;
import dao.DaoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import vista.JintDescripcionProducto;
import vista.formulariosbebidas.jIntBebidasFrias;

/**
 *
 * @author javam2019
 */
public class BebidasFriasControlador implements ActionListener {

    //ArrayList para productos
    ArrayList<Productos> listaProducto = new ArrayList<>();

    jIntBebidasFrias bebidasFrias = new jIntBebidasFrias();
    JintDescripcionProducto producto = new JintDescripcionProducto();

    DaoProductos dao = new DaoProductos();

    private String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\bebidas\\bebidasfrias\\";

    private List<JButton> listaF = new ArrayList();

    private int clasificacionBebid;

    public BebidasFriasControlador(jIntBebidasFrias bebidasFrias) {
        this.bebidasFrias = bebidasFrias;
        crearBebidasFrias();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        productoID = 0;
        clasificacion = 0;
        if (e.getSource() == listaF.get(0)) {
            productoSeleccionado = listaProducto.get(0);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaF.get(1)) {
            productoSeleccionado = listaProducto.get(1);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaF.get(2)) {
            productoSeleccionado = listaProducto.get(2);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaF.get(3)) {
            productoSeleccionado = listaProducto.get(3);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaF.get(4)) {
            productoSeleccionado = listaProducto.get(4);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaF.get(5)) {
            productoSeleccionado = listaProducto.get(5);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        
        if (e.getSource() == listaF.get(6)) {
            productoSeleccionado = listaProducto.get(6);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }
        View_productosTamaniosControlador controlador = new View_productosTamaniosControlador(producto);
    }

    public void crearBebidasFrias() {
        listaProducto.clear();
        clasificacionBebid = 1002;
        for (Productos producto : dao.verProductos(clasificacionBebid)) {
            JButton boton = new JButton(producto.getProductonombre());

            listaProducto.add(producto);

            ImageIcon icono = new ImageIcon(ruta + producto.getImagen());
            ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(150, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(iconoRed);
            boton.addActionListener(this);
            bebidasFrias.add(boton);
            listaF.add(boton);
        }
    }

}
