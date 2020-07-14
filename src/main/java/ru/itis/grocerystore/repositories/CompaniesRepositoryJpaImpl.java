package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CompaniesRepositoryJpaImpl implements CompaniesRepository{

    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from companies where id = :companyId";
    //language=HQL
    private final String SQL_SELECT_ALL = "select t from companies t";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Company model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Company model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("companyId", id);
    }

    @Override
    public Optional<Company> find(Long id) {
        return Optional.ofNullable(entityManager.find(Company.class, id));
    }

    @Override
    public List<Company> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL, Company.class).getResultList();
    }
}
