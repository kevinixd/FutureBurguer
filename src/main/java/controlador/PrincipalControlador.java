/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.VariablesEstaticas.cantidad;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import modelo.DetallePedido;
import vista.JfrmPrincipal;
import vista.JintCarrito;

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
    JintCarrito carrito = new JintCarrito();

    //Controladores
    CarritoControlador controladorCarrito;

    public static JfrmPrincipal principal = new JfrmPrincipal();

    //Ruta para las imagenes
    String ruta = System.getProperty("user.dir");
    ImageIcon fondo = new ImageIcon(ruta + "\\src\\main\\java\\img\\fondoprincipal");
    //para saber llevar el control de la solicitud del cliente
    DetallePedido detPedido;

    private Dimension dim;

    public PrincipalControlador(JfrmPrincipal principal) {
        this.principal = principal;
        horaYFecha();
        imgPrincipal();
        setActionListeners();
        detPedido = new DetallePedido();
        principal.setExtendedState(6);
        System.out.println(principal.JPnlBotones.getLocation());
        principal.jLblCantidadProductos.setText("+" + String.valueOf(cantidad));
    }

    public void horaYFecha() {
        //Fechas y horas
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm a"); // El formato es HH:mm:ss
        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("dd/MM/yy");
        principal.jLblFecha.setText(formateadorFecha.format(LocalDateTime.now()));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        principal.jLblHora.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

    public void setActionListeners() {
        //Botones Principal
        principal.jBtnDesayunos.addActionListener(this);
        principal.jBtnHamburguesas.addActionListener(this);
        principal.jBtnBebidas.addActionListener(this);
        principal.jBtnPostres.addActionListener(this);
        principal.jBtnSnacks.addActionListener(this);
        principal.jBtnCarrito1.addActionListener(this);

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
            desayunos.setLocation(320, 105);
            desayunos.setSize(1500, 750);
            desayunos.setVisible(true);
            dc = new DesayunosControlador(desayunos);
        }

        if (e.getSource() == principal.jBtnHamburguesas) {
            hamburguesas = new jIntHamburguesas();
            HamburguesasControlador hc;
            principal.EscritorioPrincipal.add(hamburguesas);
            hamburguesas.setLocation(320, 105);
            hamburguesas.setSize(1500, 750);
            hamburguesas.setVisible(true);
            hc = new HamburguesasControlador(hamburguesas);
        }

        if (e.getSource() == principal.jBtnBebidas) {

            bebidasfc = new jIntBebidasFC();
            BebidasFCControlador bc;
            principal.EscritorioPrincipal.add(bebidasfc);
            bebidasfc.setLocation(320, 105);
            bebidasfc.setSize(1500, 750);
            bebidasfc.setVisible(true);
            bebidasfc.jBtnBF.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidasfrias\\bebidas.png"));
            bebidasfc.jBtnBC.setIcon(new ImageIcon(ruta + "\\src\\main\\java\\img\\bebidas\\bebidascalientes\\bebidaCaliente.png"));
            bc = new BebidasFCControlador(bebidasfc);
        }

        if (e.getSource() == principal.jBtnPostres) {

            postres = new jIntPostres();
            PostresControlador pc;
            principal.EscritorioPrincipal.add(postres);
            postres.setLocation(320, 105);
            postres.setSize(1500, 750);
            postres.setVisible(true);
            pc = new PostresControlador(postres);
        }

        if (e.getSource() == principal.jBtnSnacks) {

            snacks = new jIntSnacks();
            SnacksControlador sc;
            principal.EscritorioPrincipal.add(snacks);
            snacks.setLocation(320, 105);
            snacks.setSize(1500, 750);
            snacks.setVisible(true);
            sc = new SnacksControlador(snacks);
        }

        if (e.getSource() == principal.jBtnCarrito1) {
            carrito= new JintCarrito();
            principal.EscritorioPrincipal.add(carrito);
            carrito.setVisible(true);
            carrito.setLocation(320, 105);
            carrito.setSize(1500, 750);
            controladorCarrito = new CarritoControlador(carrito);
        }
    }

    public void destruirInternal() {
        desayunos = null;
        hamburguesas = null;
        bebidasfc = null;
        postres = null;
        snacks = null;
        carrito= null;
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
