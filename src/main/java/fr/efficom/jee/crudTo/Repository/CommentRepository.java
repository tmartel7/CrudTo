package fr.efficom.jee.crudTo.Repository;

import fr.efficom.jee.crudTo.Entity.CommentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public void deleteComment(Long id) {
        CommentEntity commentEntity = findById(id);
        em.remove(commentEntity);
    }

    public CommentEntity findById(Long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<CommentEntity> query = criteriaBuilder.createQuery(CommentEntity.class);
        Root<CommentEntity> commentEntityRoot = query.from(CommentEntity.class);
        query.where(criteriaBuilder.equal(commentEntityRoot.get("id"), id));

        CommentEntity results = em.createQuery(query).getSingleResult();
        return results;
    }

    public CommentEntity findByEmailAndContent(String email, String content) {
        Query query = em.createQuery("select e from CommentEntity e where e.content=:content and e.owner.email=:email");
        query.setParameter("content", content);
        query.setParameter("email", email);
        return (CommentEntity) query.getSingleResult();
    }

}
