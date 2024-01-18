package com.redhat.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/template")
@RegisterRestClient(configKey = "template-api")
public interface TemplateService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getTemplate();

}
