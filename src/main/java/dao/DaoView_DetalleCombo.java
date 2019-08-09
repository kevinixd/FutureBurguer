/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.View_DetalleComboInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.View_Descripcioncombo;

/**
 *
 * @author javam2019
 */
public class DaoView_DetalleCombo implements View_DetalleComboInterface {

    Conexion cone = new Conexion();
    View_Descripcioncombo descripcionCombo = new View_Descripcioncombo();
    PreparedStatement ejecutar;
    ResultSet resultado;

    private String sql = null;

    @Override
    public ArrayList<View_Descripcioncombo> verProductos(int productoId) {
        ArrayList<View_Descripcioncombo> lista = new ArrayList();
        cone.abrirConexion();
        sql = "SELECT * FROM view_descripcioncombo WHERE combo_id IN(SELECT combo_id FROM view_descripcioncombo WHERE producto_id=?)";
        try {
            ejecutar = cone.getCon().prepareStatement(sql);
            ejecutar.setInt(1, productoId);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                descripcionCombo = new View_Descripcioncombo();
                descripcionCombo.setDetallescombosId(resultado.getInt("detallescombos_id"));
                descripcionCombo.setComboId(resultado.getInt("combo_id"));
                descripcionCombo.setNombreCombo(resultado.getString("combo"));
                descripcionCombo.setImagenDetalleCombo(resultado.getString("imagen"));
                descripcionCombo.setProductoTamanioId(resultado.getInt("producto_tamanio_id"));
                descripcionCombo.setProductoComboId(resultado.getInt("producto_id"));
                descripcionCombo.setProductoCombo(resultado.getString("producto"));
                descripcionCombo.setTamanioCombo(resultado.getString("tamanio"));
                descripcionCombo.setPrecio(resultado.getDouble("precio"));
                lista.add(descripcionCombo);
            }
            resultado.close();
            System.out.println("Detalle Combo Id " + descripcionCombo.getDetallescombosId());
            System.out.println("Combo Id " + descripcionCombo.getComboId());
            System.out.println("Producto " + descripcionCombo.getNombreCombo());
            System.out.println("Detalle Combo Id " + descripcionCombo.getImagenDetalleCombo());
            System.out.println("Producto Tamanio ID" + descripcionCombo.getProductoTamanioId());
            System.out.println("Producto " + descripcionCombo.getProductoCombo());
            System.out.println("Tamaño " + descripcionCombo.getTamanioCombo());
            System.out.println("Precio " + descripcionCombo.getPrecio());

        } catch (SQLException ex) {
            System.out.println("Error en dao VerProductos " + ex);
        }
        return lista;
    }
}
