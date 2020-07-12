package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.User;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }
}
