package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author javam2019
 */
public class ValidarCampos {
    
    public void ValidarSoloLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
    
    public void ValidarSoloNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
}
