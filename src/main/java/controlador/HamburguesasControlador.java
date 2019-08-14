/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    DaoView_ProductosTamanios dao3 = new DaoView_ProductosTamanios();
    DaoView_DetalleCombo dao4 = new DaoView_DetalleCombo();

    //Modelos a utilizar:
    View_productosTamanios producTamanios = new View_productosTamanios();
    View_Descripcioncombo descripcion = new View_Descripcioncombo();
    
    private List<JButton> lista = new ArrayList();
    private short clasificacion;
    // Ruta para imagenes
    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\hamburguesas\\";
    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";
    
    public HamburguesasControlador(jIntHamburguesas hamburguesas) {
        this.hamburguesas = hamburguesas;
        crearHamburguesas();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        productoID=0;
        OpcionesControlador controlador= new OpcionesControlador(opcion);
        if (e.getSource() == lista.get(0)) {
            productoSeleccionado= listaProducto.get(0);
            productoID= productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }
        
        if (e.getSource() == lista.get(1)) {
            productoSeleccionado= listaProducto.get(1);
            productoID= productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }
        
        if (e.getSource() == lista.get(2)) {
            productoSeleccionado= listaProducto.get(2);
            productoID= productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }
        
        if (e.getSource() == lista.get(3)) {
            productoSeleccionado= listaProducto.get(3);
            productoID= productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
            principal.EscritorioPrincipal.add(opcion);
            opcion.setVisible(true);
            opcion.setLocation(300, 100);
            opcion.setSize(910, 550);
        }
        
    }
    
    public void crearHamburguesas() {
        listaProducto.clear();
        clasificacion = 1001;
        for (Productos producto : dao.verProductos(clasificacion)) {

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

    //Metodo para asignar imagen de individual a los botones
    public void asignarProducto() {
        producTamanios = dao3.verProductoDetalle(productoID);
        ImageIcon icono = new ImageIcon(rutaProducto + producTamanios.getProductoImgView());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
        opcion.jBtnIndividual.setIcon(iconoRed);
    }
    
    public void asignarCombo() {
        descripcion = dao4.verImagenCombo(productoID);
        if (descripcion.getImagenDetalleCombo() != null) {
            ImageIcon icono = new ImageIcon(rutaCombo + descripcion.getImagenDetalleCombo());
            ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            opcion.jBtnCombo.setIcon(iconoRed);
            System.out.println("Exito");
        } else {
            opcion.jBtnCombo.setVisible(false);
            opcion.jLabelCombo.setVisible(false);
            opcion.JLabelSolo.setBounds(100, 100, 74, 21);
        }
    }
}
