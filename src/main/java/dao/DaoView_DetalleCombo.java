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
import modelo.View_Descripcioncombo;

/**
 *Clase para la visualizacion de productos
 * @author FutureBurguer
 */
public class DaoView_DetalleCombo implements View_DetalleComboInterface {

    Conexion cone = new Conexion();
    View_Descripcioncombo descripcionCombo = new View_Descripcioncombo();
    PreparedStatement ejecutar;
    ResultSet resultado;

    private String sql = null;

    
    /**
     * 
     * @param productoId Se usa el ProductoID
     * @return Objeto de tipo ArrayList lista para ver los datos
     * del producto en el que evaluamos si el producto principal existe
     * dentro del combo o si este pertenece a uno 
     */
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
                descripcionCombo.setDescuento(resultado.getDouble("descuento"));
                descripcionCombo.setNombreCombo(resultado.getString("combo"));
                descripcionCombo.setDescripcionCombo(resultado.getString("descripcion"));
                descripcionCombo.setImagenDetalleCombo(resultado.getString("imagen"));
                descripcionCombo.setProductoTamanioId(resultado.getInt("producto_tamanio_id"));
                descripcionCombo.setProductoComboId(resultado.getInt("producto_id"));
                descripcionCombo.setProductoCombo(resultado.getString("producto"));
                descripcionCombo.setTamanioCombo(resultado.getString("tamanio"));
                descripcionCombo.setPrecio(resultado.getDouble("precio"));
                lista.add(descripcionCombo);
            }
            resultado.close();

        } catch (SQLException ex) {
            System.out.println("Error en dao VerProductos " + ex);
        }
        return lista;
    }

    /**
     * 
     * @param productoId se utiliza el ID del producto
     * @return un elemento de tipo View_DescripcionCombo
     * en el que podemos ver la imagen y el nombre del mismo
     */
    @Override
    public View_Descripcioncombo verImagenCombo(int productoId) {
        cone.abrirConexion();
        sql = "SELECT * FROM view_descripcioncombo WHERE combo_id IN(SELECT combo_id FROM view_descripcioncombo WHERE producto_id=?)";
        try {
            ejecutar = cone.getCon().prepareStatement(sql);
            ejecutar.setInt(1, productoId);
            resultado = ejecutar.executeQuery();
            resultado.next();
            descripcionCombo = new View_Descripcioncombo();
            descripcionCombo.setDetallescombosId(resultado.getInt("detallescombos_id"));
            descripcionCombo.setComboId(resultado.getInt("combo_id"));
            descripcionCombo.setDescripcionCombo(resultado.getString("descripcion"));
            descripcionCombo.setDescuento(resultado.getDouble("descuento"));
            descripcionCombo.setNombreCombo(resultado.getString("combo"));
            descripcionCombo.setImagenDetalleCombo(resultado.getString("imagen"));
            descripcionCombo.setProductoTamanioId(resultado.getInt("producto_tamanio_id"));
            descripcionCombo.setProductoComboId(resultado.getInt("producto_id"));
            descripcionCombo.setProductoCombo(resultado.getString("producto"));
            descripcionCombo.setTamanioCombo(resultado.getString("tamanio"));
            descripcionCombo.setPrecio(resultado.getDouble("precio"));
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en dao VerProductos " + ex);
            descripcionCombo.setImagenDetalleCombo(null);
        }
        return descripcionCombo;
    }
}
