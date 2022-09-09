package net.chordify.getthenotes.di

import androidx.lifecycle.ViewModelProvider
import net.chordify.getthenotes.MainViewModelFactory

class InjectorUtils(private val domainLayerInjector: net.chordify.domain_layer.di.InjectorUtils) {

    fun provideMainViewModel(): ViewModelProvider.Factory {
        return MainViewModelFactory(
            domainLayerInjector.provideGetNotesInteractor()
        )
    }

    companion object {
        @Volatile var INSTANCE: InjectorUtils? = null

        fun getInstance(): InjectorUtils {
            val dataLayerInjector = net.chordify.data_layer.di.InjectorUtils.getInstance()
            val domainLayerInjector = net.chordify.domain_layer.di.InjectorUtils.getInstance(dataLayerInjector)
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: InjectorUtils(domainLayerInjector).also { INSTANCE = it }
            }
        }
    }
}