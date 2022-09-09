package net.chordify.domain_layer.utilities.interactor

abstract class Interactor<out Q, in T : Interactor.RequestValues> {
    abstract suspend fun get(requestValues: T): Q

    interface RequestValues
}