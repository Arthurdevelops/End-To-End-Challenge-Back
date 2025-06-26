package com.example.end_to_end_challenge.dto;

import java.util.List;

public class RoundDTO {
    private Long roundId;
    private Long contestId;
    private List<RoundWithScoreDTO> scores;

    public Long getRoundId() {
        return roundId;
    }
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public Long getContestId() {
        return contestId;
    }
    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public List<RoundWithScoreDTO> getScores() {
        return scores;
    }
    public void setScores(List<RoundWithScoreDTO> scores) {
        this.scores = scores;
    }
}       

