package com.example.end_to_end_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.end_to_end_challenge.entity.Round;

public interface RoundRepository extends JpaRepository<Round, Long> {
    // Additional query methods can be defined here if needed
    
}
