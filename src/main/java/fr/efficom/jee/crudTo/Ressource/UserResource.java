package fr.efficom.jee.crudTo.Ressource;

import fr.efficom.jee.crudTo.Service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {

    @Inject
    private UserService userSrevice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllUsers() {
        //call service
        // userService.
        return Response.ok().build();
    }


}
