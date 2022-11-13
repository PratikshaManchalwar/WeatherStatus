package net.chordify.domain_layer.repository

import net.chordify.domain_layer.entities.musical.ChordDetail
import net.chordify.domain_layer.entities.musical.Note

interface ChordsRepositoryInterface {
    suspend fun getNotes(chord: String): List<Note>
    suspend fun getChordDetail(chord: String) : List<ChordDetail>
}