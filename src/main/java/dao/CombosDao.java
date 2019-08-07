/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.CombosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Combos;

/**
 *
 * @author javam2019
 */
public class CombosDao implements CombosInterface{
    
    Conexion conexion= new Conexion();
    ResultSet resultado;
    PreparedStatement ejecutar;
    Combos combo;
    
    private String sql=null;

    @Override
    public Combos verCombo(byte tipoCombo) {
        conexion.abrirConexion();
        sql="select * from combos where tipo_combo_id=?";
        try {
            ejecutar=conexion.getCon().prepareStatement(sql);
            ejecutar.setByte(1, tipoCombo);
            resultado=ejecutar.executeQuery();
            while(resultado.next()){
                combo= new Combos();
                combo.setCombo_id(resultado.getInt("combo_id"));
                combo.setCombonombre(resultado.getString("nombre"));
                combo.setCombodescuento(resultado.getDouble("descuento"));
                combo.setTipo_combo_id(resultado.getByte("tipo_combo_id"));
            }
        } catch (SQLException ex) {
            System.out.println("Error en daoCombo verTipos " + ex);
        } finally{
            conexion.cerrarConexion();
        }
        return combo;
    }
}
