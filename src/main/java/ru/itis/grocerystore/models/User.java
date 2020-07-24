package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "user")
    private List<Event> eventList;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.name = builder.name;
        this.role = builder.role;
        this.state = builder.state;
        this.confirmCode = builder.confirmCode;
        this.eventList = builder.eventList;
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
        protected List<Event> eventList;

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

        public UserBuilder eventList(List<Event> eventList) {
            this.eventList = eventList;
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
