package net.chordify.domain_layer.entities.musical

import net.chordify.domain_layer.utilities.ChordUtils

class Note constructor(val natural: Natural, val accidental: Accidental)
    : Transposable<Note>, Shiftable<Note>, Invertable<Note> {

    override fun transpose(offset: Int, key: Key): Note {
        return shiftBy(offset).normalise(key)
    }

    private fun normalise(key: Key): Note {
        return if (accidental === key.accidental) this else invert()
    }

    override fun invert(): Note {
        return when (accidental) {
            Accidental.SHARP -> Note(natural.shiftBy(1), Accidental.FLAT)
            Accidental.FLAT -> Note(natural.shiftBy(-1), Accidental.SHARP)
            else -> this
        }
    }

    override fun shiftBy(i: Int): Note {
        val normalized = normalise(Key.DEFAULT)
        return if (!OCTAVE.contains(normalise(Key.DEFAULT))) this else ChordUtils.shift(OCTAVE, normalized, i, normalized)
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is Note &&
                natural === other.natural && accidental === other.accidental) {
            true
        } else {
            ENHARMONICS[this]?.let {
                other != null && other is Note &&
                        it.natural === other.natural && it.accidental === other.accidental
            } ?: false
        }
    }

    override fun hashCode(): Int {
        val accidentalHash = accidental.hashCode()
        var result = 17
        result = 31 * result + natural.hashCode()
        result = 31 * result + accidentalHash
        return result
    }

    companion object {
        private val OCTAVE = listOf(
                Note(Natural.C, Accidental.NONE),
                Note(Natural.C, Accidental.SHARP),
                Note(Natural.D, Accidental.NONE),
                Note(Natural.D, Accidental.SHARP),
                Note(Natural.E, Accidental.NONE),
                Note(Natural.F, Accidental.NONE),
                Note(Natural.F, Accidental.SHARP),
                Note(Natural.G, Accidental.NONE),
                Note(Natural.G, Accidental.SHARP),
                Note(Natural.A, Accidental.NONE),
                Note(Natural.A, Accidental.SHARP),
                Note(Natural.B, Accidental.NONE)
        )

        val ENHARMONICS = hashMapOf(
                Note(Natural.C, Accidental.FLAT) to Note(Natural.B, Accidental.NONE),
                Note(Natural.C, Accidental.NONE) to Note(Natural.B, Accidental.SHARP),
                Note(Natural.C, Accidental.SHARP) to Note(Natural.D, Accidental.FLAT),
                Note(Natural.D, Accidental.FLAT) to Note(Natural.C, Accidental.SHARP),
                Note(Natural.D, Accidental.SHARP) to Note(Natural.E, Accidental.FLAT),
                Note(Natural.E, Accidental.FLAT) to Note(Natural.D, Accidental.SHARP),
                Note(Natural.E, Accidental.NONE) to Note(Natural.F, Accidental.FLAT),
                Note(Natural.E, Accidental.SHARP) to Note(Natural.F, Accidental.NONE),
                Note(Natural.F, Accidental.FLAT) to Note(Natural.E, Accidental.NONE),
                Note(Natural.F, Accidental.NONE) to Note(Natural.E, Accidental.SHARP),
                Note(Natural.F, Accidental.SHARP) to Note(Natural.G, Accidental.FLAT),
                Note(Natural.G, Accidental.FLAT) to Note(Natural.F, Accidental.SHARP),
                Note(Natural.G, Accidental.SHARP) to Note(Natural.A, Accidental.FLAT),
                Note(Natural.A, Accidental.FLAT) to Note(Natural.G, Accidental.SHARP),
                Note(Natural.A, Accidental.SHARP) to Note(Natural.B, Accidental.FLAT),
                Note(Natural.B, Accidental.FLAT) to Note(Natural.A, Accidental.SHARP),
                Note(Natural.B, Accidental.NONE) to Note(Natural.C, Accidental.FLAT),
                Note(Natural.B, Accidental.SHARP) to Note(Natural.C, Accidental.NONE)
        )
    }
}