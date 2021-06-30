package fr.efficom.jee.crudTo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity {

    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idUser;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "password")
    private String password;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    public UserEntity() {
    }

    public UserEntity(String pseudo, String password, String lastName, String firstName) {
        this.pseudo = pseudo;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}