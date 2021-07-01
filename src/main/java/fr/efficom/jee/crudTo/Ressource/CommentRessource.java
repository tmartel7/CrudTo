package fr.efficom.jee.crudTo.Ressource;

import fr.efficom.jee.crudTo.Domain.Comment;
import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Mapper.CommentMapper;
import fr.efficom.jee.crudTo.Service.CommentService;
import fr.efficom.jee.crudTo.Service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("comment")
public class CommentRessource {

    @Inject
    private CommentService commentService;

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find/{email}")
    public Response findCommentByEmail(@PathParam("email") String email) {
        UserEntity user = userService.findByEmail(email);
        return Response.ok(CommentMapper.entityListToDomain(user.getComment())).build();
    }

    @POST
    @Consumes("application/json")
    @Path("/create")
    public Response createComment(Comment comment) {
        commentService.createComment(comment);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/delette")
    public Response createUser(Comment comment) {
        commentService.deleteComment(comment);
        return Response.ok().build();
    }


}
