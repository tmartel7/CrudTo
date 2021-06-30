package fr.efficom.jee.crudTo.Repository;

import fr.efficom.jee.crudTo.Entity.CommentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommentRepository {


    @PersistenceContext(unitName = "prod")
    private EntityManager em;


    public void createComment(CommentEntity commentEntity) {
        em.persist(commentEntity);
    }

    public void deleteComment() {
        return;
    }

}
