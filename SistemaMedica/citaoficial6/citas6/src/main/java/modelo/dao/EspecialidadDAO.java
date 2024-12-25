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
import modelo.bean.Especialidad;

/**
 *
 * @author usuario
 */
public class EspecialidadDAO {
    
    public static ArrayList<Especialidad> listarEspecialidades() {
        Especialidad espe;
        ArrayList<Especialidad> especialidades = new ArrayList();
        //Listar todo los empleados
        String sql = "SELECT *FROM ESPECIALIDADES";
        //Conexion a la base de datos 
        Connection cn = Conexion.abrir();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //ejecutar
            ResultSet rs = ps.executeQuery();
            //leer rs
            while (rs.next()) {
                //crear objeto paciente
                espe = new Especialidad(rs.getInt(1), rs.getString(2));
                especialidades.add(espe);
            }
            //cerrar 
            ps.close();
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especialidades;
    }
    
    
    
    
    
    
    
    
    
}
