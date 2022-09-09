package net.chordify.getthenotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.chordify.domain_layer.usecases.GetNotesInteractor

class MainViewModelFactory(private val getNotesInteractor: GetNotesInteractor) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GetTheNotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GetTheNotesViewModel(
                getNotesInteractor
            ) as T
        }
        throw IllegalArgumentException("Invalid ViewModel class")
    }
}
