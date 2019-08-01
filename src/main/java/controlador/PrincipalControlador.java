/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.DetallePedido;
import modelo.Productos;
import vista.JfrmPrincipal;
import vista.jPnlBebidas;
import vista.jPnlBebidasFrias;
import vista.jPnlComboIndividual;
import vista.jPnlHamburguesas;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    //Daos a utilizar
    DaoProductos dao1= new DaoProductos();
    
    //ArrayList para botones
    private List<JButton> lista;
    private int indice;
    
    
    public static JfrmPrincipal principal = new JfrmPrincipal();
    jPnlHamburguesas hamburguesa = new jPnlHamburguesas();
    jPnlComboIndividual comboIndividual = new jPnlComboIndividual();
    jPnlBebidas bebida = new jPnlBebidas();
    jPnlBebidasFrias bebidaFria = new jPnlBebidasFrias();

    //Ruta para las imagenes
    String ruta = System.getProperty("user.dir");
    //para saber llevar el control de la solicitud del cliente
    DetallePedido detPedido;
    
    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        imgPrincipal();
        principal.jBtnCombos.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);
        hamburguesa.jBtnHamburguesa1.addActionListener(this);
        hamburguesa.jBtnHamburguesa2.addActionListener(this); 
        detPedido = new DetallePedido();
        lista= new ArrayList<>();
        indice=0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            crearCombos();

        }
        if (e.getSource() == principal.jBtnBebidas) {
            crearBebidas();
        }

        if (e.getSource() == hamburguesa.jBtnHamburguesa1) {
            crearComboIndividual();
            comboIndividual.jBtnCombo.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
            comboIndividual.jBtnIndividual.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h1.png"));
            //establecer el codigo de la hamburguesa
            detPedido.setProducto_tamaño_id(1);
            
        }
        
        if (e.getSource() == hamburguesa.jBtnHamburguesa2) {
            crearComboIndividual();
            comboIndividual.jBtnCombo.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
            comboIndividual.jBtnIndividual.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h2.png"));
        }
        
    }

    public void crearCombos() {
        short clasificacion=1001;
        for (Productos product : dao1.verProductos(clasificacion)) {
            JButton boton= new JButton(product.getProductonombre());
            String ruta=System.getProperty("user.dir") + "\\src\\main\\java\\img\\Hamburguesas\\";
            boton.setIcon(new ImageIcon(ruta + "combo.png"));
            principal.jPnlMenus.add(boton);
            lista.add(boton);
            principal.jPnlMenus.updateUI();
        }
        /*principal.jPnlMenus.removeAll();
        principal.jPnlMenus.add(hamburguesa);
        //imgPanelCombos();
        hamburguesa.setSize(910, 550);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();*/
    }

    public void crearBebidas() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.add(bebida);
        imgPanelBebidas();
        bebida.setSize(910, 550);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();
    }

    public void crearComboIndividual() {
        principal.jPnlMenus.removeAll();
        principal.jPnlMenus.add(comboIndividual);
        comboIndividual.setSize(910, 550);
        principal.jPnlMenus.revalidate();
        principal.jPnlMenus.repaint();
    }

    /*
    *Método para asignar imagenes a cada boton
     */
    public void imgPrincipal() {

        principal.jBtnCombos.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Bebidas\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Postres\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Snacks\\snacks.png"));
    }

    public void imgPanelCombos() {
        hamburguesa.jBtnHamburguesa1.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h1.png"));
        hamburguesa.jBtnHamburguesa2.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h2.png"));
    }

    public void imgPanelBebidas() {
        bebida.jBtnCalientes.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Bebidas\\bebidacaliente.png"));
        bebida.jBtnFrias.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Bebidas\\bebidas.png"));
    }
}