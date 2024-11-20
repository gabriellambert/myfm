package com.gapps.myfm.search_data.service

import com.gapps.myfm.search_data.model.PlayerResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {
    @Headers(
        "x-rapidapi-key: 19343fd8a2msh42cdecad56fe326p1a8559jsn9cf628534c9e",
        "x-rapidapi-host: football-manager-api.p.rapidapi.com"
    )
    @GET("players")
    suspend fun getPlayerByName(
        @Query("name") name: String,
        @Query("orderBy") orderBy: String = "currentAbility-desc"
    ): List<PlayerResponse>

    @GET("newplayers.json")
    suspend fun getAllPlayersMock(): List<PlayerResponse>
}
