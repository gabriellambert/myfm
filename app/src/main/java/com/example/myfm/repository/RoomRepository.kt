package com.example.myfm.repository

import com.example.myfm.model.Player
import com.example.myfm.repository.room.PlayerDatabase

class RoomRepository(database: PlayerDatabase): PlayerRepository {

    private val playerDao = database.playerDao()

    override fun getAll(): List<Player> {
        return playerDao.getAll()
    }

    override fun playerById(id: Long): List<Player> {
        return playerDao.playerById(id)
    }

    override fun save(player: Player) {
        if (player.id == 0L) {
            val id = playerDao.insert(player)
            player.id = id
        } else {
            playerDao.update(player)
        }
    }

    override fun delete(player: Player) {
        return playerDao.delete(player)
    }
}