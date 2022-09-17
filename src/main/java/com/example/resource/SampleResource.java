package com.example.resource;

import com.example.model.Sample;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.logmanager.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import static java.lang.String.format;

@Path("/api/v1/sample")
public class SampleResource {

    private static final Logger LOG = Logger.getLogger(SampleResource.class.getName());

    private final Map<Long, Sample> samples = new HashMap<>();

    @Inject
    SecurityIdentity securityIdentity;

    public SampleResource() {
        for (long i = 0; i < 10; i++) {
            samples.put(i + 1, new Sample(i + 1, format("Sample %s", i + 1)));
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Sample> getAll() {
        LOG.info("Returning all Samples: " + samples.size());
        return samples.values();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sample getById(@PathParam("id") Long id) {
        LOG.info(format("Returning Sample with id: %d", id));
        return samples.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sample create(Sample sample) {
        LOG.info(format("Creating Sample {\"id\" : \"%s\", \"message\" : \"%s\"}", samples.size() + 1, sample.getMessage()));
        return samples.put((long) samples.size() + 1, new Sample((long) samples.size() + 1, sample.getMessage()));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sample update(Sample sample) {
        LOG.info(format("Updating Sample {\"id\" : \"%s\", \"message\" : \"%s\"}", samples.size() + 1, sample.getMessage()));
        return samples.put(sample.getId(), sample);
    }
}