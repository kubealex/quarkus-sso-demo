package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.reactive.NoCache;

import io.quarkus.security.identity.SecurityIdentity;

@Path("/hello")
public class GreetingResource {

    @Inject
    SecurityIdentity securityIdentity;

    @GET

    @Path("/user")
    @RolesAllowed("user")
    @NoCache
    @Produces(MediaType.TEXT_PLAIN)
    public String helloUser() {
        return "Hello " + securityIdentity.getPrincipal().getName() + " from RESTEasy Reactive";
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    @NoCache
    @Produces(MediaType.TEXT_PLAIN)
    public String helloAdmin() {
        return "Hello " + securityIdentity.getPrincipal().getName() + " to the admin console from RESTEasy Reactive";
    }
}