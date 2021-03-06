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
import vista.formulariossnacks.jIntSnacks;

/**
 * Esta clase el usuario va seleccionar que tipo de sancks decea ordenar el
 * cliente.
 *
 * @author futureburguer.
 */
public class SnacksControlador implements ActionListener {

    //Array para utilizar
    ArrayList<Productos> listaProducto = new ArrayList();

    //Frames a utilizar
    jIntSnacks snacks = new jIntSnacks();
    JintDescripcionProducto producto = new JintDescripcionProducto();

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();

    private List<JButton> listaSnacks = new ArrayList();
    private int clasificacionSnack;
    private String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\snacks\\";

    public SnacksControlador(jIntSnacks snacks) {
        this.snacks = snacks;
        crearSnacks();
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        productoID = 0;
        clasificacion = 0;

        if (e.getSource() == listaSnacks.get(0)) {
            //Asignamos al arraylist los valores obtenidos en la posición cero
            productoSeleccionado = listaProducto.get(0);

            //Se le asigna a nuestra variable estatica el valor del productoID que se seleccionó
            productoID = productoSeleccionado.getProducto_id();

            //Se le asigna a nuestra variable estatica el valor de la clasificación que se seleccionó
            clasificacion = productoSeleccionado.getClasificacion_id();

        }

        if (e.getSource() == listaSnacks.get(1)) {

            //Asignamos al arraylist los valores obtenidos en la posición cero
            productoSeleccionado = listaProducto.get(1);

            //Se le asigna a nuestra variable estatica el valor del productoID que se seleccionó
            productoID = productoSeleccionado.getProducto_id();

            //Se le asigna a nuestra variable estatica el valor de la clasificación que se seleccionó
            clasificacion = productoSeleccionado.getClasificacion_id();
        }

        principal.EscritorioPrincipal.add(producto);
        producto.setVisible(true);
        producto.setLocation(320, 105);
        producto.setSize(1500, 750);
        View_productosTamaniosControlador controlador = new View_productosTamaniosControlador(producto);
    }

    /**
     * Metodo para crear los botones correspondientes a la categoria de snacks
     */
    public void crearSnacks() {
        listaProducto.clear();
        clasificacionSnack = 1005;

        for (Productos producto : dao.verProductos(clasificacionSnack)) {
            JButton boton = new JButton(producto.getProductonombre());

            listaProducto.add(producto);

            ImageIcon snackImg = new ImageIcon(ruta + producto.getImagen());

            ImageIcon snackImgRed = new ImageIcon(snackImg.getImage().getScaledInstance(150, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(snackImgRed);
            boton.addActionListener(this);
            snacks.add(boton);
            listaSnacks.add(boton);
        }
    }
}
