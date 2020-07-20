package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Language;

import java.util.List;


public interface LanguagesRepository extends CrudRepository<Language, Long> {

    List<Language> findDistinctByLanguageIn(List<String> language);

}
