package com.example.myfm.di

import com.example.myfm.PlayerViewModel
import com.example.myfm.repository.PlayerRepository
import com.example.myfm.repository.room.PlayerDatabase
import com.example.myfm.repository.RoomRepository
import com.example.myfm.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { this }
    single {
        RoomRepository(PlayerDatabase.getDatabase(context = get())) as PlayerRepository
    }
    viewModel {
        MainViewModel(repository = get())
    }
    viewModel {
        PlayerViewModel(repository = get())
    }
}