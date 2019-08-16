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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Productos;
import modelo.View_Descripcioncombo;
import modelo.View_productosTamanios;
import vista.JintOpcion;
import vista.formulariosdesayunos.jIntDesayunos;

/**
 *
 * @author javam2019
 */
public class DesayunosControlador implements ActionListener {

    //Array para productos y combos
    ArrayList<Productos> listaProducto = new ArrayList<>();

    //Formularios a utilizar
    jIntDesayunos desayunos = new jIntDesayunos();
    JintOpcion opciones = new JintOpcion();

    //Daos a utilizar
    DaoProductos dao = new DaoProductos();
    DaoView_DetalleCombo dao2 = new DaoView_DetalleCombo();
    DaoView_ProductosTamanios dao3 = new DaoView_ProductosTamanios();
    DaoView_DetalleCombo dao4 = new DaoView_DetalleCombo();

    //Modelos a utilizar:
    View_productosTamanios producTamanios = new View_productosTamanios();
    View_Descripcioncombo descripcion = new View_Descripcioncombo();

    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\desayunos\\";
    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";
    private List<JButton> lista2 = new ArrayList();
    private int clasificacionProd;
    private Point lugar;

    public DesayunosControlador(jIntDesayunos desayunos) {
        this.desayunos = desayunos;
        crearDesayunos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        productoID = 0;
        OpcionesControlador controlador = new OpcionesControlador(opciones);
        if (e.getSource() == lista2.get(0)) {
            productoSeleccionado = listaProducto.get(0);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion=productoSeleccionado.getClasificacion_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opciones);
            opciones.setVisible(true);
            opciones.setLocation(300, 100);
            opciones.setSize(910, 550);

        }

        if (e.getSource() == lista2.get(1)) {
            productoSeleccionado = listaProducto.get(1);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion=productoSeleccionado.getClasificacion_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opciones);
            opciones.setVisible(true);
            opciones.setLocation(300, 100);
            opciones.setSize(910, 550);

        }

        if (e.getSource() == lista2.get(2)) {
            productoSeleccionado = listaProducto.get(2);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion=productoSeleccionado.getClasificacion_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opciones);
            opciones.setVisible(true);
            opciones.setLocation(300, 100);
            opciones.setSize(910, 550);
        }

        if (e.getSource() == lista2.get(3)) {

            productoSeleccionado = listaProducto.get(3);
            productoID = productoSeleccionado.getProducto_id();
            clasificacion=productoSeleccionado.getClasificacion_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opciones);
            opciones.setVisible(true);
            opciones.setLocation(300, 100);
            opciones.setSize(910, 550);
        }

    }

    /**
     * Metodo para crear los botones para los desayunos y asi mismo asignar al
     * arrayList los valores que cada uno de estos tome
     */
    public void crearDesayunos() {
        listaProducto.clear();
        clasificacionProd = 1006;

        for (Productos producto : dao.verProductos(clasificacionProd)) {

            //Agregamos todas las propiedades de producto al ArrayList
            listaProducto.add(producto);

            //Asignar nombre a los botones
            JButton boton = new JButton(producto.getProductonombre());

            //Asignar imagen a los botones
            ImageIcon desayImg = new ImageIcon(rutaProducto + producto.getImagen());
            ImageIcon desayunosRed = new ImageIcon(desayImg.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(desayunosRed);
            boton.addActionListener(this);
            desayunos.add(boton);
            lista2.add(boton);
        }
    }

    //Metodo para asignar imagen de individual a los botones
    public void asignarProducto() {
        producTamanios = dao3.verProductoDetalle(productoID);
        ImageIcon icono = new ImageIcon(rutaProducto + producTamanios.getProductoImgView());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
        opciones.jBtnIndividual.setIcon(iconoRed);
    }

    //Metodo para asignar imagen de combo a los botones
    public void asignarCombo() {
        descripcion = dao4.verImagenCombo(productoID);
        if (descripcion.getImagenDetalleCombo() != null) {
            ImageIcon icono = new ImageIcon(rutaCombo + descripcion.getImagenDetalleCombo());
            ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            opciones.jBtnCombo.setIcon(iconoRed);
            System.out.println("Exito");
        } else {
            opciones.jBtnCombo.setVisible(false);
            opciones.jLabelCombo.setVisible(false);
            opciones.JLabelSolo.setBounds(100, 100, 74, 21);
        }
    }
}
