package fr.efficom.jee.crudTo.Domain;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String email;
    private String userName;
    private String avatarpath;
    private String password;
    private List<Comment> Comment = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarpath() {
        return avatarpath;
    }

    public void setAvatarpath(String avatarpath) {
        this.avatarpath = avatarpath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<fr.efficom.jee.crudTo.Domain.Comment> getComment() {
        return Comment;
    }

    public void setComment(List<fr.efficom.jee.crudTo.Domain.Comment> comment) {
        Comment = comment;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .add("userName", userName)
                .add("avatarpath", avatarpath)
                .add("password", password)
                .add("Comment", Comment)
                .toString();
    }
}
