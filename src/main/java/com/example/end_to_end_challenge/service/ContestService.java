package com.example.end_to_end_challenge.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.end_to_end_challenge.dto.ContestDTO;
import com.example.end_to_end_challenge.dto.PlayerDTO;
import com.example.end_to_end_challenge.entity.Contest;
import com.example.end_to_end_challenge.entity.Player;
import com.example.end_to_end_challenge.repository.ContestRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContestService {
    
    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private PlayerService playerService;

    public ContestDTO createContest(ContestDTO contest) {
        Contest contestEntity = new Contest();
        contestEntity.setName(contest.getName());
        contestEntity.setDescription(contest.getDescription());
        contestRepository.save(contestEntity);
        return contest;
    }

    public List<ContestDTO> getAllContests() {
        List<Contest> contests = contestRepository.findAll();
        return contests.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public Contest getContest(Long contestId) {
        return contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found with id: " + contestId));
    }

    public ContestDTO addPlayerToContest(Long contestId, Long playerId) {
        Contest contest = getContest(contestId);
        Player player = playerService.getPlayerEntity(playerId); 

        // Ajout du player au contest des deux côtés sinon on a une erreur de persistance
        contest.getPlayers().add(player);
        player.getContests().add(contest);

        Contest savedContest = contestRepository.save(contest);
        return convertToDTO(savedContest);
    }   

    public List<PlayerDTO> getPlayersOfContest(Long contestId) {
        Contest contest = getContest(contestId);
        Set<Player> playerSet = contest.getPlayers();
        
        return playerSet.stream()
                .map(player -> {
                    PlayerDTO dto = new PlayerDTO();
                    dto.setUsername(player.getUsername());
                    return dto;
                })
                .toList();
    }

    private ContestDTO convertToDTO(Contest contest) {
        ContestDTO dto = new ContestDTO();
        dto.setName(contest.getName());
        dto.setDescription(contest.getDescription());
        dto.setCreatedAt(contest.getCreatedAt());
        
        // Conversion du Set<Player> en List<PlayerDTO>
        List<PlayerDTO> playerDTOs = contest.getPlayers().stream()
            .map(player -> {
                PlayerDTO playerDTO = new PlayerDTO();
                playerDTO.setUsername(player.getUsername());
                return playerDTO;
            })
            .toList();
        
        dto.setPlayers(playerDTOs);
        return dto;
    }
}
