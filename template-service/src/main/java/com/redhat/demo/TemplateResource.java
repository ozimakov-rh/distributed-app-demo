package com.redhat.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.sql.Template;

import java.time.Instant;
import java.util.List;
import java.util.Random;

@Path("/template")
public class TemplateResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String randomTemplate() {
        List<TemplateEntity> templates = TemplateEntity.listAll();
        return templates.get(new Random().nextInt(templates.size())).getTemplateText();
    }

}
