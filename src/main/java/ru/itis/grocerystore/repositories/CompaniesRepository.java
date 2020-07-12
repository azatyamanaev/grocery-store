package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Company;
import ru.itis.grocerystore.models.Logo;

import java.util.Optional;

public interface CompaniesRepository extends CrudRepository<Company, Long> {
    Optional<Logo> getLogo(Long id);
    Optional<Company> findByLogin(String login);
}
