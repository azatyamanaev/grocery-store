package ru.itis.grocerystore.repositories;

import ru.itis.grocerystore.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<User> findByConfirmCode(String code);

    Optional<User> findByEmail(String email);
}
