package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.grocerystore.models.RecommendationLetter;

public interface RecommendationLetterRepository extends JpaRepository<RecommendationLetter, Long> {
}
