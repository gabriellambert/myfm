package com.gapps.player_center

import androidx.lifecycle.ViewModel
import com.gapps.player_center.mappers.PlayerMapper
import com.gapps.player_center.model.Player
import com.gapps.player_center_data.repository.PlayerRepository

class PlayerViewModel(private val repository: PlayerRepository) : ViewModel() {

    fun getPlayerById(id: Long): Player {
        val playerData = repository.playerById(id)
        return PlayerMapper.mapSinglePlayer(playerData)
    }
}