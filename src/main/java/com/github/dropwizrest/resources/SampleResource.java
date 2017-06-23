package com.github.dropwizrest.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {    
    private final AtomicLong counter;

    public SampleResource() {        
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public String sampleGet(@QueryParam("param") Optional<String> p) {
    	String param = p.isPresent() ? p.get() : "";
        return "Hey! " + param + " you have invoked me " + counter.incrementAndGet() + " times";
    }
}
