/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.VariablesEstaticas.clasificacion;
import static controlador.VariablesEstaticas.productoID;
import static controlador.VariablesEstaticas.productoSeleccionado;
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
import vista.formulariosbebidas.jIntBebidasCalientes;

/**
 * Esta clase listara el producto de bebidas calientes y se encargara
 * de que el ususario seleccione el tipo de bebida caliente que decea el cliente. 
 * 
 * @author FutureBurguer.
 */
public class BebidasCalienteControlador implements ActionListener {

    //ArrayList para productos
    ArrayList<Productos> listaProducto = new ArrayList<>();

    //Frames a utilizar para el formulario
    jIntBebidasCalientes bebidaCaliente = new jIntBebidasCalientes();
    JintDescripcionProducto producto = new JintDescripcionProducto();

    //Dao
    DaoProductos dao = new DaoProductos();

    private List<JButton> listaC = new ArrayList();
    private int clasificacionProd;
    private String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\bebidas\\bebidascalientes\\";

    public BebidasCalienteControlador(jIntBebidasCalientes bebidaCaliente) {
        this.bebidaCaliente = bebidaCaliente;
        crearBebidasCalientes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        productoID = 0;
        clasificacion = 0;
        if (e.getSource() == listaC.get(0)) {
            productoSeleccionado = listaProducto.get(0);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }

        if (e.getSource() == listaC.get(1)) {
            productoSeleccionado = listaProducto.get(1);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion = productoSeleccionado.getClasificacion_id();
            principal.EscritorioPrincipal.add(producto);
            producto.setVisible(true);
            producto.setLocation(320, 105);
            producto.setSize(1500, 750);
        }

        View_productosTamaniosControlador controlador = new View_productosTamaniosControlador(producto);
    }

    public void crearBebidasCalientes() {
        listaProducto.clear();
        clasificacionProd = 1003;
        for (Productos producto : dao.verProductos(clasificacionProd)) {
            JButton boton = new JButton(producto.getProductonombre());

            listaProducto.add(producto);

            ImageIcon bebidasImg = new ImageIcon(ruta + producto.getImagen());
            ImageIcon bebidasImgRed = new ImageIcon(bebidasImg.getImage().getScaledInstance(150, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(bebidasImgRed);
            boton.addActionListener(this);
            bebidaCaliente.add(boton);
            listaC.add(boton);
        }
    }
}
