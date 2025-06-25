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

import com.example.end_to_end_challenge.entity.Contest;
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
    public ResponseEntity<Contest> createContest(@RequestBody Contest contest) {
        contestService.createContest(contest);
        return ResponseEntity.ok(contest);
    }

    @GetMapping
    public ResponseEntity<List<Contest>> getContests() {
        contestService.getAllContests();
        return ResponseEntity.ok(contestService.getAllContests());
    }
}
