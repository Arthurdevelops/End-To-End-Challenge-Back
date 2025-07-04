package com.example.end_to_end_challenge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundScoreDTO {
    private Long id;
    private Long playerId;
    private int score;
}
