package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Domain.Comment;
import fr.efficom.jee.crudTo.Entity.CommentEntity;
import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Mapper.CommentMapper;
import fr.efficom.jee.crudTo.Repository.CommentRepository;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CommentService {

    @Inject
    private CommentRepository commentRepository;
    @Inject
    private UserService userService;


    public void createComment(Comment comment) {
        if (comment != null && StringUtils.isNotEmpty(comment.getUserEmail()) && StringUtils.isNotEmpty(comment.getContent())) {
            UserEntity userEntity = userService.findByEmail(comment.getUserEmail());
            CommentEntity commentEntity = CommentMapper.domainToEntity(comment, userEntity);
            commentRepository.createComment(commentEntity);
        } else {
            throw new BadRequestException("les paramètre sont incorrecte");
        }
    }

    public void deleteComment(Comment comment) {
        if (comment != null && StringUtils.isNotEmpty(comment.getUserEmail()) && comment.getCreateDate() != null) {
            CommentEntity commentEntity = commentRepository.findByEmailAndDate(comment.getUserEmail(), comment.getCreateDate());
            if (commentEntity != null) {
                commentRepository.deleteComment(commentEntity);
            } else {
                throw new EntityNotFoundException("le commentaire n'as pas été trouvé");
            }
        } else {
            throw new BadRequestException("les paramètre sont incorrecte");
        }
    }
}
