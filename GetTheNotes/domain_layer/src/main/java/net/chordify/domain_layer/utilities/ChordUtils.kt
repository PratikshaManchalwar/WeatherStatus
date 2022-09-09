package net.chordify.domain_layer.utilities

import net.chordify.domain_layer.entities.musical.Shiftable

object ChordUtils {
    fun <T : Shiftable<*>?> shift(
        sortedList: List<T>,
        original: T,
        shiftBy: Int,
        defaultValue: T
    ): T {
        return sortedList[((sortedList.indexOf(original) + shiftBy) % sortedList.size + sortedList.size) % sortedList.size] ?: defaultValue
    }
}