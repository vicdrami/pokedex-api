package com.iesserpisdam.pokedex_api.Controller;

import com.iesserpisdam.pokedex_api.Entity.PokemonEvolution;
import com.iesserpisdam.pokedex_api.Entity.PokemonType;
import com.iesserpisdam.pokedex_api.Service.PokemonService;
import com.iesserpisdam.pokedex_api.dto.PokemonCreateRequest;
import com.iesserpisdam.pokedex_api.dto.PokemonResponse;
import com.iesserpisdam.pokedex_api.dto.PokemonUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {
    private final PokemonService service;
    public PokemonController(PokemonService service) {
        this.service = service;
    }
    @GetMapping("ping")
    public String ping() {
        return "¡¡¡Cázalos a todos!!!";
    }

    /* Crear un nuevo pokemon */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonResponse create(@Valid @RequestBody PokemonCreateRequest request) {
        return service.create(request);
    }

    /* Modificar pokemon */
    @PutMapping("/{id}")
    public PokemonResponse update(
            @PathVariable Long id,
            @Valid @RequestBody PokemonUpdateRequest request
    ) {
        return service.update(id, request);
    }

    /* Borrar pokemon */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    /* Listar todos los pokemons */
    @GetMapping
    public List<PokemonResponse> findAll() {
        return service.findAll();
    }

    /* Listar por id */
    public PokemonResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    /* Listar por tipo */
    public List<PokemonResponse> findByType(@PathVariable PokemonType type) {
        return service.findByType(type);
    }

    /* Listar por evolución */
    public List<PokemonResponse> findByEvolution(@PathVariable PokemonEvolution evolution) {
        return service.findByEvolution(evolution);
    }
}
