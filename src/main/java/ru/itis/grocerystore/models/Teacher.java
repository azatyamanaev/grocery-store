package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teachers")
public class Teacher extends User {
    private String lastName;
    private String patronymic;
    private String position;
    private String about;

    private Teacher(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.name = builder.name;
        this.role = builder.role;
        this.state = builder.state;
        this.lastName = builder.lastName;
        this.patronymic = builder.patronymic;
        this.position = builder.position;
        this.about = builder.about;
        this.image = builder.image;
    }

    public static class Builder {
        private Long id;
        private String login;
        private String password;
        private String email;
        private String name;
        private Role role;
        private State state;
        private String lastName;
        private String patronymic;
        private String position;
        private String about;
        private Image image;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder state(State state) {
            this.state = state;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder about(String about) {
            this.about = about;
            return this;
        }

        public Builder image(Image image) {
            this.image = image;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
