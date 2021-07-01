package fr.efficom.jee.crudTo.Entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class CommentEntity implements Serializable {

    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull
    private int id;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "content")
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity owner;

    public CommentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
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
                .add("id", id)
                .add("createDate", createDate)
                .add("content", content)
                .add("owner", owner)
                .toString();
    }
}
