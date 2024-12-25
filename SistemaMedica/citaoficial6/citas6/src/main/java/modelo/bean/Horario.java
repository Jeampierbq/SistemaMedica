/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.bean;

/**
 *
 * @author usuario
 */
public class Horario {
    
    private int idhorario;
    private String horarioinicio;
    private String horariofin;

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getHorarioinicio() {
        return horarioinicio;
    }

    public void setHorarioinicio(String horarioinicio) {
        this.horarioinicio = horarioinicio;
    }

    public String getHorariofin() {
        return horariofin;
    }

    public void setHorariofin(String horariofin) {
        this.horariofin = horariofin;
    }

    public Horario(int idhorario, String horarioinicio, String horariofin) {
        this.idhorario = idhorario;
        this.horarioinicio = horarioinicio;
        this.horariofin = horariofin;
    }

    public Horario() {
    }
    
    
    
    
    
    
    
    
    
}