package net.chordify.data_layer.repository

import kotlinx.coroutines.runBlocking
import net.chordify.data_layer.network.ApiClient
import net.chordify.domain_layer.entities.musical.Accidental
import net.chordify.domain_layer.entities.musical.Natural
import net.chordify.domain_layer.entities.musical.Note
import org.junit.Assert
import org.junit.Test

internal class ChordsRepositoryTest {
    @Test
    fun getChord() {
        val repository = ChordsRepository(ApiClient)

        runBlocking {
            val notes = repository.getNotes("F_maj7")
            val expectedNotes = listOf<Note>(
                Note(Natural.F, Accidental.NONE),
                Note(Natural.A, Accidental.NONE),
                Note(Natural.C, Accidental.NONE),
                Note(Natural.E, Accidental.NONE),
            )
            Assert.assertEquals(expectedNotes, notes)
        }
    }
}