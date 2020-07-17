package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.grocerystore.models.Token;


import java.time.LocalDateTime;
import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {
    Optional<Token> findFirstByValue(String value);

    void deleteTokensByExpiredDateTimeBefore(LocalDateTime now);

    void deleteTokenByValue(String value);
}
