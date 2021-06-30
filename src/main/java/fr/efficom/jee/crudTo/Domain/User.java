package fr.efficom.jee.crudTo.Domain;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String email;
    private String avatarpath;
    private List<Comment> Comment = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarpath() {
        return avatarpath;
    }

    public void setAvatarpath(String avatarpath) {
        this.avatarpath = avatarpath;
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
                .add("avatarpath", avatarpath)
                .add("Comment", Comment)
                .toString();
    }
}
