package net.chordify.domain_layer.entities.musical

interface Invertable<T> {
    fun invert(): T
}