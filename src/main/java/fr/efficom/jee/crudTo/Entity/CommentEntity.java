package fr.efficom.jee.crudTo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
public class CommentEntity {

    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idUser;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "content")
    private string content;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity owner;

    public

}
