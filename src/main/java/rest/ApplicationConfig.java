package rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import rest.HelloResource;

import java.util.Set;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }


    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
        resources.add(HelloResource.class);

    }
}