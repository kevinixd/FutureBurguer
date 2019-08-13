/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ProductoSeleccionado.productoSeleccionado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import modelo.DetallePedido;
import modelo.Productos;
import vista.JfrmPrincipal;

import vista.formulariosbebidas.jIntBebidasFC;

import vista.formulariosdesayunos.jIntDesayunos;
import vista.formularioshamburguesas.jIntHamburguesas;
import vista.formulariospostres.jIntPostres;
import vista.formulariossnacks.jIntSnacks;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    jIntDesayunos desayunos = new jIntDesayunos();
    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    jIntBebidasFC bebidasfc = new jIntBebidasFC();
    jIntPostres postres = new jIntPostres();
    jIntSnacks snacks = new jIntSnacks();
    
    
    public static JfrmPrincipal principal = new JfrmPrincipal();

    //Ruta para las imagenes
    String ruta = System.getProperty("user.dir");

    //para saber llevar el control de la solicitud del cliente
    DetallePedido detPedido;

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        imgPrincipal();
        setActionListeners();
        detPedido = new DetallePedido();
        principal.setLocationRelativeTo(null);
    }

    public void setActionListeners() {
        //Botones Principal
        principal.jBtnDesayunos.addActionListener(this);
        principal.jBtnHamburguesas.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);
        principal.jBtnPostres.addActionListener(this);
        principal.jBtnSnacks.addActionListener(this);

        //Botones panel principal
        detPedido = new DetallePedido();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        destruirInternal();

        if (e.getSource() == principal.jBtnDesayunos) {
            desayunos = new jIntDesayunos();
            DesayunosControlador dc;
            principal.EscritorioPrincipal.add(desayunos);
            desayunos.setLocation(300, 100);
            desayunos.setSize(910, 550);
            desayunos.setVisible(true);
            dc = new DesayunosControlador(desayunos);
        }

        if (e.getSource() == principal.jBtnHamburguesas) {
            hamburguesas = new jIntHamburguesas();
            HamburguesasControlador hc;
            principal.EscritorioPrincipal.add(hamburguesas);
            hamburguesas.setLocation(300, 100);
            hamburguesas.setSize(910, 550);
            hamburguesas.setVisible(true);
            hc = new HamburguesasControlador(hamburguesas);
        }

        if (e.getSource() == principal.jBtnBebidas) {

            bebidasfc = new jIntBebidasFC();
            BebidasFCControlador bc;
            principal.EscritorioPrincipal.add(bebidasfc);
            bebidasfc.setLocation(300, 100);
            bebidasfc.setSize(910, 550);
            bebidasfc.setVisible(true);
            bebidasfc.jBtnBF.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidasfrias\\bebidas.png"));
            bebidasfc.jBtnBC.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidascalientes\\bebidaCaliente.png"));
            bc = new BebidasFCControlador(bebidasfc);
        }
        
        if (e.getSource() == principal.jBtnPostres) {
            
            postres = new jIntPostres();
            PostresControlador pc;
            principal.EscritorioPrincipal.add(postres);
            postres.setLocation(300, 100);
            postres.setSize(910, 550);
            postres.setVisible(true);
            pc = new PostresControlador(postres);
        }
        
        if (e.getSource() == principal.jBtnSnacks) {
            
            snacks = new jIntSnacks();
            SnacksControlador sc;
            principal.EscritorioPrincipal.add(snacks);
            snacks.setLocation(300, 100);
            snacks.setSize(910, 550);
            snacks.setVisible(true);
            sc = new SnacksControlador(snacks);
        }
    }

    public void destruirInternal() {
        desayunos = null;
        hamburguesas = null;
        bebidasfc = null;
        postres = null;
        snacks = null;
    }

    /*
    *Método para asignar imagenes a cada boton
     */
    public void imgPrincipal() {

        principal.jBtnDesayunos.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\desayunos\\desayunoprincipal.png"));
        principal.jBtnHamburguesas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\hamburguesas\\comboprincipal.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\postres\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\snacks\\snacks.png"));
    }

}
