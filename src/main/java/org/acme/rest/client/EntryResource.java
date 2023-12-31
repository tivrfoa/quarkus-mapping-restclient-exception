package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class EntryResource {

    @Inject
    @RestClient
    ExtensionsService extensionsService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try {
            extensionsService.getBad();
            throw new RuntimeException("It should have thrown CorreiosException");
        } catch (CorreiosException e) {
            System.err.println(e);
            return "ooops - ping back : " + e.getMessage();
        }
    }
}

