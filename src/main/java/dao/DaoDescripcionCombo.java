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

    View_Descripcioncombo vc = new View_Descripcioncombo();

    @Override
    public View_Descripcioncombo verCombo(View_Descripcioncombo view_Descripcioncombo) {
        con.abrirConexion();
        sql = "select * from descripcioncombo where detallescombo_id=?";
        try {
            ps = con.getCon().prepareStatement(sql);
            ps.setInt(1, view_Descripcioncombo.getComboId());
            rs = ps.executeQuery();
            rs.next();
            vc.setComboId(rs.getInt("detallescombo_id"));
            vc.setComboId(rs.getInt("combo_id"));
            vc.setNombreCombo(rs.getString("combo"));
            vc.setProductoTamanioId(rs.getInt("producto_tamanio_id"));
            vc.setProductoCombo(rs.getString("producto"));
            vc.setTamanioCombo(rs.getString("tamanio"));
            vc.setPrecio(rs.getFloat("precio"));
            rs.close();
        } catch (Exception e) {
        } finally {
            con.cerrarConexion();
        }
        return vc;
    }

}
