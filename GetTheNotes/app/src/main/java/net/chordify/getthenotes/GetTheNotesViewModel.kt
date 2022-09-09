package net.chordify.getthenotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.chordify.domain_layer.usecases.GetNotesInteractor
import net.chordify.domain_layer.utilities.Result
import net.chordify.getthenotes.utilities.Utils

class GetTheNotesViewModel(private val getNotesInteractor: GetNotesInteractor) : ViewModel() {

    private val _onNotes = MutableLiveData<String>()
    val onNotes: LiveData<String> = _onNotes

    fun searchNotes(chord: String) {
        viewModelScope.launch {
            _onNotes.value = when (val result = getNotesInteractor.get(GetNotesInteractor.RequestValues(chord))) {
                is Result.Failure -> null
                is Result.Success -> result.result.joinToString(", ") {
                    Utils.getString(it)
                }
            }
        }
    }
}