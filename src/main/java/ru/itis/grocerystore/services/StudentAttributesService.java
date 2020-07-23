package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.*;

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
    void addRecommendationLetter(RecommendationLetter recommendationLetter);
    void deleteRecommendationLetter(Long id);
}
