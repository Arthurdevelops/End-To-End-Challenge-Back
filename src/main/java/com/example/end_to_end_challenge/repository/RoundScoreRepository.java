package com.example.end_to_end_challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.end_to_end_challenge.entity.RoundScore;

public interface RoundScoreRepository extends JpaRepository<RoundScore, Long> {
    
    // Custom query to find scores by round ID
    List<RoundScore> findByRoundId(Long roundId);
    
    // Custom query to find scores by player ID
    List<RoundScore> findByPlayerId(Long playerId);
    
    // Custom query to find scores by round ID and player ID
    Optional<RoundScore> findByRoundIdAndPlayerId(Long roundId, Long playerId);
}
