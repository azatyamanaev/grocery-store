package ru.itis.grocerystore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skill;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public static List<Skill> fromStringToSkill(List<String> list) {
        List<Skill> skills = new ArrayList<>();
        if (list == null)
            return skills;
        for (String string: list)
            skills.add(Skill.builder().skill(string).build());
        return skills;
    }
}
