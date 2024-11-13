package com.gapps.myfm.search_data.domain.usecase

import com.gapps.myfm.search_data.domain.repository.SearchRepository
import com.gapps.myfm.search_data.model.PlayerResponse

class SearchUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchUseCase {
    override suspend fun getAllPlayers(): List<PlayerResponse> {
        return searchRepository.getAllPlayers()
    }
}
