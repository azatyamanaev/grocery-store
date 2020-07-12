package ru.itis.grocerystore.services;

import ru.itis.grocerystore.models.User;

public interface ProfileService {
    User getUserById(Long id);
}
