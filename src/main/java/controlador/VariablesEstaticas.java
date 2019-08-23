/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.ArrayList;
import modelo.DetallePedido;
import modelo.Productos;
import modelo.View_Ordenes;

/**
 * Clase para obtener los datos del producto selecionado por el cliente
 * @author javam2019
 */
public class VariablesEstaticas {
    
    public static Productos productoSeleccionado = new Productos();
    
    //Variable para generalizar el ID del producto seleccionado
    public static int productoID;
    
    //Variable para generalizar el ID de la clasificación
    public static int clasificacion;
    
    //ArrayList para insertar datos en el carrito de compras
    public static ArrayList<View_Ordenes> verDetalle= new ArrayList();
    
    //Variable para verCantidad de Productos
    public static int cantidad;
    
    //Variable para ir contando en Index
    public static int index;
}
 