/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.ProductosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Productos;


/**
 * Clase para la visualizacion de productos
 * @author FutureBurguer
 */
public class DaoProductos implements ProductosInterface {

    Conexion conexion = new Conexion();
    ResultSet resultado;
    PreparedStatement ejecutar;
    Productos producto = new Productos();

    private String sql = null;

    
    /**
     * 
     * @param id dato definido por el usuario 
     * @return Objeto de tipo ArrayList lista
     */
    @Override
    public ArrayList<Productos> verProductos(short id) {
        ArrayList<Productos> lista = new ArrayList();
        conexion.abrirConexion();
        sql = "select * from productos where clasificacion_id=?";
        try {
            ejecutar = conexion.getCon().prepareStatement(sql);
            ejecutar.setShort(1, id);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                producto= new Productos();
                producto.setProducto_id(resultado.getInt("producto_id"));
                producto.setProductonombre(resultado.getString("nombre"));
                producto.setProductodescripcion(resultado.getString("descripcion"));
                producto.setClasificacion_id(resultado.getInt("clasificacion_id"));
                producto.setImagen(resultado.getString("imagen"));
                lista.add(producto);
            }
            resultado.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.cerrarConexion();
        }
        return lista;
    }

}
