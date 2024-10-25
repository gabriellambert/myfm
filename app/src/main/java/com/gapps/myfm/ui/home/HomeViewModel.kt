package com.gapps.myfm.ui.home

import androidx.lifecycle.ViewModel
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCase
import com.gapps.player_center_data.repository.model.PlayerVO

class HomeViewModel(private val playerUseCase: PlayerUseCase) : ViewModel() {

    fun getPlayerList(): List<PlayerVO> {
        return playerUseCase.getAll()
    }
}
