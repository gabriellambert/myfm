package com.gapps.myfm.di

import com.gapps.myfm.ui.MainViewModel
import com.gapps.player_center_data.repository.PlayerRepository
import com.gapps.player_center_data.repository.room.PlayerDatabase
import com.gapps.player_center.PlayerViewModel
import com.gapps.player_center_data.repository.RoomRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { this }
    single {
        RoomRepository(
            PlayerDatabase.getDatabase(
                context = get()
            )
        ) as PlayerRepository
    }
    viewModel {
        MainViewModel(repository = get())
    }
    viewModel {
        PlayerViewModel(repository = get())
    }
}