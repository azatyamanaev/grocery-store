package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    private String name;
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
    @OneToOne(mappedBy = "student")
    @Where(clause = "type = 'image/png'")
    private StudentImage image;
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
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
}
