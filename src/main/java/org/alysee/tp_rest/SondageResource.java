/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alysee
 */
@Path("sondage")
public class SondageResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SondageResource
     */
    public SondageResource() {
    }

    /**
     * Retrieves representation of an instance of org.alysee.tp_rest.SondageResource
     * @return an instance of org.alysee.tp_rest.Sondage
     */
    
    //Création d'un questionnaire
    @Path("init")
    @GET
    @Produces("application/json")
    public Response initJson() {
       
        Questionnaire q = Questionnaire.getInstance();
        
        Sondage s = new Sondage(1, "Quelle est la capitale de la France");
        s.addOption(1, "Clermont-Ferrand");
        s.addOption(2, "Lyon");
        s.addOption(3, "Paris");
        
        Sondage s1 = new Sondage(2, "Quelle est la capitale de l'Australie");
        s1.addOption(9, "Sydney");
        s1.addOption(7, "Canberra");
        s1.addOption(8, "Adelaide");
        
        q.addSondage(s);
        q.addSondage(s1);
        
        return Response.status(Response.Status.OK).entity("Questionnaire cree").build();
        
    }
    
    //Consulter le questionnaire ( = liste des sondages)
    @Path("consulterQuestionnaire")
    @GET
    @Produces("application/json")
    public Questionnaire getJson() {
        Questionnaire q = Questionnaire.getInstance();
        return q;
    }
    
    //Consultation d'un sondage en particulier avec l'ID
    @Path("consulterUnSondage/{id}")
    @GET
    @Produces("application/json")
    public Response getSondageId(@PathParam("id") int id) {
        Sondage sondageTrouve = null;
        ArrayList<Sondage> listeSondage = Questionnaire.getInstance().getSondages();
        for (Sondage sondage : listeSondage){
            if(id == sondage.getId()){
                return Response.status(Response.Status.OK).entity(sondage).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
    
    //Création d'un sondage
    @Path("creationSondage")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSondageInJSON(Sondage sondage) { 
        Questionnaire.getInstance().addSondage(sondage);
        return Response.status(Response.Status.CREATED).entity(sondage).build(); 
    }
    
    
    //Suppression d'un sondage
    @Path("suppressionSondage/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSondage(@PathParam("id") int id) { 
        Sondage sondageTrouve = null;
        ArrayList<Sondage> listeSondage = Questionnaire.getInstance().getSondages();
        for (Sondage sondage : listeSondage){
            if(id == sondage.getId()){
                listeSondage.remove(sondage);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    
    @Path("modifierSondage")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(Sondage sondageParam) {
        
        ArrayList<Sondage> listeSondage = Questionnaire.getInstance().getSondages();
        for (Sondage sondage : listeSondage){
            if(sondageParam.getId() == sondage.getId()){
                listeSondage.remove(sondage);
                listeSondage.add(sondageParam);
                return Response.status(Response.Status.OK).entity(sondageParam).build();
                
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
        
    }
    
    
}
