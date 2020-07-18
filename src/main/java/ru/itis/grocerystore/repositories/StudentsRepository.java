package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.*;

import java.util.Optional;
import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {
    List<Student> findAllTo(List <Skill> skills, List<Language> languages);
}
