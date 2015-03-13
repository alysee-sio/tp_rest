/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alysee
 */
@XmlRootElement
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
    
    public void addOption (int id, String rep){
        Option option = new Option(id,rep,0);
        options.add(option);
    }
    
}
