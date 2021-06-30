package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Entity.UserEntity;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class ManagedUserBean implements Serializable {

    @Inject
    private UserService userService;

    private UserEntity userEntity = new UserEntity();

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    //connect


    //create
}
