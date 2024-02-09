package com.example.myfm.di

import com.example.myfm.ui.MainViewModel
import com.example.player_center_data.repository.PlayerRepository
import com.example.player_center_data.repository.room.PlayerDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { this }
    single {
        com.example.player_center_data.repository.RoomRepository(
            PlayerDatabase.getDatabase(
                context = get()
            )
        ) as PlayerRepository
    }
    viewModel {
        MainViewModel(repository = get())
    }
    viewModel {
        com.example.player_center.PlayerViewModel(repository = get())
    }
}