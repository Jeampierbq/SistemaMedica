/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.bean;

/**
 *
 * @author Jeampier
 */
public class Cita {
    private int idcita;
    private int idpaciente;
    private int idmedico;
    private int idhorario;
    private int idfecha;
    private int idusuario;

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public int getIdfecha() {
        return idfecha;
    }

    public void setIdfecha(int idfecha) {
        this.idfecha = idfecha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Cita(int idcita, int idpaciente, int idmedico, int idhorario, int idfecha, int idusuario) {
        this.idcita = idcita;
        this.idpaciente = idpaciente;
        this.idmedico = idmedico;
        this.idhorario = idhorario;
        this.idfecha = idfecha;
        this.idusuario = idusuario;
    }

    public Cita() {
    }

    
    
}
