package com.gapps.player_center_data.repository.domain.usecase

import com.gapps.player_center_data.repository.model.PlayerVO

interface PlayerUseCase {
    fun getAll(): List<PlayerVO>

    fun playerById(id: Long): PlayerVO

    fun save(player: PlayerVO)

    fun delete(player: PlayerVO)
}
