package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

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
    protected String confirmCode;
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.name = builder.name;
        this.role = builder.role;
        this.state = builder.state;
        this.confirmCode = builder.confirmCode;
    }

    public static class UserBuilder {
        protected Long id;
        protected String login;
        protected String password;
        protected String email;
        protected String name;
        protected Role role;
        protected State state;
        protected Image image;
        protected String confirmCode;

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserBuilder state(State state) {
            this.state = state;
            return this;
        }

        public UserBuilder image(Image image) {
            this.image = image;
            return this;
        }

        public UserBuilder confirmCode(String confirmCode) {
            this.confirmCode = confirmCode;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }
}
