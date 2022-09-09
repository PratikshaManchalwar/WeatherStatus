package net.chordify.getthenotes.utilities

import net.chordify.domain_layer.entities.musical.Accidental
import net.chordify.domain_layer.entities.musical.Natural
import net.chordify.domain_layer.entities.musical.Note

object Utils {
    fun getString(note: Note): String {
        return getString(note.natural) + getString(note.accidental)
    }

    private fun getString(natural: Natural): String {
        return when (natural) {
            Natural.A -> "A"
            Natural.B -> "B"
            Natural.C -> "C"
            Natural.D -> "D"
            Natural.E -> "E"
            Natural.F -> "F"
            Natural.G -> "G"
        }
    }

    private fun getString(accidental: Accidental): String {
        return when (accidental) {
            Accidental.SHARP -> "#"
            Accidental.FLAT -> "b"
            Accidental.NONE -> ""
        }
    }
}