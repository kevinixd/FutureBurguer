package dao;

import interfaces.DescripcionComboInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.View_Descripcioncombo;

public class DaoDescripcionCombo implements DescripcionComboInterface {

    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    
    
    @Override
    public ArrayList<View_Descripcioncombo> verCombo(int id) {
        ArrayList<View_Descripcioncombo> lista = new ArrayList();
        con.abrirConexion();
        sql="select * from  descripcioncombo where detallescombo_id=?";
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                View_Descripcioncombo vc = new View_Descripcioncombo();
                vc.setComboId(rs.getInt("detallescombo_id"));
                vc.setComboId(rs.getInt("combo_id"));
                vc.setNombreCombo(rs.getString("combo"));
                vc.setProductoTamanioId(rs.getInt("producto_tamanio_id"));
                vc.setProductoCombo(rs.getString("producto"));
                vc.setTamanioCombo(rs.getString("tamanio"));
                vc.setPrecio(rs.getFloat("precio"));
                lista.add(vc);
            }
        } catch (Exception e) {
        }finally{
            con.cerrarConexion();
        }
       return lista;
    }
    
}
