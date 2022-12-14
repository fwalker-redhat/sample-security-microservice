package com.example.resource;

import com.example.model.Sample;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

public interface BackendResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Sample> getAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Sample getById(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Sample create(Sample sample);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Sample update(Sample sample);
}
