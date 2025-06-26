package com.example.end_to_end_challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.end_to_end_challenge.dto.RoundDTO;
import com.example.end_to_end_challenge.dto.RoundWithScoreDTO;
import com.example.end_to_end_challenge.entity.Round;
import com.example.end_to_end_challenge.entity.RoundScore;
import com.example.end_to_end_challenge.repository.RoundRepository;
import com.example.end_to_end_challenge.repository.RoundScoreRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoundService {
    
    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private RoundScoreRepository roundScoreRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ContestService contestService;

    public RoundDTO createRound(RoundDTO roundDTO) {
        Round round = new Round();
        round.setContest(contestService.getContest(roundDTO.getContestId()));
        for (RoundWithScoreDTO scoreDTO : roundDTO.getScores()) {
            RoundScore score = new RoundScore();
            score.setRound(round);
            score.setScore(scoreDTO.getScore());
            score.setPlayer(playerService.getPlayerEntity(scoreDTO.getPlayerId()));
            roundScoreRepository.save(score);
        }
        roundRepository.save(round);
        return roundDTO;
    }

    public List<RoundDTO> getRounds() {
        List<Round> rounds = roundRepository.findAll();
        List<RoundScore> scores = roundScoreRepository.findAll();
        List<RoundDTO> dtos = new ArrayList<RoundDTO>();
        for (Round round : rounds) {
            RoundDTO dto = new RoundDTO();
            dto.setRoundId(round.getId());
            List<RoundWithScoreDTO> scoreDTOs = new ArrayList<>();
            for (RoundScore score : scores) {
                if (score.getRound().getId().equals(round.getId())) {
                    RoundWithScoreDTO scoreDTO = new RoundWithScoreDTO();
                    scoreDTO.setPlayerId(score.getPlayer().getId());
                    scoreDTO.setScore(score.getScore());
                    scoreDTOs.add(scoreDTO);
                }
            }
            dto.setScores(scoreDTOs);
            dtos.add(dto);
        }
        return dtos;
    }
}