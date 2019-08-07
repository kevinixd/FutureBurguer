/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.View_ProductosTamaniosInterface;
import modelo.View_productosTamanios;

/**
 *
 * @author javam2019
 */
public class DaoView_ProductosTamanios implements View_ProductosTamaniosInterface{
   
    Conexion cone= new Conexion(); 

    @Override
    public View_productosTamanios verProducto(int productoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
