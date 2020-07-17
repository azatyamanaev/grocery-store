package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.grocerystore.models.TechnologyStack;

public interface TechnologyStackRepository extends JpaRepository<TechnologyStack, Long> {
}
