package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Achievement;

@Repository
public interface AchievementsRepository extends JpaRepository<Achievement, Long> {
}
