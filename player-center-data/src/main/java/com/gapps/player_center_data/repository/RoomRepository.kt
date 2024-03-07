package com.gapps.player_center_data.repository

import com.gapps.player_center_data.repository.model.PlayerData
import com.gapps.player_center_data.repository.room.PlayerDatabase

class RoomRepository(database: PlayerDatabase) : PlayerRepository {

    private val playerDao = database.playerDao()

    override fun getAll(): List<PlayerData> {
        return playerDao.getAll()
    }

    override fun playerById(id: Long): PlayerData {
        //TODO tratar erro de requisição
        return playerDao.playerById(id)
    }

    override fun save(player: PlayerData) {
        if (player.id == 0L) {
            val id = playerDao.insert(player)
            player.id = id
        } else {
            playerDao.update(player)
        }
    }

    override fun delete(player: PlayerData) {
        return playerDao.delete(player)
    }
}