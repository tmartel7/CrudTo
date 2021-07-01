package fr.efficom.jee.crudTo.Service;

import fr.efficom.jee.crudTo.Domain.User;
import fr.efficom.jee.crudTo.Entity.UserEntity;
import fr.efficom.jee.crudTo.Mapper.UserMapper;
import fr.efficom.jee.crudTo.Repository.UserRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;
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

    public UserEntity isConnectValid(UserEntity userEntity) {
        if (userEntity != null && StringUtils.isNotEmpty(userEntity.getEmail()) && StringUtils.isNotEmpty(userEntity.getPassword())) {
            return userRepository.findFromLogin(userEntity.getEmail(), userEntity.getPassword());
        }
        return null;
    }

    public UserEntity findByEmail(String email) {
        if (StringUtils.isNotEmpty(email)) {
            UserEntity user = userRepository.findUserByEmail(email);
            if (user != null) {
                return user;
            } else {
                throw new EntityNotFoundException("l'utilisateur n'existe pas :" + email);
            }
        } else {
            throw new BadRequestException("l'email est invalide");
        }
    }

    public void delette(User user) {
        if (user != null && StringUtils.isNotEmpty(user.getEmail())) {
            UserEntity entity = findByEmail(user.getEmail());
            if (entity != null) {
                userRepository.delette(entity);
            } else {
                throw new EntityNotFoundException("l'utilisateur n'existe pas :" + user.getEmail());
            }
        } else {
            throw new BadRequestException("l'email est invalide");
        }
    }

    public List<User> findListByUserName(String userName) {
        if (StringUtils.isNotEmpty(userName)) {
            List<UserEntity> users = userRepository.findUserByName(userName);
            if (CollectionUtils.isNotEmpty(users)) {
                return users.stream().map(UserMapper::EntityToDomain).collect(Collectors.toList());
            } else {
                throw new EntityNotFoundException("aucun utilisateur trouvée");
            }
        } else {
            throw new BadRequestException("le userName est invalide");
        }
    }

    public void createUser(User user) {
        if (user != null && StringUtils.isNotEmpty(user.getEmail()) && StringUtils.isNotEmpty(user.getPassword())
                && StringUtils.isNotEmpty(user.getUserName())) {
            UserEntity entity = UserMapper.domainToEntity(user);
            userRepository.createorUpdateUser(entity);
        } else {
            throw new BadRequestException("paramètre invalide");
        }
    }

    public void updateInfo(User user) {
        if (user != null && StringUtils.isNotEmpty(user.getEmail())) {
            boolean flag = false;
            UserEntity entity = findByEmail(user.getEmail());
            if (StringUtils.isNotEmpty(user.getUserName())) {
                entity.setUserName(user.getUserName());
                flag = true;
            }
            if (StringUtils.isNotEmpty(user.getPassword())) {
                entity.setPassword(user.getPassword());
                flag = true;
            }
            if (flag) {
                userRepository.createorUpdateUser(entity);
            }
        } else {
            throw new BadRequestException("paramètre invalide");
        }
    }

}
