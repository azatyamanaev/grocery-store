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
@Entity(name = "companies")
public class Company extends User {
    private String linkToSite;
    private String about;
    private String number;
    private String additionalInformation;


    private Company(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.name = builder.name;
        this.role = builder.role;
        this.state = builder.state;
        this.linkToSite = builder.linkToSite;
        this.about = builder.about;
        this.number = builder.number;
        this.additionalInformation = builder.additionalInformation;
        this.image = builder.image;
        this.confirmCode = builder.confirmCode;
    }

    public static class Builder {
        private Long id;
        private String login;
        private String password;
        private String email;
        private String name;
        private Role role;
        private State state;
        private String linkToSite;
        private String about;
        private String number;
        private String additionalInformation;
        private Image image;
        private String confirmCode;

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

        public Builder linkToSite(String linkToSite) {
            this.linkToSite = linkToSite;
            return this;
        }

        public Builder about(String about) {
            this.about = about;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder additionalInformation(String additionalInformation) {
            this.additionalInformation = additionalInformation;
            return this;
        }

        public Builder image(Image image) {
            this.image = image;
            return this;
        }

        public Builder confirmCode(String confirmCode) {
            this.confirmCode = confirmCode;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
