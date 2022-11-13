package net.chordify.data_layer.mappers

import net.chordify.data_layer.network.entities.JsonChord
import net.chordify.domain_layer.entities.musical.ChordDetail

object JsonChordToChordDetail : Mapper<JsonChord, ChordDetail> {

    override fun map(source: JsonChord): ChordDetail {
        return ChordDetail(chordName = source.chordName, tones = source.tones)
    }
}