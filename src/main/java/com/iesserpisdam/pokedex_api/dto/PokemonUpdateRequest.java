package com.iesserpisdam.pokedex_api.dto;

import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonUpdateRequest {
    @NotNull
    private String name;
    @NotNull
    private PokemonType type;
    @NotNull
    private PokemonEvolution evolution;
    private int height;
    private int weight;
}
