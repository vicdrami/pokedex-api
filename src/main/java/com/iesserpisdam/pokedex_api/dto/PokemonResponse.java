package com.iesserpisdam.pokedex_api.dto;

import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PokemonResponse {
    private int idPokedex;
    private String name;
    private PokemonType type;
    private PokemonEvolution evolution;
    private int height;
    private int weight;
    private LocalDateTime openedAt;
}
