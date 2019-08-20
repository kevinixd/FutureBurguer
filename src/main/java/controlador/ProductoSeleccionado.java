/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.ArrayList;
import modelo.DetallePedido;
import modelo.Productos;

/**
 * Clase para obtener los datos del producto selecionado por el cliente
 * @author javam2019
 */
public class ProductoSeleccionado {
    
    public static Productos productoSeleccionado = new Productos();
    
    //Variable para generalizar el ID del producto seleccionado
    public static int productoID;
    
    //Variable para generalizar el ID de la clasificación
    public static int clasificacion;
    
    //ArrayList para
    public static ArrayList<DetallePedido> agregarOrden= new ArrayList();
}
 