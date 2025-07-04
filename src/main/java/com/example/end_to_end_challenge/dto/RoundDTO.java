package com.example.end_to_end_challenge.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundDTO {
    private Long id;
    private String createdAt;
    private Long roundId;
    private Long contestId;
    private List<RoundScoreDTO> scores;
}

