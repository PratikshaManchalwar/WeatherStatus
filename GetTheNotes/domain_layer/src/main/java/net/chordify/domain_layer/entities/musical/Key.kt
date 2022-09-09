package net.chordify.domain_layer.entities.musical

import net.chordify.domain_layer.utilities.ChordUtils

enum class Key(val degreeShorthand: DegreeShorthand, val accidental: Accidental) : Shiftable<Key> {
    cMaj(DegreeShorthand.maj, Accidental.SHARP),
    dFlatMaj(DegreeShorthand.maj, Accidental.FLAT),
    dMaj(DegreeShorthand.maj, Accidental.SHARP),
    eFlatMaj(DegreeShorthand.maj, Accidental.FLAT),
    eMaj(DegreeShorthand.maj, Accidental.SHARP),
    fMaj(DegreeShorthand.maj, Accidental.FLAT),
    fSharpMaj(DegreeShorthand.maj, Accidental.SHARP),
    gMaj(DegreeShorthand.maj, Accidental.SHARP),
    aFlatMaj(DegreeShorthand.maj, Accidental.FLAT),
    aMaj(DegreeShorthand.maj, Accidental.SHARP),
    bFlatMaj(DegreeShorthand.maj, Accidental.FLAT),
    bMaj(DegreeShorthand.maj, Accidental.SHARP),
    cMin(DegreeShorthand.min, Accidental.FLAT),
    cSharpMin(DegreeShorthand.min, Accidental.SHARP),
    dMin(DegreeShorthand.min, Accidental.FLAT),
    eFlatMin(DegreeShorthand.min, Accidental.FLAT),
    eMin(DegreeShorthand.min, Accidental.SHARP),
    fMin(DegreeShorthand.min, Accidental.FLAT),
    fSharpMin(DegreeShorthand.min, Accidental.SHARP),
    gMin(DegreeShorthand.min, Accidental.FLAT),
    gSharpMin(DegreeShorthand.min, Accidental.SHARP),
    aMin(DegreeShorthand.min, Accidental.SHARP),
    bFlatMin(DegreeShorthand.min, Accidental.FLAT),
    bMin(DegreeShorthand.min, Accidental.SHARP);

    override fun shiftBy(i: Int): Key {
        val keys = if (degreeShorthand == DegreeShorthand.maj) MAJORS else MINORS
        return ChordUtils.shift(keys, this, i, DEFAULT)
    }

    companion object {
        val DEFAULT = cMaj
        private val MAJORS = listOf(cMaj, dFlatMaj, dMaj, eFlatMaj, eMaj, fMaj, fSharpMaj, gMaj, aFlatMaj, aMaj, bFlatMaj, bMaj)
        private val MINORS = listOf(cMin, cSharpMin, dMin, eFlatMin, eMin, fMin, fSharpMin, gMin, gSharpMin, aMin, bFlatMin, bMin)
    }
}