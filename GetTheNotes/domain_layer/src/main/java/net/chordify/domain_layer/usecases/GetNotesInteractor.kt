package net.chordify.domain_layer.usecases

import net.chordify.domain_layer.entities.generic.ErrorTypes
import net.chordify.domain_layer.entities.musical.Note
import net.chordify.domain_layer.repository.ChordsRepositoryInterface
import net.chordify.domain_layer.utilities.Result
import net.chordify.domain_layer.utilities.interactor.Interactor

class GetNotesInteractor(private val chordsRepository: ChordsRepositoryInterface) : Interactor<Result<List<Note>, ErrorTypes>, GetNotesInteractor.RequestValues>() {

    override suspend fun get(requestValues: RequestValues): Result<List<Note>, ErrorTypes> {
        val result = chordsRepository.getNotes(requestValues.chord)
        return if (result.isEmpty()) Result.Failure(ErrorTypes.NOT_FOUND) else {
            Result.Success(result)
        }
    }

    class RequestValues(val chord: String): Interactor.RequestValues
}