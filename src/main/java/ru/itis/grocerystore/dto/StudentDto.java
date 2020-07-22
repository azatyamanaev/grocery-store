package ru.itis.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.grocerystore.models.Achievement;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.WorkExperience;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private String name;
    private String lastName;
    private String patronymic;
    private String birthDate;
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
    private List<WorkExperience> workExperiences;
    private List<Achievement> achievements;
    private String linkToGit;
    private String workSchedule = "гибкий";
    private String move = "нет";
}
