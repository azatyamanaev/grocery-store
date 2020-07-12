package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected String login;
    protected String password;
    protected String email;
    protected String name;
    @Enumerated(value = EnumType.STRING)
    protected Role role;
    @Enumerated(value = EnumType.STRING)
    protected State state;
}
