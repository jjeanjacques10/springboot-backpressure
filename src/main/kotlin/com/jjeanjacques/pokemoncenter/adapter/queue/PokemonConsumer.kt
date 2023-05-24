package com.jjeanjacques.pokemoncenter.adapter.queue

import com.fasterxml.jackson.databind.ObjectMapper
import com.jjeanjacques.pokemoncenter.adapter.queue.backpressure.Backpressure
import com.jjeanjacques.pokemoncenter.application.PokemonService
import com.jjeanjacques.pokemoncenter.domain.Pokemon
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

@Component
class PokemonConsumer(val pokemonService: PokemonService,
                      val backpressure: Backpressure,
                      val objectMapper: ObjectMapper) {

    @SqsListener("sick-pokemon-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    fun receiveSickPokemon(message: String, @Header("health-group") senderId: String?) {
        while (backpressure.shouldWait()) {
            println("Waiting to process the message - sorry, there is a problem with the database")
            Thread.sleep(15000)
        }
        val pokemon = objectMapper.readValue(message, Pokemon::class.java)
        pokemonService.curePokemon(pokemon)
    }

}