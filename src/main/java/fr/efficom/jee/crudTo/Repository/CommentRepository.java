package fr.efficom.jee.crudTo.Repository;

import fr.efficom.jee.crudTo.Entity.CommentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class CommentRepository {


    @PersistenceContext(unitName = "prod")
    private EntityManager em;


    public void createComment(CommentEntity commentEntity) {
        em.persist(commentEntity);
    }

    public void deleteComment(int id) {
        em.remove(findById(id));
    }

    public CommentEntity findById(int id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<CommentEntity> query = criteriaBuilder.createQuery(CommentEntity.class);
        Root<CommentEntity> commentEntityRoot = query.from(CommentEntity.class);
        query.where(criteriaBuilder.equal(commentEntityRoot.get("id"), id));

        CommentEntity results = em.createQuery(query).getSingleResult();
        return results;
    }

}
