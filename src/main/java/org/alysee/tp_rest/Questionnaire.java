/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alysee
 */
@XmlRootElement
public class Questionnaire {
    
    private ArrayList<Sondage> sondages;
    @XmlTransient
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
    
    @XmlTransient
    public static Questionnaire getInstance (){
        if(questionnaire == null){
            questionnaire = new Questionnaire();
        }
        return questionnaire;
    }
    
    public void addSondage (Sondage sondage){
        this.getSondages().add(sondage);
    }
    
    public void recupUnSondage(){
        
    }
}
