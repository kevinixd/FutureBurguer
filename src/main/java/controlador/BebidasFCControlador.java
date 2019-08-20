/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import static controlador.PrincipalControlador.principal;
import dao.DaoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Productos;
import vista.formulariosbebidas.jIntBebidasCalientes;
import vista.formulariosbebidas.jIntBebidasFC;
import vista.formulariosbebidas.jIntBebidasFrias;

//import vista.jIntDrink1;
/**
 *
 * @author javam2019
 */
public class BebidasFCControlador implements ActionListener {

    jIntBebidasFC bebidas = new jIntBebidasFC();
    jIntBebidasFrias bebidasFrias = new jIntBebidasFrias();
    jIntBebidasCalientes bebidasCalientes = new jIntBebidasCalientes();

    public BebidasFCControlador(jIntBebidasFC bebidas) {
        this.bebidas = bebidas;
        bebidas.jBtnBF.addActionListener(this);
        bebidas.jBtnBC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bebidas.jBtnBF) {
            BebidasFriasControlador bfc = new BebidasFriasControlador(bebidasFrias);
            principal.EscritorioPrincipal.add(bebidasFrias);
            bebidasFrias.setLocation(320, 105);
            bebidasFrias.setSize(1500, 750);
            bebidasFrias.setVisible(true);

        }
        if (e.getSource() == bebidas.jBtnBC) {
            BebidasCalienteControlador bcc = new BebidasCalienteControlador(bebidasCalientes);
            principal.EscritorioPrincipal.add(bebidasCalientes);
            bebidasCalientes.setLocation(320, 105);
            bebidasCalientes.setSize(1500, 750);
            bebidasCalientes.setVisible(true);
        }

    }

}
