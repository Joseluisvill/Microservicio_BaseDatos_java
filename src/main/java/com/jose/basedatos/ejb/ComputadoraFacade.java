/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.basedatos.ejb;

import com.jose.basedatos.ejb.AbstractFacade;
import com.jose.basedatos.entity.Computadora;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jose Luis
 */
@Stateless
public class ComputadoraFacade extends AbstractFacade<Computadora>{
   
    @Inject
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    public ComputadoraFacade ()
    {
        super(Computadora.class);
    }
    public List<Computador> busquedaSerial(String cadena)
    {
        Query p= em.createNativeQuery("SELECT * FROM computadora WHERE SERIAL="+cadena+"", Computadora.class);
        List<Computador> ls=p.getResultList();
        return ls;
    }

    private static class Computador {

        public Computador() {
        }
    }
    
    
    
    
}
