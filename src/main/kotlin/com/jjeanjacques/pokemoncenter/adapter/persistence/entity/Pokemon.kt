package com.jjeanjacques.pokemoncenter.adapter.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "pokemon")
data class Pokemon(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "type")
        var type: String? = null,

        @Column(name = "hp")
        var hp: Int = 0,

        @Column(name = "level")
        var level: Int = 0
)
