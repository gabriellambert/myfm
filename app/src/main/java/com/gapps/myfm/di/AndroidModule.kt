package com.gapps.myfm.di

import com.gapps.myfm.ui.MainViewModel
import com.gapps.myfm.ui.home.HomeViewModel
import com.gapps.player_center.PlayerViewModel
import com.gapps.player_center_data.repository.domain.repository.PlayerRepository
import com.gapps.player_center_data.repository.domain.repository.PlayerRepositoryImpl
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCase
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCaseImpl
import com.gapps.player_center_data.repository.room.PlayerDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { this }
    single {
        PlayerRepositoryImpl(
            PlayerDatabase.getDatabase(
                context = get()
            )
        ) as PlayerRepository
    }
    single<PlayerUseCase> { PlayerUseCaseImpl(get()) }
    viewModel {
        MainViewModel(playerUseCase = get())
    }
    viewModel {
        PlayerViewModel(playerUseCase = get())
    }
    viewModel {
        HomeViewModel(playerUseCase = get())
    }
}
