package com.jjeanjacques.pokemoncenter.application.impl

import com.jjeanjacques.pokemoncenter.application.PokemonService
import com.jjeanjacques.pokemoncenter.domain.Pokemon
import com.jjeanjacques.pokemoncenter.domain.enums.Type.*
import com.jjeanjacques.pokemoncenter.exception.TypeNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class PokemonServiceImpl : PokemonService {
    override fun curePokemon(pokemon: Pokemon) {
        var process = when (pokemon.type) {
            BUG -> "Healing Bug Pokémon with a Herbal Elixir"
            ELECTRIC -> "Reviving Electric Pokémon with Lightning Sparks"
            ROCK -> "Restoring Rock Pokémon with Mystic Gemstones"
            NORMAL -> "Rejuvenating Normal Pokémon with Tranquil Harmony"
            FIRE -> "Curing Fire Pokémon with an Intense Inferno Bath"
            WATER -> "Healing Water Pokémon with the Soothing Ocean Waves"
            else -> throw TypeNotFoundException("Type not found - ${pokemon.type}")
        }
        log.info("$process - $pokemon")
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}