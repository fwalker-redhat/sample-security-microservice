package com.example.filter;

import com.example.model.RequestInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.security.identity.SecurityIdentity;
import io.vertx.core.http.HttpServerRequest;
import org.jboss.logmanager.Logger;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Provider
public class LoggingFilter implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

    @Inject
    SecurityIdentity securityIdentity;

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        final Map<String, List<String>> headers = new HashMap<>();
        context.getHeaders().entrySet().stream().map(kv -> headers.put(kv.getKey(), kv.getValue()));
        RequestInfo requestInfo = new RequestInfo(info.getPath(), context.getMethod(), request.remoteAddress().toString(), context.getHeaders(), securityIdentity.getPrincipal().getName());
        LOG.info(objectMapper.writeValueAsString(requestInfo));
    }
}
