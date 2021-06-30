package fr.efficom.jee.crudTo.Entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "COMMENT")
public class CommentEntity implements Serializable {

    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull
    private int idUser;

    @Column(name = "createDate")
    private LocalDate createDate;

    @Column(name = "content")
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity owner;

    public CommentEntity() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUser", idUser)
                .add("createDate", createDate)
                .add("content", content)
                .add("owner", owner)
                .toString();
    }
}
