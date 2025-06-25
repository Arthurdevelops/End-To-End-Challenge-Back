package com.example.end_to_end_challenge.dto;

import java.util.List;

public class ContestDTO {
    private String name;
    private String description;
    private String createdAt;
    private List<PlayerDTO> players;


    public String getName() {
        return name;
    }   

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public List<PlayerDTO> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

}