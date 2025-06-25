package com.example.end_to_end_challenge.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToMany
    @JoinTable(
        name = "contest_player",
        joinColumns = @JoinColumn(name = "player_id"),
        inverseJoinColumns = @JoinColumn(name = "contest_id")
    )
    
    private Set<Contest> contests = new HashSet<>();

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Set<Contest> getContests() {
        return contests;
    }

    public void setContests(Set<Contest> contests) {
        this.contests = contests;
    }
}
