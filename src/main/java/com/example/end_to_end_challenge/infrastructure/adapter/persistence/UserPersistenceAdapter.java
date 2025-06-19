package com.example.end_to_end_challenge.infrastructure.adapter.persistence;

import com.example.end_to_end_challenge.domain.model.User;
import com.example.end_to_end_challenge.domain.port.spi.UserPersistencePort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserJpaRepository userJpaRepository;

    public UserPersistenceAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapToEntity(user);
        entity = userJpaRepository.save(entity);
        return mapToDomain(entity);
    }

    @Override
    public User findById(Long id) {
        return userJpaRepository.findById(id)
                .map(this::mapToDomain)
                .orElse(null);
    }

    private User mapToDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getName(), entity.getEmail());
    }

    private UserEntity mapToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        return entity;
    }
}
