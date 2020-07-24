package ru.itis.grocerystore.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class LanguageRepositoryImpl implements LanguagesRepository {
    //language=HQL
    private final String SQL_DELETE_BY_ID = "delete from Language where id = :languageId";
    //language=HQL
    private final String SQL_SELECT_ALL = "select distinct l.language from Language l";
    //language=HQL
    private final String HQL_SELECT_ID = "select distinct t.id from Language t where t.language = ?1 and t.student.id = ?2";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Language> findDistinctByLanguageIn(List<String> language) {
        return null;
    }

    @Override
    public Long findIdOfLanguage(String language, Long studentId) {
        return (Long) entityManager.createQuery(HQL_SELECT_ID).setParameter(1, language).setParameter(2, studentId).getSingleResult();
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
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter("languageId", id).executeUpdate();
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
