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
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public static List<Language> fromStringToLanguage(List<String> list) {
        List<Language> languages = new ArrayList<>();
        if (list == null)
            return languages;
        for (String string: list)
            languages.add(Language.builder().language(string).build());
        return languages;
    }
}
