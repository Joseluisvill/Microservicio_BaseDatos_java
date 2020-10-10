/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.basedatos.resource;

import com.jose.basedatos.ejb.ComputadoraFacade;
import com.jose.basedatos.entity.Computadora;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose Luis
 */
@Path("sistemas")
public class OperacionesResource {
    @Inject
    ComputadoraFacade computadoraFacade;
    
    @GET
    @Path("/datos")
    public Response hola()
    {
        return Response.ok("Esta en otra Ubicacion").build();
    }
    
    @GET
    @Path("/datos/{idclase}")
    public Response hola(@PathParam(value="ideclase") String id)
    {
        return Response
                .ok("Esta en otra Ubicacion")
                .build();
    }
    @GET
    @Path("/saludo")
    public Response saludo()
    {
        //Utilidades utilidades=new Utilidades();
        //Computadora computadora=new Computadora("45893");
        
        String valor="Hola";
        return Response
                .ok(valor)
                .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/computadora")
    public Computadora devolverComputadora()
    {
        Computadora computador= new Computadora("3555ad","HP","Panama 2020","AMD",225.5,5);
        return computador;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/computadoradefault")
    public Computadora devolverComputadoraDefault()
    {
        return new Computadora("0004555557","HP","Panama 2020","AMD",225.5,8);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/computadoralista")
    public List<Computadora>devolverLista()
    {
        //List<Computadora> lista= new ArrayList<>();
        //lista.add(new Computadora("0004555557","HP","Panama 2020","AMD",225.5,8));
        //lista.add(new Computadora("452248","Lenovo","Herrera 2020","AMD",225.5,8));
        //lista.add(new Computadora("Az25445878","Dell","Azuero 2020","Intel",225.5,8));
        List<Computadora> lista= computadoraFacade.findAll();
        return lista;
    }   
    
    //estos post lo cree la vez pasada de asignacion de ejemplo
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/computadorapost")
    public Computadora devolverComputadoraPost()
    {
        return new Computadora("1212","DELL","Panama 2020","INTEL",225.5,8);
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/computadorapost/{marca}")
    public Computadora devolverComputadoraPostArgumentos(@PathParam(value="marca") String marca)
    {
        return new Computadora("1212",marca,"Panama 2020","INTEL",225.5,8);
    }
    //lo que se pidio para crear y actualizar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crearcomputadora")
    public Response crearcomputadora(Computadora computador)
    {
        //Computadora computador= new Computadora("4222","DELL","HERRERA","INTEL",120.0,8);
        computadoraFacade.create(computador);
        return Response
                .ok()
                .build();
    }
    //para buscar desde serial
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscarcomputadora")
    public Computadora buscarcomputadora(Computadora computador)
    {
        String a= computador.getSerial();
        
       Computadora cp=computadoraFacade.find(computador.getSerial());
       return cp;
    }
    
   /* public List<Computadora>buscadatosserial(String cadena)
    {
        List<Computadora> ls =computadoraFacade.busquedaSerial(cadena);
        return ls;
    }*/
}

