package net.chordify.data_layer.repository

import kotlinx.coroutines.runBlocking
import net.chordify.data_layer.network.ApiClient
import net.chordify.domain_layer.entities.musical.Accidental
import net.chordify.domain_layer.entities.musical.ChordDetail
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

    @Test
    fun getChordDetail() {
        val repository = ChordsRepository(ApiClient)
        runBlocking {
            val chordDetail = repository.getChordDetail("E7")
            val expectedResultElement1 = listOf(
                ChordDetail("E,,7,", "E,G#,B,D")
            )
            Assert.assertEquals(expectedResultElement1[0], chordDetail.first())
            Assert.assertEquals(10, chordDetail.size)
        }
    }

    @Test
    fun getChordDetail_invalidInput() {
        val repository = ChordsRepository(ApiClient)
        runBlocking {
            val chordDetail = repository.getChordDetail("W")
            Assert.assertEquals(0, chordDetail.size)
        }
    }
}