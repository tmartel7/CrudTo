package fr.efficom.jee.crudTo.Mapper;

import fr.efficom.jee.crudTo.Domain.Comment;
import fr.efficom.jee.crudTo.Entity.CommentEntity;
import fr.efficom.jee.crudTo.Entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static List<Comment> entityListToDomain(List<CommentEntity> commentEntities) {
        return commentEntities.stream().map(CommentMapper::entityToDomain).collect(Collectors.toList());
    }

    private static Comment entityToDomain(CommentEntity commentEntity) {
        Comment comment = new Comment();
        comment.setCreateDate(commentEntity.getCreateDate());
        comment.setContent(commentEntity.getContent());
        return comment;
    }

    public static CommentEntity domainToEntity(Comment comment, UserEntity userEntity) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCreateDate(LocalDateTime.now());
        commentEntity.setContent(comment.getContent());
        commentEntity.setOwner(userEntity);
        return commentEntity;
    }


}
