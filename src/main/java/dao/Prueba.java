/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 * clase ejecutable para proba si la coneccion a la base de datos esta correcta.
 * @author javam2019
 */
public class Prueba {
    public static void main(String[] args) {
        Conexion conex = new Conexion();
        conex.abrirConexion();
    }
}
