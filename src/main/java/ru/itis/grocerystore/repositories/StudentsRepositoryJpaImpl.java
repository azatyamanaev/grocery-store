package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
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
    public void save(Student model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Student model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("studentId", id);
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
