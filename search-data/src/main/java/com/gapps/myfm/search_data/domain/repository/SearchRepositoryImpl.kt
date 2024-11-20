package com.gapps.myfm.search_data.domain.repository

import com.gapps.myfm.search_data.model.PlayerResponse
import com.gapps.myfm.search_data.service.SearchService

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {
    override suspend fun getPlayerByName(playerName: String): List<PlayerResponse> {
        return searchService.getPlayerByName(playerName)
    }

    override suspend fun getAllPlayersMock(): List<PlayerResponse> {
        return searchService.getAllPlayersMock()
    }
}
