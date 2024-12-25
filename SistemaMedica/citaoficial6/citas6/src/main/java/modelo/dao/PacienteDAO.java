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
import modelo.bean.Paciente;

/**
 *
 * @author Jeampier
 */
public class PacienteDAO {

    //Busacar Paciente
    public static Paciente buscarPacienteID(int cod) {

        Paciente paci = null;
        String sql = "SELECT *FROM PACIENTES WHERE IDPACIENTE=?";
        Connection cn = Conexion.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //Asignar valor al parametro
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                paci = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

            }
        } catch (SQLException ex) {

            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paci;
    }

    //Listar pacientes 
    public static ArrayList<Paciente> listarPacientes() {

        Paciente paci;

        ArrayList<Paciente> pacientes = new ArrayList();

        //Listar todo los empleados
        String sql = "SELECT *FROM PACIENTES";
        //Conexion a la base de datos 
        Connection cn = Conexion.abrir();

        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            //ejecutar
            ResultSet rs = ps.executeQuery();
            //leer rs
            while (rs.next()) {
                //crear objeto paciente
                paci = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                pacientes.add(paci);
            }
            //cerrar 
            ps.close();
            cn.close();
            rs.close();
        } catch (SQLException ex) {

            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return pacientes;
    }
    //Insertar Paciente

    public static void insertar(Paciente paci) {

        //Instrucion sql para insertar empleado en la bd
        String sql = "INSERT INTO PACIENTES(DNI,NOMBRE,APELLIDO,TELEFONO,SEXO,EMAIL) VALUES(?,?,?,?,?,?)";
        //conexion a la bd 
        Connection cn = Conexion.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar parametros 

            ps.setString(1, paci.getDni());
            ps.setString(2, paci.getNombre());
            ps.setString(3, paci.getApellido());
            ps.setString(4, paci.getTelefono());
            ps.setString(5, paci.getSexo());
            ps.setString(6, paci.getEmail());

            //Ejecutar
            ps.executeUpdate();
            //Cerrar sesion 

            cn.close();
            ps.close();
        } catch (SQLException ex) {

            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------------------ELIMINAR 
    public static void eliminar(int cod) {
        try {
            //SQL PARA ELIMINAR EMPLEADO
            String sql = "DELETE FROM PACIENTES WHERE IDPACIENTE=?";
            //conexion a la bd
            Connection cn = Conexion.abrir();
            //ejecutar sql
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valor al parametro
            ps.setInt(1, cod);
            //ejectuar
            ps.executeUpdate();
            ///cerrar objetos
            cn.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //editar -------------------------------------------------------------------------------

    public static void modificarPaciente(Paciente paci) {
        String sql = "UPDATE PACIENTES SET DNI=?, NOMBRE=?, APELLIDO=?, TELEFONO=?, SEXO=?, EMAIL=? WHERE IDPACIENTE=?";

        // conexión a la bd
        Connection cn = Conexion.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            // asignar parámetros
            ps.setString(1, paci.getDni());
            ps.setString(2, paci.getNombre());
            ps.setString(3, paci.getApellido());
            ps.setString(4, paci.getTelefono());
            ps.setString(5, paci.getSexo());
            ps.setString(6, paci.getEmail());
            // establecer el valor para el campo IDPACIENTE
            ps.setInt(7, paci.getIdpaciente());

            // Ejecutar
            ps.executeUpdate();
            // Cerrar sesión
            cn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
