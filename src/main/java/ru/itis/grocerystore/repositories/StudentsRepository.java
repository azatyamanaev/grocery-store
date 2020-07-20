package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.Student;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {
    List<Student> findAllTo(List<Skill> skills, List<Language> languages);
}
