package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author FutureBurguer
 *Esta clase va validar los campos de jtextfield,
 * al ingresar un campo de texto o numero.
 * @author ftureburguer.
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
    
    public void ValidarSoloNumeros(JTextField campo, int caracteres){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                int longitud= campo.getText().length();
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
                if(longitud>caracteres){
                    e.consume();
                }
            }
        });
    }
}
