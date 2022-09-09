package net.chordify.data_layer.network

import net.chordify.data_layer.BuildConfig
import net.chordify.data_layer.datasource.services.ApiClientInterface
import net.chordify.data_layer.datasource.services.ChordsServiceInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient : ApiClientInterface {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override val chordsService: ChordsServiceInterface by lazy {
        retrofit.create(ChordsServiceInterface::class.java)
    }
}