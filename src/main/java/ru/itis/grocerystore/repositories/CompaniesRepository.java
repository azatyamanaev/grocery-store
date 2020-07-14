package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.Company;
import ru.itis.grocerystore.models.Image;

import java.util.Optional;

public interface CompaniesRepository extends CrudRepository<Company, Long> {
}
