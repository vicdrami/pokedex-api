package com.iesserpisdam.pokedex_api.Controller;

import com.iesserpisdam.pokedex_api.Entity.Pokemon;
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

    /* Compropar conexión */
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
    @PutMapping("/{idPokedex}")
    public PokemonResponse update(
            @PathVariable int idPokedex,
            @Valid @RequestBody PokemonUpdateRequest request
    ) {
        return service.update(idPokedex, request);
    }

    /* Borrar pokemon */
    @DeleteMapping("/{idPokedex}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int idPokedex) {
        service.delete(idPokedex);
    }

    /* Listar todos los pokemons */
    @GetMapping
    public List<PokemonResponse> findAll() {
        return service.findAll();
    }

    /* Borrar todos los pokemons */
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@PathVariable Pokemon pokemon) {
        service.deleteAll(pokemon);
    }

    /* Listar por id de la pokedex*/
    @GetMapping("/{idPokedex}")
    public PokemonResponse findByIdPokedex(@PathVariable int idPokedex) {
        return service.findByIdPokedex(idPokedex);
    }

    /* Listar por tipo */
    @GetMapping("/type/{type}")
    public List<PokemonResponse> findByType(@PathVariable PokemonType type) {
        return service.findByType(type);
    }

    /* Listar por evolución */
    @GetMapping("/evolution/{evolution}")
    public List<PokemonResponse> findByEvolution(@PathVariable PokemonEvolution evolution) {
        return service.findByEvolution(evolution);
    }
}
