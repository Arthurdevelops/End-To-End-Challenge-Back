package com.example.end_to_end_challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.end_to_end_challenge.dto.ContestDTO;
import com.example.end_to_end_challenge.dto.PlayerDTO;
import com.example.end_to_end_challenge.service.ContestService;

@RestController
@RequestMapping("/api/contests")
@CrossOrigin(origins = "*")
//Revoir ce que ça fait
@Validated
public class ContestController {
    
    @Autowired
    private ContestService contestService;

    @PostMapping
    public ResponseEntity<ContestDTO> createContest(@RequestBody ContestDTO contest) {
        contestService.createContest(contest);
        return ResponseEntity.ok(contest);
    }

    @GetMapping
    public ResponseEntity<List<ContestDTO>> getContests() {
        contestService.getAllContests();
        return ResponseEntity.ok(contestService.getAllContests());
    }

    @PostMapping("/{contestId}/players/{playerId}")
    public ResponseEntity<ContestDTO> addPlayerToContest(@PathVariable Long contestId, @PathVariable Long playerId) {
        ContestDTO contest = contestService.addPlayerToContest(contestId, playerId);
        return ResponseEntity.ok(contest);
    }

    @GetMapping("/{contestId}/players")
    public ResponseEntity<List<PlayerDTO>> getPlayersInContest(@PathVariable Long contestId) {
        List<PlayerDTO> players = contestService.getPlayersOfContest(contestId);
        System.out.println("Players in contest: " + players);
        return ResponseEntity.ok(players);
    }
}
