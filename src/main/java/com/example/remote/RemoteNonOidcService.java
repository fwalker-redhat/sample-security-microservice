package com.example.remote;

import com.example.model.Sample;
import com.example.restclient.RequestAuthHeaderFactory;
import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.arc.profile.UnlessBuildProfile;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@RegisterRestClient(configKey = "remoteService")
@RegisterClientHeaders(RequestAuthHeaderFactory.class)
@Path("/api/v1/sample")
@UnlessBuildProfile("oidcsecurity")
public interface RemoteNonOidcService {

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
