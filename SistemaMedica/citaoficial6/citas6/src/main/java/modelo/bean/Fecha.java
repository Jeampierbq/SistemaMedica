/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.bean;

/**
 *
 * @author usuario
 */
public class Fecha {
    
    private int idfecha;
    private String dia;
    private String mes;
    private String año;

    public int getIdfecha() {
        return idfecha;
    }

    public void setIdfecha(int idfecha) {
        this.idfecha = idfecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public Fecha(int idfecha, String dia, String mes, String año) {
        this.idfecha = idfecha;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha() {
    }
    
    
    
    
    
    
    
    
    
    
}
