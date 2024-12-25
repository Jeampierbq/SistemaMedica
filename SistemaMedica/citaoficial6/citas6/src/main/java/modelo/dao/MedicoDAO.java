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
import modelo.bean.Medico;

/**
 *
 * @author usuario
 */
public class MedicoDAO {
    
    
    public static ArrayList<Medico> listarMedicos() {
        Medico medi=null;
        ArrayList<Medico> medicos = new ArrayList();
        //Listar todo los empleados
        String sql = "SELECT * FROM MEDICOS";
        //Conexion a la base de datos 
        Connection cn = Conexion.abrir();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //ejecutar
            ResultSet rs = ps.executeQuery();
            //leer rs
            while (rs.next()) {
                //crear objeto paciente
                medi = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                medicos.add(medi);
            }
            //cerrar 
            ps.close();
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}