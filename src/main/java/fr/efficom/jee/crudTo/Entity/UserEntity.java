package fr.efficom.jee.crudTo.Entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull
    private int idUser;

    @Column(name = "username")
    @NotNull
    private String userName;

    @Column(name = "email")
    @Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Veulliez de saisir une adresse mail valide.")
    private String email;

    @Column(name = "password")
    @Size(min = 12, message = "Le mot de passe doit contenir au moins 12 caractères")
    private String password;

    @Column(name = "avatar")
    private String avatarpath;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CommentEntity> comment = new ArrayList<>();

    public UserEntity() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarpath() {
        return avatarpath;
    }

    public void setAvatarpath(String avatarpath) {
        this.avatarpath = avatarpath;
    }

    public List<CommentEntity> getComment() {
        return comment;
    }

    public void setComment(List<CommentEntity> comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUser", idUser)
                .add("userName", userName)
                .add("email", email)
                .add("password", password)
                .add("avatarpath", avatarpath)
                .add("Comment", comment)
                .toString();
    }
}
