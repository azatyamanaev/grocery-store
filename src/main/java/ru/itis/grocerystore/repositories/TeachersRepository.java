package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.TeacherImage;

import java.util.Optional;

public interface TeachersRepository extends CrudRepository<Teacher, Long> {
    Optional<TeacherImage> getImage(Long id);
}
