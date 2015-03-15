/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alysee
 */

/*
    Utilisation pour le SOAP
 */
// XMLRootElement : permet de sérialiser l'objet
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(                                                  
  name = "questionnaire",
  namespace="http://mbp-de-alysee:8080/tp_rest/Sondage"
)

/*
   Classe Questionnaire : Va regrouper tous les sondages, il possède : 
        un ArrayList de Sondage : contenir tous les sondages
        un Singleton : Assure qu'une seule instance de questionnaire existe dans toute l'application
 */
public class Questionnaire {
    
    private ArrayList<Sondage> sondages;
    private static Questionnaire questionnaire;

    private Questionnaire() {
        this.sondages = new ArrayList<Sondage>();
    }
    
    public ArrayList<Sondage> getSondages() {
        return sondages;
    }

    public void setSondages(ArrayList<Sondage> sondages) {
        this.sondages = sondages;
    }

    /**
     * getInstance Si je n'est pas de questionnaire, j'en crée un et je le retourne, sinon je retourne celui que j'ai. 
     * @return un questionnaire
     */
    public static Questionnaire getInstance (){
        if(questionnaire == null){
            questionnaire = new Questionnaire();
        }
        return questionnaire;
    }
    
    /**
     * addSondage Ajout de sondage dans la liste.
     * @param sondage 
     */
    public void addSondage (Sondage sondage){
        this.getSondages().add(sondage);
    }
    
    
}
