package com.jjeanjacques.pokemoncenter.application.impl

import com.jjeanjacques.pokemoncenter.adapter.persistence.PokemonRepository
import com.jjeanjacques.pokemoncenter.adapter.persistence.entity.PokemonEntity
import com.jjeanjacques.pokemoncenter.application.PokemonService
import com.jjeanjacques.pokemoncenter.domain.Pokemon
import com.jjeanjacques.pokemoncenter.domain.enums.Type.*
import com.jjeanjacques.pokemoncenter.exception.TypeNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class PokemonServiceImpl(val pokemonRepository: PokemonRepository) : PokemonService {
    override fun curePokemon(pokemon: Pokemon) {
        val process = when (pokemon.type) {
            BUG -> "Healing Bug Pokémon with a Herbal Elixir"
            ELECTRIC -> "Reviving Electric Pokémon with Lightning Sparks"
            ROCK -> "Restoring Rock Pokémon with Mystic Gemstones"
            NORMAL -> "Rejuvenating Normal Pokémon with Tranquil Harmony"
            FIRE -> "Curing Fire Pokémon with an Intense Inferno Bath"
            WATER -> "Healing Water Pokémon with the Soothing Ocean Waves"
        }
        log.info("$process - $pokemon")
        registerPokemon(pokemon)
    }

    private fun registerPokemon(pokemon: Pokemon) {
        val pokemonEntity = PokemonEntity(type = pokemon.type, name = pokemon.name, level = pokemon.level, hp = pokemon.hp, master = pokemon.master)
        pokemonRepository.save(pokemonEntity)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}