package com.take.complaints;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);

        // Add Jackson feature.
        resources.add(JacksonFeature.class);

        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.take.complaints.resources.JavaEE8Resource.class);
        resources.add(com.take.complaints.service.ComplaintFacadeREST.class);
        // JAX-RS resource classes added here - maintained by NetBeans.
    } //To change body of generated methods, choose Tools | Templates.

}
