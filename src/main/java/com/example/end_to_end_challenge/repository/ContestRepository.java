package com.example.end_to_end_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.end_to_end_challenge.entity.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {
    // Define any custom query methods if needed
    
}
