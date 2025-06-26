package com.example.end_to_end_challenge.controller;

import com.example.end_to_end_challenge.dto.PlayerDTO;
import com.example.end_to_end_challenge.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getUsers() {
        return ResponseEntity.ok(playerService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayer(id));
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createUser(@RequestBody PlayerDTO userDTO) {
        PlayerDTO createdUser = playerService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
