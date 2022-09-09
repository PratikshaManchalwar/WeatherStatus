package net.chordify.domain_layer.entities.musical

import net.chordify.domain_layer.utilities.ChordUtils

enum class Natural : Shiftable<Natural> {
    A, B, C, D, E, F, G;

    override fun shiftBy(i: Int): Natural {
        return ChordUtils.shift(OCTAVE, this, i, C)
    }

    companion object {
        private val OCTAVE = listOf(C, D, E, F, G, A, B)
    }
}