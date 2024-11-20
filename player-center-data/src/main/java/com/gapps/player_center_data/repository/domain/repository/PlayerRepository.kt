package com.gapps.player_center_data.repository.domain.repository

import com.gapps.player_center_data.repository.model.PlayerData
import com.gapps.player_center_data.repository.model.PlayerVO

interface PlayerRepository {

    fun getAll(): List<PlayerVO>

    fun playerById(id: Long): PlayerVO

    fun save(player: PlayerVO)

    fun delete(player: PlayerVO)
}
