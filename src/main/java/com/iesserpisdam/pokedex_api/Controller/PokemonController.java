package com.iesserpisdam.pokedex_api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {
    @GetMapping("ping")
    public String ping() {
        return "¡¡¡Cázalos a todos!!!";
    }
}
