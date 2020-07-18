package ru.itis.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentSearchDto {
    private Long id;
    private String name;
    private String lastName;
    private List<Skill> skills;
    private List<Language> languages;
}
