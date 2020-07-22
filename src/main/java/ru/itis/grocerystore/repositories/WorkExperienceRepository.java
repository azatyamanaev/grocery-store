package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.grocerystore.models.WorkExperience;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {

}
