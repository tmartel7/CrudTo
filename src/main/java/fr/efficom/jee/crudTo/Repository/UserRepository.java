package fr.efficom.jee.crudTo.Repository;

import fr.efficom.jee.crudTo.Entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    public void createUser() {
        return;
    }

    public void updateUser() {
        return;
    }

    public List<UserEntity> getAllUser() {
        return new ArrayList<>();
    }

    //getaUSerByid
    //findauserByname
    //findUser

}
