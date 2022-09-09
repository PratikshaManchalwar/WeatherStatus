package net.chordify.domain_layer.entities.musical

interface Transposable<T> {
    fun transpose(offset: Int, key: Key): T
}