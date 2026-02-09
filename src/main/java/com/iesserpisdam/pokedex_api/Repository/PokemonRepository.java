package com.iesserpisdam.pokedex_api.Repository;

import com.iesserpisdam.pokedex_api.Entity.Pokemon;
import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByIdPokedex(int idPokedex);
    void deleteByIdPokdex(int idPokedex);
    List<Pokemon> findByType(PokemonType type);
    List<Pokemon> findByEvolution(PokemonEvolution evolution);

    boolean existsByName(String name);
    boolean existsByIdPokedex(int idPokedex);
}
