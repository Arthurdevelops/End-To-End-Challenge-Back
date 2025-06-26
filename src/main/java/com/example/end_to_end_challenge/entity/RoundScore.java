package com.example.end_to_end_challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RoundScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Round round;

    @ManyToOne
    private Player player;

    private int score;

    public RoundScore() {
        this.score = 0;
    }

    public Round getRound() {
        return round;
    }
    public void setRound(Round round) {
        this.round = round;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }   
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
}
