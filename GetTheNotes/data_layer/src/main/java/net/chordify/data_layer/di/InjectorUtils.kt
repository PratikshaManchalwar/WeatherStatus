package net.chordify.data_layer.di

import net.chordify.chordify.domain.di.DataLayerInjectorInterface
import net.chordify.data_layer.network.ApiClient
import net.chordify.data_layer.repository.ChordsRepository
import net.chordify.domain_layer.repository.ChordsRepositoryInterface

class InjectorUtils : DataLayerInjectorInterface {

    override fun provideChordsRepository(): ChordsRepositoryInterface {
        return ChordsRepository(ApiClient)
    }

    companion object {

        @Volatile
        var INSTANCE: InjectorUtils? = null

        fun getInstance(): InjectorUtils {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: InjectorUtils().also { INSTANCE = it }
            }
        }
    }
}