package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.grocerystore.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UsersRepositoryImpl implements UsersRepository {
    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from users where id = :userId";
    //language=HQL
    private final String SQL_SELECT_ALL = "select u from users u";
    //language=HQL
    private final static String HQL_FIND_BY_LOGIN = "SELECT user FROM users user WHERE user.login =:login ";
    //language=HQL
    private final static String HQL_FIND_BY_EMAIL = "SELECT user FROM users user WHERE user.email =:email ";
    //language=HQL
    private final static String HQL_FIND_BY_CODE = "SELECT user FROM users user WHERE user.confirmCode =:code ";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User model) {
        entityManager.persist(model);
    }

    @Override
    public void update(User model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("userId", id);
    }

    @Override
    public Optional<User> find(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL, User.class).getResultList();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Query query = entityManager.createQuery(HQL_FIND_BY_LOGIN, User.class);
        query.setParameter("login", login);
        try {
            return Optional.of((User)query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByConfirmCode(String code) {
        Query query = entityManager.createQuery(HQL_FIND_BY_CODE, User.class);
        query.setParameter("code", code);
        try {
            return Optional.of((User)query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Query query = entityManager.createQuery(HQL_FIND_BY_EMAIL, User.class);
        query.setParameter("email", email);
        try {
            return Optional.of((User)query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
