package com.example.resource;

import com.example.model.Sample;
import com.example.remote.SampleRemoteService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logmanager.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/api/v1/backend")
public class BackendResource {

    private static final Logger LOG = Logger.getLogger(BackendResource.class.getName());

    @Inject
    @RestClient
    SampleRemoteService backend;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Sample> getAll() {
        LOG.info("Calling Remote");
        return backend.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sample getById(@PathParam("id") Long id) {
        LOG.info("Calling Remote");
        return backend.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sample create(Sample sample) {
        LOG.info("Calling Remote");
        return backend.create(new Sample(0L, sample.getMessage()));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sample update(Sample sample) {
        LOG.info("Calling Remote");
        return backend.update(sample);
    }
}
