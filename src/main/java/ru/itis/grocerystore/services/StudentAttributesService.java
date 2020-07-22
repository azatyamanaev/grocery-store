package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.Achievement;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.WorkExperience;

public interface StudentAttributesService {
    void addWorkExp(WorkExperience workExperience);
    void addLanguage(Language language);
    void addSkill(Skill skill);
    void addAchievement(Achievement achievement);
    void deleteWorkExp(Long id);
    void deleteLanguage(Long id);
    void deleteSkill(Long id);
    void deleteAchievement(Long id);
    Long findIdOfSkill(String skill, Long studentId);
    Long findIdOfLanguage(String language, Long studentId);
}
