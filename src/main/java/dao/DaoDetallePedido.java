/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.DetallePedidoInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DetallePedido;

/**
 * clase para poder visualizar el detalles de los combos 
 * de las ordenes pedidas por los clientes.
 * @author futureburguer.
 */
public class DaoDetallePedido implements DetallePedidoInterface {

    PreparedStatement ejecutar;

    private String sql = null;
    Conexion con;

    @Override
    public boolean agregarPedido(ArrayList<DetallePedido> pedido) {

        try {
            con = new Conexion();
            con.getCon().setAutoCommit(false); //inicia una transaccion
            for (DetallePedido detallePedido : pedido) {
                sql = "insert into detalle sdasdadsadasd";
                //ejecutar=cone.getconexion.preparedStamentent(sql);
                //ejecutar.setShort(1, detallePedido.getPedido_id());
                
            }
            
            con.getCon().commit(); //finaliza la transacción
            
        } catch (SQLException ex) {
            try {
                con.getCon().rollback(); //elimina la insersiones anteriores si no completan todas
            } catch (SQLException ex1) {
                System.out.println("Error : " +ex1);
            }
        }
        return false;
    }

}
