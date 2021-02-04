package net.luvina.coursemanagement.entity;

import lombok.Getter;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = ?1")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String name;
    protected String email;
    protected String password;

}
