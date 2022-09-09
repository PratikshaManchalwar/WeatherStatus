package net.chordify.domain_layer.entities.musical

interface Shiftable<T> {
    fun shiftBy(i: Int): T
}