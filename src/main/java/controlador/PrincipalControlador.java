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

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener {

    //Daos a utilizar
    DaoProductos dao1 = new DaoProductos();

    //ArrayList para botones
    private List<JButton> lista;
    private int indice;

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
    }

    public void setActionListeners() {
        //Botones Principal
        principal.jBtnCombos.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);

        //Botones panel principal
        detPedido = new DetallePedido();
        lista = new ArrayList<>();
        indice = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            crearCombos();

        }
        if (e.getSource() == principal.jBtnBebidas) {
            crearBebidas();
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

    public void crearCombos() {
        short clasificacion = 1001;
        for (Productos product : dao1.verProductos(clasificacion)) {
            JButton boton = new JButton(product.getProductonombre());
            String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\img\\Hamburguesas\\";
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
        //principal.jPnlMenus.add(bebida);
        // imgPanelBebidas();
        //bebida.setSize(910, 550);
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

}
