package net.chordify.data_layer.mappers

interface Mapper <in T, out V> {
    fun map(source: T) : V
}