/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.bean;

/**
 *
 * @author Jeampier
 */
//asignar metodo 
public class Usuario {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String Sexo;
    private String dni;
    private String gmail;
    private String contraseña;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(int idusuario, String nombre, String apellido, String Sexo, String dni, String gmail, String contraseña) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Sexo = Sexo;
        this.dni = dni;
        this.gmail = gmail;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }
   
    
    
}
