/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.bean;

/**
 *
 * @author usuario
 */
public class Especialidad {
    
    private int idespecialidad;
    private String nombre;

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad(int idespecialidad, String nombre) {
        this.idespecialidad = idespecialidad;
        this.nombre = nombre;
    }

    public Especialidad() {
    }
    
    
    
    
}