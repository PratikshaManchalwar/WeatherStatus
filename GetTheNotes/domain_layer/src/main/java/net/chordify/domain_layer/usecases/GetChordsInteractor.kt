package net.chordify.domain_layer.usecases

import net.chordify.domain_layer.entities.generic.ErrorTypes
import net.chordify.domain_layer.entities.musical.ChordDetail
import net.chordify.domain_layer.repository.ChordsRepositoryInterface
import net.chordify.domain_layer.utilities.Result
import net.chordify.domain_layer.utilities.interactor.Interactor


class GetChordsInteractor(private val chordsRepository: ChordsRepositoryInterface) : Interactor<Result<List<ChordDetail>, ErrorTypes>, GetChordsInteractor.RequestValues>() {

    override suspend fun get(requestValues: RequestValues): Result<List<ChordDetail>, ErrorTypes> {
        val result = chordsRepository.getChordDetail(requestValues.chord)
        return if (result.isEmpty()) Result.Failure(ErrorTypes.NOT_FOUND) else {
            Result.Success(result)
        }
    }

    class RequestValues(val chord: String): Interactor.RequestValues
}
