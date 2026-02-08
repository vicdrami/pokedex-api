package com.iesserpisdam.pokedex_api.Repository;

import com.iesserpisdam.pokedex_api.Entity.Pokemon;
import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByType(PokemonType type);
    List<Pokemon> findByEvolution(PokemonEvolution evolution);
    List<Pokemon> findByTypeAndEvolution(PokemonType type, PokemonEvolution evolution);
}
