package net.chordify.data_layer.datasource.services

import net.chordify.data_layer.network.entities.JsonChord
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChordsServiceInterface {
    @GET("chords/{query}")
    suspend fun searchChord(@Path("query") query: String): List<JsonChord>

    @GET("chords")
    suspend fun getChordDetail(@Query("nameLike") chordName: String): List<JsonChord>
}