package com.gapps.myfm.search_data.service

import com.gapps.myfm.search_data.model.PlayerResponse
import retrofit2.http.GET

interface SearchService {
    @GET("newplayers.json")
    suspend fun getAllPlayers(): List<PlayerResponse>
}
