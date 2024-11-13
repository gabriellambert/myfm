package com.gapps.myfm.search_data.domain.usecase

import com.gapps.myfm.search_data.domain.repository.SearchRepository
import com.gapps.myfm.search_data.model.PlayerResponse

class SearchUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchUseCase {
    override suspend fun getPlayerByName(): List<PlayerResponse> {
        return searchRepository.getPlayerByName()
    }

    override suspend fun getAllPlayersMock(): List<PlayerResponse> {
        return searchRepository.getAllPlayersMock()
    }
}
