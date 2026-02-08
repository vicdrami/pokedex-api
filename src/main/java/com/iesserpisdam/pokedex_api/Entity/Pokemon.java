package com.iesserpisdam.pokedex_api.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int idPokedex;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private PokemonType type;
    @Enumerated(EnumType.STRING)
    private PokemonEvolution evolution;
    private int height;
    private int weight;
    private LocalDateTime openedAt;

    public Pokemon () {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdPokedex() {
        return idPokedex;
    }

    public void setIdPokedex(int idPokedex) {
        this.idPokedex = idPokedex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public PokemonEvolution getEvolution() {
        return evolution;
    }

    public void setEvolution(PokemonEvolution evolution) {
        this.evolution = evolution;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }
    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }
}
