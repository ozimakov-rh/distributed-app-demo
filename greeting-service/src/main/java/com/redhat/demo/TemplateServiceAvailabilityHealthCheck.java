package com.redhat.demo;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
@ApplicationScoped
public class TemplateServiceAvailabilityHealthCheck implements HealthCheck {

    @RestClient
    TemplateService templateService;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Template Service availability");
        try {
            responseBuilder = responseBuilder.status(templateService.getTemplate() != null);
        } catch (Exception e) {
            e.printStackTrace();
            responseBuilder.down();
        }
        return responseBuilder.build();
    }
}
