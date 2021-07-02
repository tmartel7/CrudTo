package fr.efficom.jee.crudTo.Repository;

import fr.efficom.jee.crudTo.Entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;


    public List<UserEntity> getAllUser() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = query.from(UserEntity.class);
        List<UserEntity> results = em.createQuery(query).getResultList();
        return results;
    }

    public UserEntity findFromLogin(String email, String password) {
        Query query = em.createQuery("select e from UserEntity e where e.email=:email and e.password=:pass");
        query.setParameter("email", email);
        query.setParameter("pass", password);
        return (UserEntity) query.getSingleResult();
    }

    public UserEntity createorUpdateUser(UserEntity userEntity) {
        em.persist(userEntity);
        em.flush();
        return userEntity;
    }

    public void delette(UserEntity userEntity) {
        em.remove(userEntity);
    }

    public UserEntity findUserByID(Long id) {
        Query query = em.createQuery("select e from UserEntity e where e.idUser=:id");
        query.setParameter("id", id);
        return (UserEntity) query.getSingleResult();
    }

    public UserEntity findUserByEmail(String email) {
        Query query = em.createQuery("select e from UserEntity e where e.email=:email");
        query.setParameter("email", email);
        return (UserEntity) query.getSingleResult();
    }

    public List<UserEntity> findUserByName(String username) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userEntityRoot = query.from(UserEntity.class);
        query.where(criteriaBuilder.like(userEntityRoot.get("userName"), username + "%"));

        List<UserEntity> results = em.createQuery(query).getResultList();
        return results;
    }


}
