/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.basedatos.controller;

import com.jose.basedatos.ejb.ComputadoraFacade;
import com.jose.computadoraclient.entity.Computadora;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Jose Luis
 */
@Named(value = "computadoraController")
@ViewScoped
public class ComputadoraController implements Serializable {
    @Inject
    ComputadoraFacade computadoraFacade;
    
    /**
     * Creates a new instance of ComputadoraController
     */
    public ComputadoraController() {
    }
    public String mostrar()
    {
        List<Computadora> lista=computadoraFacade.findAll();
        System.out.println("Cantidad"+lista.size());
        return "";
    }
    /*public String crear()
    {
        Computadora computador= new Computadora("3555ad","HP","Panama 2020","AMD",225.5,5);
        computadoraFacade.create(computador);
        System.out.println("Computadora creada "+computador);
        return "";
    }*/
    
}
