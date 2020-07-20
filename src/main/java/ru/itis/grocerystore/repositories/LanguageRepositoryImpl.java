package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguagesRepository {
    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from Language where id = :languageId";
    //language=HQL
    private final String SQL_SELECT_ALL = "select distinct l.language from Language l";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Language> findDistinctByLanguageIn(List<String> language) {
        return null;
    }

    @Override
    public void save(Language model) {
        entityManager.persist(model);
    }

    @Override
    public void update(Language model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("languageId", id);
    }

    @Override
    public Optional<Language> find(Long id) {
        return Optional.ofNullable(entityManager.find(Language.class, id));
    }

    @Override
    public List<Language> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL).getResultList();
    }

}
