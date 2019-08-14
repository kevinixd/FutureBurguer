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
import vista.formularioshamburguesas.jIntCIH1;

import vista.formularioshamburguesas.jIntHamburguesas;
import vista.formularioshamburguesas.JintOrdenarH1;

/**
 *
 * @author javam2019
 */
public class HamburguesasControlador implements ActionListener {

    //Array para productos
    ArrayList<Productos> listaProducto = new ArrayList<>();

    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    jIntCIH1 comboInd1 = new jIntCIH1();

    
    DaoProductos dao = new DaoProductos();
    DaoView_DetalleCombo dao2 = new DaoView_DetalleCombo();
    DaoView_ProductosTamanios dao3 = new DaoView_ProductosTamanios();
    DaoView_DetalleCombo dao4 = new DaoView_DetalleCombo();
    
    View_productosTamanios producTamanios = new View_productosTamanios();
    View_Descripcioncombo descripcion = new View_Descripcioncombo();
    
    private List<JButton> lista = new ArrayList();
    private short clasificacion;
    private int productoId;
    // Ruta para imagenes
    private String rutaProducto = System.getProperty("user.dir") + "\\src\\main\\java\\img\\hamburguesas\\";
    private String rutaCombo = System.getProperty("user.dir") + "\\src\\main\\java\\img\\combos\\";

    public HamburguesasControlador(jIntHamburguesas hamburguesas) {
        System.out.println("LLego al controlador Hamburguesas");

        this.hamburguesas = hamburguesas;
        comboInd1.jBtnCH1.addActionListener(this);
        crearHamburguesas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        hamburguesas = null;
        if (e.getSource() == lista.get(0)) {
            HamburguesaComboControlador hcontrolador = new HamburguesaComboControlador(comboInd1);
            principal.EscritorioPrincipal.add(comboInd1);
            comboInd1.setLocation(300, 100);
            comboInd1.setSize(910, 550);
            comboInd1.setVisible(true);
            productoSeleccionado = listaProducto.get(0);
            productoId = productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
        }
        
        if (e.getSource() == lista.get(1)) {
            HamburguesaComboControlador hcontrolador = new HamburguesaComboControlador(comboInd1);
            principal.EscritorioPrincipal.add(comboInd1);
            comboInd1.setLocation(300, 100);
            comboInd1.setSize(910, 550);
            comboInd1.setVisible(true);
            productoSeleccionado = listaProducto.get(1);
            productoId = productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
        }
        
        if (e.getSource() == lista.get(2)) {
            HamburguesaComboControlador hcontrolador = new HamburguesaComboControlador(comboInd1);
            principal.EscritorioPrincipal.add(comboInd1);
            comboInd1.setLocation(300, 100);
            comboInd1.setSize(910, 550);
            comboInd1.setVisible(true);
            productoSeleccionado = listaProducto.get(2);
            productoId = productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
        }
        
        if (e.getSource() == lista.get(3)) {
            HamburguesaComboControlador hcontrolador = new HamburguesaComboControlador(comboInd1);
            principal.EscritorioPrincipal.add(comboInd1);
            comboInd1.setLocation(300, 100);
            comboInd1.setSize(910, 550);
            comboInd1.setVisible(true);
            productoSeleccionado = listaProducto.get(3);
            productoId = productoSeleccionado.getProducto_id();
            asignarProducto();
            asignarCombo();
        }

    }

    public void crearHamburguesas() {
        listaProducto.clear();
        clasificacion = 1001;
        for (Productos producto : dao.verProductos(clasificacion)) {
            //agregar cada producto al array list del producto
            listaProducto.add(producto);

            JButton boton = new JButton(producto.getProductonombre());
       
            ImageIcon icono= new ImageIcon(rutaProducto + producto.getImagen());
            
            ImageIcon iconoRed= new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            boton.setIcon(iconoRed);
            boton.addActionListener(this);
            hamburguesas.add(boton);
            lista.add(boton);
            //principal.jPnlMenus.updateUI();

        }
    }
    
    //Metodo para asignar imagen de individual a los botones
    public void asignarProducto() {
        producTamanios = dao3.verProductoDetalle(productoId);
        ImageIcon icono = new ImageIcon(rutaProducto + producTamanios.getProductoImgView());
        ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
        comboInd1.jBtnIH1.setIcon(iconoRed);
    }
    
    public void asignarCombo() {
        
        descripcion = dao4.verImagenCombo(productoId);
        if (descripcion.getImagenDetalleCombo() != null) {
            ImageIcon icono = new ImageIcon(rutaCombo + descripcion.getImagenDetalleCombo());
            ImageIcon iconoRed = new ImageIcon(icono.getImage().getScaledInstance(110, -1, java.awt.Image.SCALE_DEFAULT));
            comboInd1.jBtnCH1.setIcon(iconoRed);
            System.out.println("Exito");
        } else {
            comboInd1.jBtnCH1.setVisible(false);
            comboInd1.jLblCH1.setVisible(false);
            comboInd1.jLblPrecioC1.setVisible(false);
            comboInd1.jLblIH1.setBounds(100, 100, 74, 21);
            comboInd1.jLblPrecioI1.setBounds(100, 100, 78, 25);
        }
    }
}
