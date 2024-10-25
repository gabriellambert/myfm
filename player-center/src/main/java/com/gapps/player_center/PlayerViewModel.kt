package com.gapps.player_center

import androidx.lifecycle.ViewModel
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCase
import com.gapps.player_center_data.repository.model.PlayerVO

class PlayerViewModel(
    private val playerUseCase: PlayerUseCase
) : ViewModel() {

    fun getPlayerById(id: Long): PlayerVO {
        return playerUseCase.playerById(id)
    }
}