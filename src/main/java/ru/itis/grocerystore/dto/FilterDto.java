package ru.itis.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.grocerystore.models.Achievement;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {
    List<String> languages;
    List<String> skills;


}
