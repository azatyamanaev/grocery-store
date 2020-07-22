package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Skill;

import java.util.List;


public interface SkillsRepository extends CrudRepository<Skill, Long> {
    List<Skill> findDistinctBySkillIn(List<String> skills);
    Long findIdOfSkill(String skill, Long studentId);
}
