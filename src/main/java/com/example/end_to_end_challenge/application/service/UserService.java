package com.example.end_to_end_challenge.application.service;

import com.example.end_to_end_challenge.domain.model.User;
import com.example.end_to_end_challenge.domain.port.api.UserServicePort;
import com.example.end_to_end_challenge.domain.port.spi.UserPersistencePort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserServicePort {
    
    private final UserPersistencePort userPersistencePort;

    public UserService(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.findAll();
    }

    @Override
    public User createUser(User user) {
        return userPersistencePort.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.findById(id);
    }
}
