package com.gapps.myfm.search_data.domain.usecase

import com.gapps.myfm.search_data.model.PlayerResponse

interface SearchUseCase {
    suspend fun getPlayerByName(): List<PlayerResponse>
    suspend fun getAllPlayersMock(): List<PlayerResponse>
}
