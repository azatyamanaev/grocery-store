package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "students")
public class Student extends User {
    private String lastName;
    private String patronymic;
    private Date birthDate;
    private String educationalLevel;
    private String university;
    private String faculty;
    private String specialization;
    private String educationEndYear;
    private String city;
    private String citizenship;
    private String gender;
    @OneToMany(mappedBy = "student")
    private List<Skill> skills;
    @OneToMany(mappedBy = "student")
    private List<Language> languages;
    private String about;
    @OneToMany(mappedBy = "student")
    private List<WorkExperience> workExperiences;
    @OneToMany(mappedBy = "student")
    private List<Achievement> achievements;
    private String linkToGit;
    private String workSchedule = "гибкий";
    private String move = "нет";
    private Boolean workSearching = true;
    @OneToMany(mappedBy = "student")
    private List<RecommendationLetter> recommendationLetters;

    private Student(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.name = builder.name;
        this.role = builder.role;
        this.state = builder.state;
        this.lastName = builder.lastName;
        this.patronymic = builder.patronymic;
        this.birthDate = builder.birthDate;
        this.educationalLevel = builder.educationalLevel;
        this.university = builder.university;
        this.faculty = builder.faculty;
        this.specialization = builder.specialization;
        this.educationEndYear = builder.educationEndYear;
        this.city = builder.city;
        this.citizenship = builder.citizenship;
        this.gender = builder.gender;
        this.skills = builder.skills;
        this.languages = builder.languages;
        this.about = builder.about;
        this.image = builder.image;
        this.workExperiences = builder.workExperiences;
        this.achievements = builder.achievements;
        this.linkToGit = builder.linkToGit;
        this.workSchedule = builder.workSchedule;
        this.move = builder.move;
        this.workSearching = builder.workSearching;
        this.recommendationLetters = builder.recommendationLetters;
        this.confirmCode = builder.confirmCode;
    }

    public static class Builder extends UserBuilder {
        private Long id;
        private String login;
        private String password;
        private String email;
        private String name;
        private Role role;
        private State state;
        private String lastName;
        private String patronymic;
        private Date birthDate;
        private String educationalLevel;
        private String university;
        private String faculty;
        private String specialization;
        private String educationEndYear;
        private String city;
        private String citizenship;
        private String gender;
        private List<Skill> skills;
        private List<Language> languages;
        private String about;
        private Image image;
        private List<WorkExperience> workExperiences;
        private List<Achievement> achievements;
        private String linkToGit;
        private String workSchedule = "гибкий";
        private String move = "нет";
        private Boolean workSearching = true;
        private List<RecommendationLetter> recommendationLetters;
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

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder educationalLevel(String educationalLevel) {
            this.educationalLevel = educationalLevel;
            return this;
        }

        public Builder university(String university) {
            this.university = university;
            return this;
        }

        public Builder faculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder educationEndYear(String educationEndYear) {
            this.educationEndYear = educationEndYear;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder citizenship(String citizenship) {
            this.citizenship = citizenship;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder skills(List<Skill> skills) {
            this.skills = skills;
            return this;
        }

        public Builder languages(List<Language> languages) {
            this.languages = languages;
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

        public Builder workExperiences(List<WorkExperience> workExperiences) {
            this.workExperiences = workExperiences;
            return this;
        }

        public Builder achievements(List<Achievement> achievements) {
            this.achievements = achievements;
            return this;
        }

        public Builder linkToGit(String linkToGit) {
            this.linkToGit = linkToGit;
            return this;
        }

        public Builder workSchedule(String workSchedule) {
            this.workSchedule = workSchedule;
            return this;
        }

        public Builder move(String move) {
            this.move = move;
            return this;
        }

        public Builder workSearching(Boolean workSearching) {
            this.workSearching = workSearching;
            return this;
        }

        public Builder recommendationLetters(List<RecommendationLetter> recommendationLetters) {
            this.recommendationLetters = recommendationLetters;
            return this;
        }

        public Builder confirmCode(String confirmCode) {
            this.confirmCode = confirmCode;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
