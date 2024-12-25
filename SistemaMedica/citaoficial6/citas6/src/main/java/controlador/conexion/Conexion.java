/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jeampier
 */
public class Conexion {

    private static String url = "jdbc:mysql://localhost/bd_citasmedicas";
    private static String usuario = "root";
    private static String password = "74950763";
    private static Connection cn;

    public static Connection abrir() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuario, password);
            return cn;
        } catch (Exception ex) {
            return null;
        }

    }
}
