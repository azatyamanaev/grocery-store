package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Skill;

import java.util.List;


public interface SkillsRepository extends CrudRepository<Skill, Long> {
    List<Skill> findDistinctBySkillIn(List<String> skills);
}
