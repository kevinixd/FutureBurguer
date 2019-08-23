/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.ClasificacionesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Clasificaciones;

/**
 *clase para visualizar las clasificaciones de los productos
 * por medio de una lista a mostrar.
 * @author FutureBurguer
 */
public class DaoClasificaciones implements ClasificacionesInterface {

    Conexion conex = new Conexion();
    ResultSet resultado;
    PreparedStatement ejecutar;
    Clasificaciones clasific;

    private String sql = null;

    @Override
    public ArrayList<Clasificaciones> verClasificaciones() {
        ArrayList<Clasificaciones> lista = new ArrayList();
        conex.abrirConexion();
        sql = "select * from clasificaciones";
        try {
            ejecutar = conex.getCon().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                clasific = new Clasificaciones();
                clasific.setClasificacion_id(resultado.getShort("clasificacion_id"));
                clasific.setNombreClafisicacion(resultado.getString("nombre"));
                
                lista.add(clasific);

                System.out.println("Nombre " + clasific.getNombreClafisicacion());
            }
        } catch (SQLException ex) {
            System.out.println("Error en daoClasificaciones " + ex);
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

}
