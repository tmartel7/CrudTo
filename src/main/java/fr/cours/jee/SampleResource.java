package fr.cours.jee;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sample")
public class SampleResource {

    @Inject
    @ConfigProperty(name = "message")
    private String message;

    @GET
    public Response message() {
        return Response.ok(message).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/titans")
    public Response getTitans() {
        // src: https://attaque-des-titans.fandom.com/fr/wiki/Titans
        String titans[] = {"Titan Colossal", "Titan Cuirassé", "Titan Assaillant", "Titan Féminin", "Titan Mâchoire",
                "Titan Bestial",
                "Titan Charrette",
                "Titan Marteau d'Armes", "Titan Originel"};
        return Response.ok(titans).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public Response testPost(TestJsonResource testJsonResource) {
        if (testJsonResource.getName() == null) {
            return Response.status(403).build();
        }
        return Response.ok("Posted " + testJsonResource.getName() + ". Age: " + testJsonResource.getAge()).build();
    }
}
