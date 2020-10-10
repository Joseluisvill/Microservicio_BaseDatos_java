/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.basedatos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jose Luis
 */
@Entity
@Table(name = "computadora")
@NamedQueries({
    @NamedQuery(name = "Computadora.findAll", query = "SELECT c FROM Computadora c"),
    @NamedQuery(name = "Computadora.findBySerial", query = "SELECT c FROM Computadora c WHERE c.serial = :serial"),
    @NamedQuery(name = "Computadora.findByMarca", query = "SELECT c FROM Computadora c WHERE c.marca = :marca"),
    @NamedQuery(name = "Computadora.findByModelo", query = "SELECT c FROM Computadora c WHERE c.modelo = :modelo"),
    @NamedQuery(name = "Computadora.findByMarcaProcesador", query = "SELECT c FROM Computadora c WHERE c.marcaProcesador = :marcaProcesador"),
    @NamedQuery(name = "Computadora.findByVelocidadProcesador", query = "SELECT c FROM Computadora c WHERE c.velocidadProcesador = :velocidadProcesador"),
    @NamedQuery(name = "Computadora.findByCantidadRam", query = "SELECT c FROM Computadora c WHERE c.cantidadRam = :cantidadRam")})
public class Computadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marcaProcesador")
    private String marcaProcesador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidadProcesador")
    private double velocidadProcesador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadRam")
    private int cantidadRam;

    public Computadora() {
    }

    public Computadora(String serial) {
        this.serial = serial;
    }

    public Computadora(String serial, String marca, String modelo, String marcaProcesador, double velocidadProcesador, int cantidadRam) {
        this.serial = serial;
        this.marca = marca;
        this.modelo = modelo;
        this.marcaProcesador = marcaProcesador;
        this.velocidadProcesador = velocidadProcesador;
        this.cantidadRam = cantidadRam;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarcaProcesador() {
        return marcaProcesador;
    }

    public void setMarcaProcesador(String marcaProcesador) {
        this.marcaProcesador = marcaProcesador;
    }

    public double getVelocidadProcesador() {
        return velocidadProcesador;
    }

    public void setVelocidadProcesador(double velocidadProcesador) {
        this.velocidadProcesador = velocidadProcesador;
    }

    public int getCantidadRam() {
        return cantidadRam;
    }

    public void setCantidadRam(int cantidadRam) {
        this.cantidadRam = cantidadRam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computadora)) {
            return false;
        }
        Computadora other = (Computadora) object;
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jose.basedatos.entity.Computadora[ serial=" + serial + " ]";
    }
    
}
