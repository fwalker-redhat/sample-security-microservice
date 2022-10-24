package com.example.remote;

import com.example.model.Sample;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@RegisterRestClient(configKey = "remoteService")
@Path("/api/v1/sample")
@RegisterProvider(OidcClientRequestReactiveFilter.class)
@IfBuildProfile("oidcsecurity")
public interface RemoteOidcService {

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
