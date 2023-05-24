package com.jjeanjacques.pokemoncenter.adapter.queue.backpressure

interface Backpressure {
    fun shouldWait(): Boolean
}