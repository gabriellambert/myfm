package com.gapps.myfm.di

import com.example.tactics_center.ui.TacticsViewModel
import com.gapps.myfm.search.SearchViewModel
import com.gapps.myfm.search_data.domain.repository.SearchRepository
import com.gapps.myfm.search_data.domain.repository.SearchRepositoryImpl
import com.gapps.myfm.search_data.domain.usecase.SearchUseCase
import com.gapps.myfm.search_data.domain.usecase.SearchUseCaseImpl
import com.gapps.myfm.search_data.service.SearchService
import com.gapps.myfm.ui.MainViewModel
import com.gapps.myfm.ui.home.HomeViewModel
import com.gapps.player_center.PlayerViewModel
import com.gapps.player_center_data.repository.domain.repository.PlayerRepository
import com.gapps.player_center_data.repository.domain.repository.PlayerRepositoryImpl
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCase
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCaseImpl
import com.gapps.player_center_data.repository.room.PlayerDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val androidModule = module {
    single { this }
    single {
        PlayerRepositoryImpl(
            PlayerDatabase.getDatabase(
                context = get()
            )
        ) as PlayerRepository
    }
    single { SearchRepositoryImpl(get()) as SearchRepository }
    single<PlayerUseCase> { PlayerUseCaseImpl(get()) }
    single<SearchUseCase> { SearchUseCaseImpl(get()) }
    single<SearchService> {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = Level.BASIC })
            .build()

        Retrofit.Builder()
            .baseUrl("https://gabriellambert.github.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SearchService::class.java)
    }
    viewModel {
        MainViewModel(playerUseCase = get())
    }
    viewModel {
        PlayerViewModel(playerUseCase = get())
    }
    viewModel {
        HomeViewModel(playerUseCase = get())
    }
    viewModel {
        TacticsViewModel(playerUseCase = get())
    }
    viewModel {
        SearchViewModel(searchUseCase = get())
    }
}
