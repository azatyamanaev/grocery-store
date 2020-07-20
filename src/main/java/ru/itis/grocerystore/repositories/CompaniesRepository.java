package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Company;

import java.util.Optional;

public interface CompaniesRepository extends CrudRepository<Company, Long> {
    Optional<Company> findByLogin(String login);
}
