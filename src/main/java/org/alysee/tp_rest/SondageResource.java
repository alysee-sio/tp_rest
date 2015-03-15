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
/*
    @Path : chemin de mon URL qui commence par défaut : 
        http://localhost:8080/tp_rest/webresources
    à laquelle le slash d'après sera /sondage

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
    
    /**
     *  1ère étape : Création d'un questionnaire 
     *  http://localhost:8080/tp_rest/webresources/sondage/init
     *  Questionnaire composé de deux sondages 
     * @return Response "OK" Texte : "Questionnaire créé"
     */
    @Path("init")
    @GET
    @Produces("application/json")
    public Response createQuestionnaire() {
       
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
    
    /**
     *  2ème étape : Consultation d'un questionnaire = liste de tous les sondage
     *  http://localhost:8080/tp_rest/webresources/sondage/consulterQuestionnaire
     * @return au format JSON, les sondages
     */
    @Path("consulterQuestionnaire")
    @GET
    @Produces("application/json")
    public Questionnaire getQuestionnaire() {
        Questionnaire q = Questionnaire.getInstance();
        return q;
    }
    
    /**
     *  3ème étape : Consultation d'un sondage
     *  http://localhost:8080/tp_rest/webresources/sondage/consulterUnSondage/1
     * Parcours de la liste des sondages, si l'id est égale à l'id donné alors on revoi le sondage, sinon une erreur
     * @param id : Correspond à l'identifiant d'un sondage
     * @return au format JSON, le sondage correspondant à l'id donné
     */
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
    
    /**
     *  4ème étape : Création d'un sondage
     *  http://localhost:8080/tp_rest/webresources/sondage/creationSondage
     * Ajout du sondage créé au Questionnaire, renvoi le sondage
     * @param sondage 
     * @return le sondage créé dans le questionnaire
     */
    @Path("creationSondage")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSondage(Sondage sondage) { 
        Questionnaire.getInstance().addSondage(sondage);
        return Response.status(Response.Status.CREATED).entity(sondage).build(); 
    }

    /**
     *  5ème étape : Suppression d'un sondage
     *  http://localhost:8080/tp_rest/webresources/sondage/suppressionSondage/1
     * Parcours de la liste des sondages, si l'id est égale à l'id donné alors on supprime de la liste le sondage, sinon une erreur
     * @param id : Corresspond à l'identifiant d'un sondage
     * @return une Response
     */
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
    
    /**
     *  6ème étape : Modification d'un sondage
     *  http://localhost:8080/tp_rest/webresources/sondage/modifierSondage
     * Parcours de la liste des sondages, si le sondage donné à pour id un sondage existant,
     * alors je le supprime et ajoute à la liste le nouveau, retourn le sondage sinon une erreur
     * @param sondageParam : Sondage que l'on modifi
     * @return au format JSON, le sondage modifié
     */
    @Path("modifierSondage")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSondage(Sondage sondageParam) {
        
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
