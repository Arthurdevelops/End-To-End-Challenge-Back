package com.example.end_to_end_challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.end_to_end_challenge.dto.RoundDTO;
import com.example.end_to_end_challenge.service.RoundService;

@RestController
@RequestMapping("/api/rounds")
@CrossOrigin(origins = "*")
public class RoundController {

    @Autowired
    private RoundService roundService;  

    @PostMapping
    public ResponseEntity<RoundDTO> createRound(@RequestBody RoundDTO roundDTO) {
        RoundDTO createdRound = roundService.createRound(roundDTO);
        return new ResponseEntity<>(createdRound, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoundDTO>> getRounds() {
        List<RoundDTO> rounds = roundService.getRounds();
        return ResponseEntity.ok(rounds);   
    }
}
