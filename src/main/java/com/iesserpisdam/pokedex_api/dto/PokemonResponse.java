package com.iesserpisdam.pokedex_api.dto;

import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PokemonResponse {
    @NotNull
    private int idPokedex;
    @NotNull
    private String name;
    @NotNull
    private PokemonType type;
    @NotNull
    private PokemonEvolution evolution;
    @Positive
    private int height;
    @Positive
    private int weight;
    private LocalDateTime openedAt;
}
