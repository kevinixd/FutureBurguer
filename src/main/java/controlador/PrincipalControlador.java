/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JfrmPrincipal;
import vista.jPnlCombos;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener{

    JfrmPrincipal principal = new JfrmPrincipal();
    jPnlCombos combos = new jPnlCombos();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.jBtnCombos) {
            principal.setLayout(null);
            principal.add(combos);
            combos.setLocation(250, 50);
        }
    }
    
}
