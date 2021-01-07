package de.predikant.conference.web.rest;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Readiness
public class ReadyCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named("Conference-REST")
                .withData("ready", true).up().build();
    }
}