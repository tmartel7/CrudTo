package fr.efficom.jee.crudTo.Mapper;

import fr.efficom.jee.crudTo.Domain.Comment;
import fr.efficom.jee.crudTo.Entity.CommentEntity;

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


}
