package com.gapps.myfm.search_data.domain.repository

import com.gapps.myfm.search_data.model.PlayerResponse
import com.gapps.myfm.search_data.service.SearchService

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {
    override suspend fun getPlayerByName(): List<PlayerResponse> {
        return searchService.getPlayerByName("Messi")
    }

    override suspend fun getAllPlayersMock(): List<PlayerResponse> {
        return searchService.getAllPlayersMock()
    }
}
