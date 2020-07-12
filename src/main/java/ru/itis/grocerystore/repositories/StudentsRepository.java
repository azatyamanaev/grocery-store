package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.*;

import java.util.Optional;
import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {
    Optional<Student> findOneByLogin(String login);
    List<Skill> getSkills(Long id);
    List<Language> getLanguages(Long id);
    Optional<StudentImage> getImage(Long id);
    List<WorkExperience> getWorkExperience(Long id);
    List<Achievement> getAchievements(Long id);
    List<RecommendationLetter> getRecommendationLetters(Long id);
}
