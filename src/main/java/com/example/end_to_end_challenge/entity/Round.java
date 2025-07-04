package com.example.end_to_end_challenge.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String createdAt;

    @ManyToOne
    private Contest contest;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
    private Set<RoundScore> scores = new HashSet<>();

    public Round() {
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
}

