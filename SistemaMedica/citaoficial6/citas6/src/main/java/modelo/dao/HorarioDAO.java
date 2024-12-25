/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import controlador.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.Horario;

/**
 *
 * @author usuario
 */
public class HorarioDAO {
    
    
    
    public static ArrayList<Horario> listarHorarios() {
        //declarar una variable tipo usuario
        Horario hor;
        //declarar arreglo de objetos usuarios
        ArrayList<Horario> horarios = new ArrayList<>();
        //listar todos los usuairos en mysql
        String sql = "SELECT * FROM horarios";

        //conexion
        Connection cn = Conexion.abrir();

        //ejecutar sql
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //ejecutar
            ResultSet rs = ps.executeQuery();
            //leer rs
            while (rs.next()) {
                //asignar al objeto usu los valores de la bdd de sql
                hor = new Horario(rs.getInt(1), rs.getString(2), rs.getString(3));
                //agregar el objeto usu al arreglo usuarios
                horarios.add(hor);
            }
            //cerrar
            ps.close();
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horarios;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
