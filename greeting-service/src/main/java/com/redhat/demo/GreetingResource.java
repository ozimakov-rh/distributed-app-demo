package com.redhat.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Instant;

@Path("/hello")
public class GreetingResource {

    @RestClient
    TemplateService templateService;

    @GET
    @Path("/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingPayload hello(@PathParam("userName") String userName) {
        return new GreetingPayload(userName, Instant.now(), String.format(templateService.getTemplate(), userName));
    }
}
