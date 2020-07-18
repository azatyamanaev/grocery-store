package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Language;

import java.util.List;


public interface LanguagesRepository extends CrudRepository<Language, Long> {

    List<Language> findDistinctByLanguageIn(List<String> language);

}
