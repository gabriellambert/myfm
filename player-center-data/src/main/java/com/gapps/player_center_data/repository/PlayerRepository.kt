package com.gapps.player_center_data.repository

import com.gapps.player_center_data.repository.model.PlayerData

interface PlayerRepository {

    fun getAll(): List<PlayerData>

    fun playerById(id: Long): PlayerData

    fun save(player: PlayerData)

    fun delete(player: PlayerData)
}