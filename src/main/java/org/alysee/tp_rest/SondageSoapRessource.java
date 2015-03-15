/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

/**
 * @author Alysee
 *          SOAP 
 * Annotation de @WebService, ainsi que toutes les méthodes de @WebMethod
 * Adresse : http://mbp-de-alysee:8080/tp_rest/sondage?WSDL
 * Pour l'affichage des résultats, tout ce fait avec l'extension chrome Widlzer
 * 
 *      Méthodes identiques au Rest à part qu'on ne retourne jamais de Response
 */
@WebService(                                                           
   name="SondageSoapRessource",
   targetNamespace = "http://mbp-de-alysee:8080/tp_rest/Sondage",
   serviceName = "sondage")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)  


public class SondageSoapRessource {
    
    /**
     * 1ère étape : Création d'un questionnaire  
     * Le param i, est laissé à vide 
     * @param i (à défaut, sinon ça ne marché pas ..)
     */
    @WebMethod
    public void createQuestionnaire(int i) {
       
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
        
    }
    
    /**
     * 2ème étape : Consultation d'un questionnaire = liste de tous les sondage
     * param i laissé à vide
     * @param i (à défaut aussi)
     * @return au format XML, la liste des sondages
     */
    @WebMethod
    public Questionnaire getQuestionnaire(int i) {
        Questionnaire q = Questionnaire.getInstance();
        return q;
    }
    
    /**
     * 3ème étape : Consultation d'un sondage     
     * Parcours de la liste des sondages, si l'id est égale à l'id donné alors on revoi le sondage, sinon on leve une exception
     * @param id : Correspond à l'identifiant d'un sondage
     * @return au format XML,le sondage correspondant à l'id donné
     */
    @WebMethod
    public Sondage getSondageId(@PathParam("id") int id) {
        Sondage sondageTrouve = null;
        ArrayList<Sondage> listeSondage = Questionnaire.getInstance().getSondages();
        for (Sondage sondage : listeSondage){
            if(id == sondage.getId()){
                return sondage;
            }
        }
        throw new WebApplicationException("Sorry, l'ID n'existe pas");

    }
    
    /**
     *  4ème étape : Création d'un sondage
     * @param sondage
     * @return au format XML, le sondage créé 
     */
    @WebMethod
    public Sondage createSondage(Sondage sondage) { 
        Questionnaire.getInstance().addSondage(sondage);
        return sondage; 
    }
    
    /**
     * 5ème étape : Suppression d'un sondage
     * Parcours de la liste des sondages, si l'id est égale à l'id donné alors on supprime de la liste le sondage, sinon on leve une exception
     * @param id : Corresspond à l'identifiant d'un sondage
     */
    @WebMethod
    public void deleteSondage(@PathParam("id") int id) { 
        Sondage sondageTrouve = null;
        ArrayList<Sondage> listeSondage = Questionnaire.getInstance().getSondages();
        for (Sondage sondage : listeSondage){
            if(id == sondage.getId()){
                listeSondage.remove(sondage);
                return;
               
            }
        }
        throw new WebApplicationException("Sorry, l'ID n'existe pas");
    }
    
    /**
     * 6ème étape : Modification d'un sondage
     * Parcours de la liste des sondages, si le sondage donné à pour id un sondage existant,
     * alors je le supprime et ajoute à la liste le nouveau, retourn le sondage sinon je leve une exception
     * @param sondageParam : Sondage que l'on modifi
     * @return au format XML, le sondage modifié
     */
    @WebMethod
    public Sondage updateSondage(Sondage sondageParam) {
        
        ArrayList<Sondage> listeSondage = Questionnaire.getInstance().getSondages();
        for (Sondage sondage : listeSondage){
            if(sondageParam.getId() == sondage.getId()){
                listeSondage.remove(sondage);
                listeSondage.add(sondageParam);
                return sondageParam;
                
            }
        }
            throw new WebApplicationException("Sorry, l'ID n'existe pas");
        
    }
}
