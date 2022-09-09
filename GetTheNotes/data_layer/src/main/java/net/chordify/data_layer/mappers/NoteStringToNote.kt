package net.chordify.data_layer.mappers

import net.chordify.domain_layer.entities.musical.Accidental
import net.chordify.domain_layer.entities.musical.Natural
import net.chordify.domain_layer.entities.musical.Note

object NoteStringToNote: Mapper<String, Note?> {
    override fun map(source: String): Note? {
        return when (source) {
            "A" -> Note(Natural.A, Accidental.NONE)
            "A#" -> Note(Natural.A, Accidental.SHARP)
            "B" -> Note(Natural.B, Accidental.NONE)
            "C" -> Note(Natural.C, Accidental.NONE)
            "C#" -> Note(Natural.C, Accidental.SHARP)
            "Db" -> Note(Natural.D, Accidental.FLAT)
            "D" -> Note(Natural.D, Accidental.NONE)
            "D#" -> Note(Natural.D, Accidental.SHARP)
            "Eb" -> Note(Natural.E, Accidental.FLAT)
            "E" -> Note(Natural.E, Accidental.NONE)
            "F" -> Note(Natural.F, Accidental.NONE)
            "F#" -> Note(Natural.F, Accidental.SHARP)
            "Gb" -> Note(Natural.G, Accidental.FLAT)
            "G" -> Note(Natural.G, Accidental.NONE)
            "G#" -> Note(Natural.G, Accidental.SHARP)
            else -> null
        }
    }
}