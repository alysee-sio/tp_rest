/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alysee.tp_rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *  Page générée automatiquement, sert pour savoir le début du path :
 *       http://localhost:8080/tp_rest/webresources
 * @author Alysee
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    
    // Classe sur laquelle j'ai mis mes @GET, @POST, @PUT et @DELETE
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.alysee.tp_rest.SondageResource.class);
    }
    
}
