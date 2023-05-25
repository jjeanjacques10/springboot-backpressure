package com.jjeanjacques.pokemoncenter.adapter.persistence.entity

import com.jjeanjacques.pokemoncenter.domain.enums.Type
import javax.persistence.*

@Entity
@Table(name = "pokemon")
data class PokemonEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "type")
        var type: Type? = null,

        @Column(name = "hp")
        var hp: Int = 0,

        @Column(name = "level")
        var level: Int = 0,

        @Column(name = "master", nullable = true)
        var master: String? = null
)
