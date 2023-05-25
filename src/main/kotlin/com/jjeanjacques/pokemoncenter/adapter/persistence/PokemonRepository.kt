package com.jjeanjacques.pokemoncenter.adapter.persistence

import com.jjeanjacques.pokemoncenter.adapter.persistence.entity.PokemonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<PokemonEntity, Long> {
}