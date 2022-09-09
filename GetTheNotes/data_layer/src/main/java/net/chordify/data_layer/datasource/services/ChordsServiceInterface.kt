package net.chordify.data_layer.datasource.services

import net.chordify.data_layer.network.entities.JsonChord
import retrofit2.http.GET
import retrofit2.http.Path

interface ChordsServiceInterface {
    @GET("chords/{query}")
    suspend fun searchChord(@Path("query") query: String): List<JsonChord>
}