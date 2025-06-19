package com.example.end_to_end_challenge.domain.port.spi;

import com.example.end_to_end_challenge.domain.model.User;
import java.util.List;

public interface UserPersistencePort {
    List<User> findAll();
    User save(User user);
    User findById(Long id);
}
