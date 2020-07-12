package ru.itis.grocerystore.repositories;

import java.util.Optional;
import java.util.List;

public interface CrudRepository<T, ID> {
    void save(T model);
    void update(T model);
    void delete(ID id);
    Optional<T> find(ID id);
    List<T> findAll();
}
