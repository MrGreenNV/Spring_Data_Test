package com.example.spring_data_test.services;

import com.example.spring_data_test.models.User;
import com.example.spring_data_test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Просим фреймворк инжектнуть сгенерированную реализацию интерфейса UserRepository
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Optional<User> found = this.userRepository.
                findByUsername(user.getUsername());

        if (found.isEmpty()) {
            this.userRepository.save(user);
        }
    }
}
