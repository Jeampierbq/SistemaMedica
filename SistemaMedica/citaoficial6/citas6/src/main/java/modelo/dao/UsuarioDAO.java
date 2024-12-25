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
import modelo.bean.Usuario;

/**
 *
 * @author Jeampier
 */
public class UsuarioDAO {

    public static Usuario buscarUsuarioID(int cod) {

        Usuario usu = null;
        String sql = "SELECT *FROM USUARIOS WHERE IDUSUARIO=?";
        Connection cn = Conexion.abrir();

        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            //Asignar valor al parametro
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                usu = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

            }

        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usu;
    }

    public static Usuario validarUsuario(String us, String pas) {

        Usuario user = null;
        String sql = "SELECT * FROM usuarios WHERE gmail = ? AND contraseña = ?";

        //conexion
        Connection cn = Conexion.abrir();

        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            // asignar parametros: ?
            ps.setString(1, us);
            ps.setString(2, pas);

            ResultSet rs = ps.executeQuery();

            // leer rs
            if (rs.next()) {

                user = new Usuario();
                // del objeto usuario: encapsulamiento
                user.setIdusuario(rs.getInt("idusuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setSexo(rs.getString("sexo"));
                user.setDni(rs.getString("dni"));
                user.setGmail(rs.getString("gmail"));
                user.setContraseña(rs.getString("contraseña"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    public static ArrayList<Usuario> listarUsuarios() {
        //declarar una variable tipo usuario
        Usuario usu;
        //declarar arreglo de objetos usuarios
        ArrayList<Usuario> usuarios = new ArrayList<>();
        //listar todos los usuairos en mysql
        String sql = "SELECT * FROM usuarios";

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
                usu = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                //agregar el objeto usu al arreglo usuarios
                usuarios.add(usu);
            }
            //cerar
            ps.close();
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public static void insertar(Usuario usu) {

        //instruccion sql para insertar empleado en la bd
        String sql = "INSERT INTO Usuarios (Nombre, Apellido, Sexo, Dni, Gmail, Contraseña) VALUES (?, ?, ?, ?, ?, ?)";

        //conexion a la bd
        Connection cn = Conexion.abrir();

        try {

            PreparedStatement ps = cn.prepareStatement(sql);
            //valor a los parametros ?.?,?,?
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setString(3, usu.getSexo());
            ps.setString(4, usu.getDni());
            ps.setString(5, usu.getGmail());
            ps.setString(6, usu.getContraseña());  // Corregido el índice a 6
            //Ejecutar
            ps.executeUpdate();
            //Cerrar sesion 

            cn.close();
            ps.close();
        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------------------ELIMINAR 
    public static void eliminar(int cod) {

        try {
            //SQL PARA ELIMINAR USUARIO
            String sql = "DELETE FROM USUARIOS WHERE IDUSUARIO=?";
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

    public static void modificar(Usuario usu) {

        String sql = "UPDATE USUARIOS SET NOMBRE=?, APELLIDO=?, SEXO=?, DNI=?, GMAIL=?, CONTRASEÑA=? WHERE IDUSUARIO=?";

        // conexión a la bd
        Connection cn = Conexion.abrir();

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            //valor a los parametros ?.?,?,?
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setString(3, usu.getSexo());
            ps.setString(4, usu.getDni());
            ps.setString(5, usu.getGmail());
            ps.setString(6, usu.getContraseña());  // Corregir aquí, usar setString para la contraseña
            ps.setInt(7, usu.getIdusuario());  // Corregir aquí, usar setInt para el ID de usuario
            // Ejecutar
            ps.executeUpdate();
            // Cerrar sesión
            cn.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
