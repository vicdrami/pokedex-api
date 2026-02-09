package com.iesserpisdam.pokedex_api.Service;

import com.iesserpisdam.pokedex_api.Entity.Pokemon;
import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import com.iesserpisdam.pokedex_api.Repository.PokemonRepository;
import com.iesserpisdam.pokedex_api.dto.PokemonCreateRequest;
import com.iesserpisdam.pokedex_api.dto.PokemonResponse;
import com.iesserpisdam.pokedex_api.dto.PokemonUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class PokemonService {
    private final PokemonRepository repository;
    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    /* Crear nuevo pokemon */
    public PokemonResponse create(PokemonCreateRequest request) {
        Pokemon pokemon = new Pokemon();
        pokemon.setIdPokedex(request.getIdPokedex());
        pokemon.setName(request.getName());
        pokemon.setEvolution(request.getEvolution());
        pokemon.setType(request.getType());
        pokemon.setHeight(request.getHeight());
        pokemon.setWeight(request.getWeight());
        pokemon.setOpenedAt(LocalDateTime.now());

        /* Validaciones de entrada */
        if(repository.existsByName(request.getName())){
            throw new IllegalArgumentException("¡Ya existe un pokemon con este nombre!");
        }
        if(repository.existsByIdPokedex(request.getIdPokedex())){
            throw new IllegalArgumentException("¡Ya existe un pokemon con este id en la pokedex!");
        }

        Pokemon newPokemon = repository.save(pokemon);
        return mapToResponse(newPokemon);
    }

    /* Modificar pokemon */
    public PokemonResponse update(Long id, PokemonUpdateRequest request) {
        Pokemon pokemon = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "¡No se ha encontrado el pokemon con el id: " + id + "!"
                ));
        pokemon.setIdPokedex(request.getIdPokedex());
        pokemon.setName(request.getName());
        pokemon.setEvolution(request.getEvolution());
        pokemon.setType(request.getType());
        pokemon.setHeight(request.getHeight());
        pokemon.setWeight(request.getWeight());
        pokemon.setOpenedAt(LocalDateTime.now());

        /* Validaciones de entrada */
        if(repository.existsByName(request.getName())){
            throw new IllegalArgumentException("¡Ya existe un pokemon con este nombre!");
        }
        if(repository.existsByIdPokedex(request.getIdPokedex())){
            throw new IllegalArgumentException("¡Ya existe un pokemon con este id en la pokedex!");
        }

        Pokemon updatePokemon = repository.save(pokemon);
        return mapToResponse(updatePokemon);
    }

    /* Borrar pokemon */
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "¡No se ha encontrado el pokemon con el id: " + id + "!"
            );
        }
        repository.deleteById(id);
    }

    /* Listar todos los pokemons */
    public List<PokemonResponse> findAll() {
        return repository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    /* Listar por id*/
    public PokemonResponse findById(Long id) {
        Pokemon pokemon = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "¡No se ha encontrado el pokemon con el id: " + id + "!"
                        ));
        return mapToResponse(pokemon);
    }

    /* Listar por tipo */
    public List<PokemonResponse> findByType(PokemonType type) {
        return repository.findByType(type)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    /* Listar por evolución */
    public List<PokemonResponse> findByEvolution(PokemonEvolution evolution) {
        return repository.findByEvolution(evolution)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private PokemonResponse mapToResponse(Pokemon pokemon) {
        PokemonResponse response = new PokemonResponse();
        response.setIdPokedex(pokemon.getIdPokedex());
        response.setName(pokemon.getName());
        response.setType(pokemon.getType());
        response.setEvolution(pokemon.getEvolution());
        response.setHeight(pokemon.getHeight());
        response.setWeight(pokemon.getWeight());
        response.setOpenedAt(pokemon.getOpenedAt());
        return response;
    }
}
