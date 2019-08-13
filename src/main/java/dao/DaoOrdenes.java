package dao;

import interfaces.OrdenesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.View_Ordenes;


/**
 * Clase para visualizar las ordenes
 * @author FutureBurguer
 */
public class DaoOrdenes implements OrdenesInterface{
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    View_Ordenes or = new View_Ordenes();
    
    String sql = null;

    
    /**
     * 
     * @param orden datos del objeto definidos por el usuario
     * @return objeto de tipo ArrayList lista
     */
    @Override
    public ArrayList<View_Ordenes> verOrdenes(byte orden) {
        ArrayList<View_Ordenes> lista = new ArrayList();
        con.abrirConexion();
        sql= "select * from view_ordenes where numero_orden=?";
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setByte(1, orden);
            rs = ps.executeQuery();
            while(rs.next()){
            View_Ordenes vo = new View_Ordenes();
            vo.setNumero_orden(rs.getInt("numero_orden"));
            //vo.setMesaOrden(rs.getByte("mesa"));
            vo.setTipoComboOrden(rs.getString("tipocombo"));
            vo.setProductoOrden(rs.getString("producto"));
            vo.setTamanioOrden(rs.getString("tamanio"));
            vo.setCantidadOrden(rs.getInt("cantidad"));
            vo.setDescripcionOrden(rs.getString("descripcion"));
            vo.setPrecioOrden(rs.getFloat("precio"));
            lista.add(vo);
            }
        } catch (Exception e) {
        }finally{
            con.cerrarConexion();
        }
        return lista;
    }
    
}
