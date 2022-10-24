package com.example.resource;

import com.example.model.Sample;
import com.example.remote.RemoteNonOidcService;
import com.example.restclient.RequestAuthHeaderFactory;
import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.UnlessBuildProfile;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.jboss.logmanager.Logger;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/api/v1/backend")
@UnlessBuildProfile("oidcsecurity")
public class BackendNonOidcResource implements BackendResource {

    private static final Logger LOG = Logger.getLogger(BackendNonOidcResource.class.getName());

    @Inject
    @Any
    RemoteNonOidcService backend;

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Sample> getAll() {
        LOG.info("Calling Remote");
        return backend.getAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sample getById(@PathParam("id") Long id) {
        LOG.info("Calling Remote");
        return backend.getById(id);
    }

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sample create(Sample sample) {
        LOG.info("Calling Remote");
        return backend.create(new Sample(0L, sample.getMessage()));
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sample update(Sample sample) {
        LOG.info("Calling Remote");
        return backend.update(sample);
    }
}
