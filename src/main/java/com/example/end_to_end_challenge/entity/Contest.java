package com.example.end_to_end_challenge.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    private String description; 
    private String createdAt;

    @ManyToMany(mappedBy = "contests")
    private Set<Player> players = new HashSet<>();

    @OneToMany(mappedBy = "contest")
    private Set<Round> rounds = new HashSet<>();

    // Constructeur personnalisé si nécessaire
    public Contest(String name, String description) {
        this.name = name;
        this.description = description;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createdAt = dateFormat.format(new Date());
    }
}