package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.grocerystore.models.PasswordResetToken;

import java.util.Optional;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
}
