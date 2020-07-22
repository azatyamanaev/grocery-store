package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TeachersRepositoryJpaImpl implements TeachersRepository {

    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from teachers where id = :teacherId";
    //language=HQL
    private final String SQL_SELECT_ALL = "select t from teachers t";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Teacher model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Teacher model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("teacherId", id).executeUpdate();
    }

    @Override
    public Optional<Teacher> find(Long id) {
        return Optional.ofNullable(entityManager.find(Teacher.class, id));
    }

    @Override
    public List<Teacher> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL, Teacher.class).getResultList();
    }
}
