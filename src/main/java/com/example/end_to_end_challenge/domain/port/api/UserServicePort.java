package com.example.end_to_end_challenge.domain.port.api;

import com.example.end_to_end_challenge.domain.model.User;
import java.util.List;

public interface UserServicePort {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
}
