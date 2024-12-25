/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.bean;

/**
 *
 * @author usuario
 */
public class Medico {
    
    private int idmedico;
    private String dni;
    private String nombre;
    private String apellido;
    private String genero;
    private String telefono;
    private String nacimiento;
    private String correo;
    private String nacionalidad;
    private int idespecialidad;

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public Medico(int idmedico, String dni, String nombre, String apellido, String genero, String telefono, String nacimiento, String correo, String nacionalidad, int idespecialidad) {
        this.idmedico = idmedico;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.idespecialidad = idespecialidad;
    }

    public Medico() {
    }
    
    
    
    
    
    
    
}