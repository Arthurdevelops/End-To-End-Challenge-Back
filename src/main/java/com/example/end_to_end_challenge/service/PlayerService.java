package com.example.end_to_end_challenge.service;

import com.example.end_to_end_challenge.dto.PlayerDTO;
import com.example.end_to_end_challenge.entity.Player;
import com.example.end_to_end_challenge.exception.ResourceNotFoundException;
import com.example.end_to_end_challenge.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerRepository userRepository;

    public List<PlayerDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PlayerDTO createUser(PlayerDTO userDTO) {
        Player user = new Player();
        user.setUsername(userDTO.getUsername());
        Player savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    public PlayerDTO getPlayer(Long id) {
        Player user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return convertToDto(user);
    }

    public Player getPlayerEntity(Long id) {
        Player user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return user;
    }

    private PlayerDTO convertToDto(Player user) {
        PlayerDTO dto = new PlayerDTO();
        dto.setUsername(user.getUsername());
        return dto;
    }
}
