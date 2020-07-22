package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Language;
import ru.itis.grocerystore.models.Skill;
import ru.itis.grocerystore.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class StudentsRepositoryJpaImpl implements StudentsRepository {

    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from students where id = :studentId";
    //language=HQL
    private final String SQL_SELECT_ALL = "select t from students t";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAllTo(List <Skill> skills, List<Language> languages) {
        //language=HQL
        String hql = "select DISTINCT t from students t join Skill s on t.id = s.student.id join Language l on l.student.id = t.id";
        for (int i = 0; i < skills.size(); i++) {
            if (i == 0)
                hql += " where (";
            hql += " s.skill = '" + skills.get(i).getSkill() + "'";
            if (i+1 < skills.size())
                hql += " and";
            if (languages.size() < 1 && i+1 ==  skills.size())
                hql += ")";
        }
        for (int i = 0; i < languages.size(); i++) {
            if (skills.size() > 0 && i == 0)
                hql += " and";
            if (skills.size() < 1 && i == 0)
                hql += " where (";
            hql += " l.language = '" + languages.get(i).getLanguage() + "'";
            if (i+1 < languages.size())
                hql += " and";
            if (i+1 == languages.size())
                hql += ")";
        }
        return entityManager.createQuery(hql, Student.class).getResultList();
    }
    @Override
    public void save(Student model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Student model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("studentId", id).executeUpdate();
    }

    @Override
    public Optional<Student> find(Long id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL, Student.class).getResultList();
    }
}
