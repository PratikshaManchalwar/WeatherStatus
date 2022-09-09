package net.chordify.chordify.domain.di

import net.chordify.domain_layer.repository.ChordsRepositoryInterface

interface DataLayerInjectorInterface {
    fun provideChordsRepository(): ChordsRepositoryInterface
}