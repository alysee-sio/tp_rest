/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

/**
 *
 * @author Alysee
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
