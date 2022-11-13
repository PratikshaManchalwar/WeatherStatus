package net.chordify.data_layer.network.entities

import com.google.gson.annotations.SerializedName

data class JsonChord(
    @SerializedName("tones")
    val tones: String,
    @SerializedName("chordName")
    val chordName: String
)