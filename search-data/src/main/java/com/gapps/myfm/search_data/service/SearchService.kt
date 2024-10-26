package com.gapps.myfm.search_data.service

import com.gapps.myfm.search_data.model.PlayerResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface SearchService {
    @GET("players.json")
    suspend fun getRankings(): List<PlayerResponse>

    companion object {
        private const val BASE_URL = "https://gabriellambert.github.io/"


        fun create(): SearchService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SearchService::class.java)
        }
    }
}