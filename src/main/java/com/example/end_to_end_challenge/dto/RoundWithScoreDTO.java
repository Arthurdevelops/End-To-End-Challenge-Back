package com.example.end_to_end_challenge.dto;

public class RoundWithScoreDTO {
    private Long playerId;
    private Integer score;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
