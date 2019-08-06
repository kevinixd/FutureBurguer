/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import modelo.DetallePedido;
import vista.JfrmPrincipal;

import vista.formulariosbebidas.jIntBebidasFC;

import vista.formulariosdesayunos.jIntDesayunos;
import vista.formularioshamburguesas.jIntHamburguesas;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    jIntDesayunos desayunos = new jIntDesayunos();
    jIntHamburguesas hamburguesas = new jIntHamburguesas();
    jIntBebidasFC bebidasfc = new jIntBebidasFC();

    public static JfrmPrincipal principal = new JfrmPrincipal();

    //Ruta para las imagenes
    String ruta = System.getProperty("user.dir");

    //para saber llevar el control de la solicitud del cliente
    DetallePedido detPedido;

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        principal.setExtendedState(6);
        imgPrincipal();
        setActionListeners();
        detPedido = new DetallePedido();
    }

    public void setActionListeners() {
        //Botones Principal
        principal.jBtnDesayunos.addActionListener(this);
        principal.jBtnHamburguesas.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);

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
            bebidasfc.jBtnBC.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidascalientes\\2015.png"));
            bc = new BebidasFCControlador(bebidasfc);
        }

        /*if (e.getSource() == hamburguesa.jBtnHamburguesa1) {
            crearComboIndividual();
            comboIndividual.jBtnCombo.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
            comboIndividual.jBtnIndividual.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h1.png"));
            //establecer el codigo de la hamburguesa
            detPedido.setProducto_tamaño_id(1);
        }*/

 /*if (e.getSource() == hamburguesa.jBtnHamburguesa2) {
            crearComboIndividual();
            comboIndividual.jBtnCombo.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\combo.png"));
            comboIndividual.jBtnIndividual.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\Hamburguesas\\h2.png"));
        }*/
    }

    public void destruirInternal() {
        desayunos = null;
        hamburguesas = null;
        bebidasfc = null;
    }

    /*
    *Método para asignar imagenes a cada boton
     */
    public void imgPrincipal() {

        principal.jBtnDesayunos.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\desayunos\\desayunos.png"));
        principal.jBtnHamburguesas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\hamburguesas\\combo.png"));
        principal.jBtnBebidas.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidas.png"));
        principal.jBtnPostres.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\postres\\postres.png"));
        principal.jBtnSnacks.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\snacks\\snacks.png"));
    }

}
