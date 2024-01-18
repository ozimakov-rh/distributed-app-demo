package com.redhat.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TemplateMetrics {

    @Inject
    MeterRegistry meterRegistry;

    @Startup
    @Scheduled(every = "60s")
    void updateMetrics() {
        try {
            var templateCount = TemplateEntity.count();
            meterRegistry.gauge("app.template.count", templateCount);
        } catch (Exception e) {
            meterRegistry.gauge("app.template.count", -1);
        }
    }


}
