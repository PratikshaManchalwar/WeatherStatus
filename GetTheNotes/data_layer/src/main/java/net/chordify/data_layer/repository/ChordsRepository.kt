package net.chordify.data_layer.repository

import net.chordify.data_layer.mappers.NoteStringToNote
import net.chordify.data_layer.network.ApiClient
import net.chordify.domain_layer.entities.musical.Note
import net.chordify.domain_layer.repository.ChordsRepositoryInterface

class ChordsRepository(private val apiClient: ApiClient) : ChordsRepositoryInterface {
    override suspend fun getNotes(chord: String) : List<Note> {
        return try {
            apiClient.chordsService.searchChord(chord).first().tones.split(",").mapNotNull {
                NoteStringToNote.map(it)
            }
        } catch (e: Exception) {
            listOf()
        }
    }
}