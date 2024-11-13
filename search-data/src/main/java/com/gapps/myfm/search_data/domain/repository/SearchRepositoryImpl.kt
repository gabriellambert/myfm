package com.gapps.myfm.search_data.domain.repository

import com.gapps.myfm.search_data.model.PlayerResponse
import com.gapps.myfm.search_data.service.SearchService

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {
    override suspend fun getAllPlayers(): List<PlayerResponse> {
        return searchService.getAllPlayers()
    }
}
