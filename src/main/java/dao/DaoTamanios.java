/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.TamaniosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tamanios;

/**
 * Clase para la visualizacion de tamaños.
 * @author FutureBurguer
 */
public class DaoTamanios implements TamaniosInterface {

    Conexion conexion = new Conexion();
    ResultSet resultado;
    PreparedStatement ejecutar;
    Tamanios tamanios = new Tamanios();
    ArrayList<Tamanios> lista;

    private String sql = null;

    /**
     * 
     * @return un arrayList con los nombres de los tamaños
     * así mismo como sus nombres y su ID para trabajar con 
     * los mismos
     */
    @Override
    public ArrayList<Tamanios> verTamanios() {
        conexion.abrirConexion();
        lista = new ArrayList();
        sql = "select * from tamanios where tamanio_id<>4";
        try {
            ejecutar = conexion.getCon().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                tamanios = new Tamanios();
                tamanios.setTamanio_id(resultado.getByte("tamanio_id"));
                tamanios.setTamanionombre(resultado.getString("nombre"));
                tamanios.setTamaniodescripcion(resultado.getString("descripcion"));
                lista.add(tamanios);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerTamanios " + ex);
        }
        return lista;
    }
    
}
