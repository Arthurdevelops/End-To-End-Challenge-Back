package com.example.end_to_end_challenge;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Tu peux définir des méthodes comme : findByUsername(String username)
}
