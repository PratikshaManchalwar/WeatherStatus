package net.chordify.getthenotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.chordify.domain_layer.usecases.GetChordsInteractor

class ChordsViewModelFactory(private val getChordsInteractor: GetChordsInteractor) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GetTheChordsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GetTheChordsViewModel(
            getChordsInteractor) as T
        }
        throw IllegalArgumentException("Invalid ViewModel class")
    }
}
