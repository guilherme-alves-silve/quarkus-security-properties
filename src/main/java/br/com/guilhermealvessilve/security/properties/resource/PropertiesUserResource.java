package br.com.guilhermealvessilve.security.properties.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/properties")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class PropertiesUserResource {

    @GET
    @Path("/dev")
    @RolesAllowed({"dev", "admin"})
    public String getDevInfo() {
        return "dev info";
    }

    @GET
    @Path("/user")
    @RolesAllowed({"user", "admin"})
    public String getUserInfo(@Context SecurityContext context) {
        return context.getUserPrincipal().getName() + " info";
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    public String getAdminInfo(@Context SecurityContext context) {
        return context.getUserPrincipal().getName() + " info";
    }

    @GET
    @PermitAll
    @Path("/public")
    public String getPublicInfo() {
        return "public info";
    }
}
