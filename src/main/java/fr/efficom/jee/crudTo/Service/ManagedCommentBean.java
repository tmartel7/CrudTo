package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Entity.CommentEntity;
import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Repository.CommentRepository;
import fr.efficom.jee.crudTo.Repository.UserRepository;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ManagedCommentBean implements Serializable {


    @Inject
    private CommentService commentService;

    @Inject
    private CommentRepository commentRepository;

    @Inject
    private UserRepository userRepository;


    private UserEntity userEntity = new UserEntity();
    private CommentEntity commentEntity = new CommentEntity();

    public void create() {
        UserEntity entity = userRepository.findUserByID(userEntity.getIdUser());
        commentEntity.setOwner(entity);
        commentRepository.createComment(commentEntity);
    }

    public List<CommentEntity> getAllComment() {
        UserEntity entity = userRepository.findUserByID(userEntity.getIdUser());
        return entity.getComment();
    }

    public void delete() {
        commentRepository.deleteComment(commentEntity.getId());
    }
}
