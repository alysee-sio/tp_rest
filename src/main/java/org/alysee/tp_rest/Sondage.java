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
  name = "sondage",
  namespace="http://mbp-de-alysee:8080/tp_rest/Sondage"
)

/*
   Classe Sondage : Correspond à la question qui comprend :
        un id : identifiant unique pour chaque question
        un intitulé : texte de la question et 
        un ArrayList d'Option : qui va contenir les différentes options possible
        
*/
public class Sondage {
    
    private int id;
    private String intitule;
    private ArrayList<Option> options;

    public Sondage(int id, String intitule) {
        this.id = id;
        this.intitule = intitule;
        this.options = new ArrayList<Option>();
    }

    public Sondage() {
        this.options = new ArrayList<Option>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
    
    /**
     * addOption : un sondage créé ses options, on ajoute donc une option à un sondage
     * @param id
     * @param rep 
     */
    public void addOption (int id, String rep){
        Option option = new Option(id,rep,0);
        options.add(option);
    }
    
}
