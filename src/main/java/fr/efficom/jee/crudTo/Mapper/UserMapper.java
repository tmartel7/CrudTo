package fr.efficom.jee.crudTo.Mapper;

import fr.efficom.jee.crudTo.Domain.User;
import fr.efficom.jee.crudTo.Entity.UserEntity;

public class UserMapper {

    public static User EntityToDomain(UserEntity userEntity) {
        User user = new User();
        user.setAvatarpath(userEntity.getAvatarpath());
        user.setEmail(userEntity.getEmail());
        user.setUserName(userEntity.getUserName());
        user.setComment(CommentMapper.entityListToDomain(userEntity.getComment()));
        return user;
    }

    public static UserEntity domainToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
