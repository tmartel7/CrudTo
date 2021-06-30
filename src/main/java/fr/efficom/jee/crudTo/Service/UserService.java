package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Domain.User;
import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Mapper.UserMapper;
import fr.efficom.jee.crudTo.Repository.UserRepository;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserService {

    @Inject
    private UserRepository userRepository;

    public List<User> findAllUser() {
        List<UserEntity> userEntityList = userRepository.getAllUser();
        return userEntityList.stream().map(UserMapper::EntityToDomain).collect(Collectors.toList());
    }

    public boolean isConnectValid(UserEntity userEntity) {
        if (userEntity != null && StringUtils.isNotEmpty(userEntity.getEmail()) && StringUtils.isNotEmpty(userEntity.getPassword())) {
            //      userRepository.
        }
        return false;
    }


}
