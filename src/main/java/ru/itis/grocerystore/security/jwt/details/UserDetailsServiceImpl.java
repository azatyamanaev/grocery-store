package ru.itis.grocerystore.security.jwt.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.User;
import ru.itis.grocerystore.repositories.UsersRepository;

import java.util.Optional;

@Service("myUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByLogin(login);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return new UserDetailsImpl(user);
        } else throw new UsernameNotFoundException("User not found");
    }
}
