package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Repository.UserRepository;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ManagedUserBean implements Serializable {

    @Inject
    private UserService userService;
    @Inject
    private UserRepository userRepository;

    private UserEntity userEntity = new UserEntity();

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity connect() {
        return userService.isConnectValid(userEntity);
    }

    public UserEntity createorUpdateUser() {
        return userRepository.createorUpdateUser(userEntity);
    }

    public UserEntity findUserByID() {
        return userRepository.findUserByID(userEntity.getIdUser());
    }

    public List<UserEntity> findUserByName() {
        return userRepository.findUserByName(userEntity.getUserName());
    }
//todo
    //upload avatar
    //update user
}
