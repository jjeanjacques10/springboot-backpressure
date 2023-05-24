package com.jjeanjacques.pokemoncenter.application

import com.jjeanjacques.pokemoncenter.domain.Pokemon

interface PokemonService {
    fun curePokemon(pokemon: Pokemon)
}