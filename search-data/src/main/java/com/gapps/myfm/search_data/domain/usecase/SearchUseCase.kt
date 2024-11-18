package com.gapps.myfm.search_data.domain.usecase

import com.gapps.myfm.search_data.model.PlayerResponse

interface SearchUseCase {
    suspend fun getPlayerByName(playerName: String): List<PlayerResponse>
    suspend fun getAllPlayersMock(): List<PlayerResponse>
}
