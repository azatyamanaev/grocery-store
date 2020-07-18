package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Achievement;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.Student;

import java.util.List;

@Repository
public interface StudentsJpaRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByLanguagesInAndSkillsIn(List<Language> languages,
                                                   List<Skill> skills);
}
