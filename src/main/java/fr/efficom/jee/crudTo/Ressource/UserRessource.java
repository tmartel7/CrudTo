package fr.efficom.jee.crudTo.Ressource;

import fr.efficom.jee.crudTo.Domain.User;
import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Mapper.UserMapper;
import fr.efficom.jee.crudTo.Service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserRessource {

    @Inject
    private UserService userSrevice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllUsers() {
        return Response.ok(userSrevice.findAllUser()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/email/{email}")
    public Response findUserByEmail(@PathParam("email") String email) {
        UserEntity entity = userSrevice.findByEmail(email);
        return Response.ok(UserMapper.EntityToDomain(entity)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/username/{username}")
    public Response findListUserByUserName(@PathParam("username") String userName) {
        return Response.ok(userSrevice.findListByUserName(userName)).build();
    }

    @POST
    @Consumes("application/json")
    @Path("/create")
    public Response createUser(User user) {
        userSrevice.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    // update possible du password ou/et username
    @PUT
    @Consumes("application/json")
    @Path("/update")
    public Response updateInfo(User user) {
        userSrevice.updateInfo(user);
        return Response.ok().build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delette")
    public Response deleteUser(User user) {
        userSrevice.delette(user);
        return Response.ok().build();
    }
}
