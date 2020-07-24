package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Skill;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class SkillsRepositoryImpl implements SkillsRepository {
    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from Skill where id = :skillId";
    //language=HQL
    private final String HQL_SELECT_ALL = "select distinct t.skill from Skill t";
    //language=HQL
    private final String HQL_SELECT_ID = "select distinct t.id from Skill t where t.skill = ?1 and t.student.id = ?2";
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Skill> findDistinctBySkillIn(List<String> skills) {
        //language=HQL
        String hql = "select t from Skill t";
        for (int i = 0; i < skills.size(); i++) {
            hql += " where t.skill = '" + skills.get(i) + "'";
            if (i+1 < skills.size())
                hql += " and ";
        }
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Long findIdOfSkill(String skill, Long studentId) {
        return (Long) entityManager.createQuery(HQL_SELECT_ID).setParameter(1, skill).setParameter(2, studentId).getSingleResult();
    }

    @Override
    public void save(Skill model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Skill model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("skillId", id).executeUpdate();
    }

    @Override
    public Optional<Skill> find(Long id) {
        return Optional.ofNullable(entityManager.find(Skill.class, id));
    }

    @Override
    public List<Skill> findAll() {
        return entityManager.createQuery(HQL_SELECT_ALL).getResultList();
    }
}
