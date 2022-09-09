package net.chordify.domain_layer.di

import net.chordify.chordify.domain.di.DataLayerInjectorInterface
import net.chordify.domain_layer.usecases.GetNotesInteractor

class InjectorUtils(private val dataLayerInjector: DataLayerInjectorInterface) {

    fun provideGetNotesInteractor(): GetNotesInteractor {
        return GetNotesInteractor(dataLayerInjector.provideChordsRepository())
    }

    companion object {

        @Volatile var INSTANCE: InjectorUtils? = null

        fun getInstance(dataLayerInjector: DataLayerInjectorInterface): InjectorUtils {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: InjectorUtils(dataLayerInjector).also { INSTANCE = it }
            }
        }
    }
}
