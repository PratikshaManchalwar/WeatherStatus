package net.chordify.getthenotes

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import net.chordify.domain_layer.entities.musical.ChordDetail
import net.chordify.domain_layer.usecases.GetChordsInteractor
import net.chordify.domain_layer.utilities.Result

class GetTheChordsViewModel(private val getChordsInteractor: GetChordsInteractor) : ViewModel() {

    private val _chord = MutableLiveData<List<ChordDetail>>()
    val chord: LiveData<List<ChordDetail>> = _chord

    fun getTheChordDetail(chord: String) {
        viewModelScope.launch {
            _chord.value = when (val result =
                getChordsInteractor.get(GetChordsInteractor.RequestValues(chord))) {
                is Result.Failure -> null
                is Result.Success -> result.result
            }
        }
    }
}



