package com.jjeanjacques.pokemoncenter.domain

import com.jjeanjacques.pokemoncenter.domain.enums.Type

class Pokemon {
    lateinit var name: String
    lateinit var type: Type
    var hp: Int = 0
    var level: Int = 0

    override fun toString(): String {
        return "(name: ${this.name}, type: ${this.type}, hp: ${this.hp}, level: ${this.level}"
    }
}
