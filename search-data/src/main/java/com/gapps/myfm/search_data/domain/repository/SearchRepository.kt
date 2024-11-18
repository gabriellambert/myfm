package com.gapps.myfm.search_data.domain.repository

import com.gapps.myfm.search_data.model.PlayerResponse

interface SearchRepository {
    suspend fun getPlayerByName(playerName: String): List<PlayerResponse>
    suspend fun getAllPlayersMock(): List<PlayerResponse>
}
