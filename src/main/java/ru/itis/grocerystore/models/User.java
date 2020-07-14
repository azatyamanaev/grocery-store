package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String login;
    protected String password;
    protected String email;
    protected String name;
    @Enumerated(value = EnumType.STRING)
    protected Role role;
    @Enumerated(value = EnumType.STRING)
    protected State state;
    @OneToOne(mappedBy = "user")
    protected Image image;

}
