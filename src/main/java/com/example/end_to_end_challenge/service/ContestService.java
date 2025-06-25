package com.example.end_to_end_challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.end_to_end_challenge.entity.Contest;
import com.example.end_to_end_challenge.repository.ContestRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContestService {
    
    @Autowired
    private ContestRepository contestRepository;

    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }

    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }
}
