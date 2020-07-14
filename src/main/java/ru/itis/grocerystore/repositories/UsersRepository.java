package ru.itis.grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.grocerystore.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
