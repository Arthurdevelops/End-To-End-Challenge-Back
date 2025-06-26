package com.example.end_to_end_challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contest contest;
    
    private String createdAt;

    public Round() {
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    public Long getId() {
        return id;
    }
    public String getCreatedAt() {
        return createdAt;
    }  
    public Contest getContest() {
        return contest;
    }
    public void setContest(Contest contest) {
        this.contest = contest;
    }
}

