package com.iesserpisdam.pokedex_api.dto;

import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonCreateRequest {
    private int idPokedex;
    @NotNull
    private String name;
    @NotNull
    private PokemonType type;
    @NotNull
    private PokemonEvolution evolution;
    private int height;
    private int weight;

}
