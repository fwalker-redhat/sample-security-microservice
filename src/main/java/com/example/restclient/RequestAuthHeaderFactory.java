package com.example.restclient;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.DefaultClientHeadersFactoryImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RequestAuthHeaderFactory extends DefaultClientHeadersFactoryImpl {

    @ConfigProperty(name = "basicauth.username")
    Optional<String> username;

    @ConfigProperty(name = "basicauth.password")
    Optional<String> password;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> propagatedHeaders = super.update(incomingHeaders, clientOutgoingHeaders);
        getBasicAuth().ifPresent(u -> propagatedHeaders.put("Authorization", List.of(u)));
        return propagatedHeaders;
    }

    private Optional<String> getBasicAuth() {
        String basicAuth;
        if (username.isPresent() && password.isPresent()) {
            String unencoded = username.get() + ":" + password.get();
            basicAuth = Base64.getEncoder().encodeToString(unencoded.getBytes());
            return Optional.of("Basic " + basicAuth);
        }
        return Optional.empty();
    }
}
