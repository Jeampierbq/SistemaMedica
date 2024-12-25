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
import modelo.bean.Cita;

/**
 *
 * @author Jeampier
 */
public class CitaDAO {

    public static ArrayList<Cita> listarCitas() {

        Cita cit;

        ArrayList<Cita> citas = new ArrayList();

        String sql = "SELECT *FROM CITAS";

        Connection cn = Conexion.abrir();

        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             
                cit = new Cita(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getInt(6));
                
    
                citas.add(cit);
            }
            //cerrar 
            ps.close();
            cn.close();
            rs.close();
        } catch (SQLException ex) {

            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return citas;
    }
}
