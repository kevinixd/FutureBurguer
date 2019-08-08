/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.View_ProductosTamaniosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.View_productosTamanios;

/**
 *
 * @author javam2019
 */
public class DaoView_ProductosTamanios implements View_ProductosTamaniosInterface {

    Conexion cone = new Conexion();
    View_productosTamanios productTamanio = new View_productosTamanios();

    PreparedStatement ejecutar;
    ResultSet resultado;

    private String sql = null;

    @Override
    public View_productosTamanios verProductoDetalle(int productoId) {
        cone.abrirConexion();
        sql = "select * from view_productostamanios where producto_id=?";
        try {
            ejecutar = cone.getCon().prepareStatement(sql);
            ejecutar.setInt(1, productoId);
            resultado = ejecutar.executeQuery();
            resultado.next();
            productTamanio.setPtIdView(resultado.getShort("producto_tamanio_id"));
            productTamanio.setProductoIdView(resultado.getInt("producto_id"));
            productTamanio.setProductoView(resultado.getString("producto"));
            productTamanio.setProductoImgView(resultado.getString("imagen"));
            productTamanio.setProductoDescpView(resultado.getString("descripcion"));
            productTamanio.setTamanioView(resultado.getString("tamanio"));
            productTamanio.setPrecioView(resultado.getDouble("precio"));
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerProductoDetalle " + ex);
        } finally{
            cone.cerrarConexion();
        }
        return productTamanio;
    }

}
