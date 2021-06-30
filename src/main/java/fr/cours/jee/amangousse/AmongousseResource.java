package fr.cours.jee.amangousse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("amangousse")
public class AmongousseResource {

    @Inject
    private CrewBean crewBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers() {
        return Response.ok(crewBean.getCrewMembers()).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMember(CrewMember crewMember) {
        if (crewMember.getJob() == null || crewMember.getName() == null) {
            return Response.status(403).build();
        }
        crewBean.addMember(crewMember);
        return Response.ok(crewBean.getCrewMembers().size()).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Response deleteMember(@PathParam("name") String name) {
        if (name == null || name.length() == 0) {
            return Response.status(403).build();
        }
        crewBean.deleteMember(name);
        // exo: supprimer un crewMember avec une boucle for
        return Response.ok(crewBean.getCrewMembers().size()).build();
    }
}
