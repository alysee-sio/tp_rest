/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

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
  name = "option",
  namespace="http://mbp-de-alysee:8080/tp_rest/Sondage"
)

/**
   Classe Option : Correspond à la réponse d'un sondage qui comprend :
        un id : identifiant unique pour chaque réponse possible
        un texte : qui est la réponse et
        un nombre de vote.
 */
public class Option {
    
    private int id;
    private String texte;
    private int nbVotes;

    public Option(int id, String texte, int nbVotes) {
        this.id = id;
        this.texte = texte;
        this.nbVotes = nbVotes;
    }

    public Option() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(int nbVotes) {
        this.nbVotes = nbVotes;
    }
    
    
}
