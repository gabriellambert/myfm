package com.gapps.player_center_data.repository.domain.repository

import com.gapps.player_center_data.repository.mapper.PlayerMapper
import com.gapps.player_center_data.repository.model.PlayerData
import com.gapps.player_center_data.repository.model.PlayerVO
import com.gapps.player_center_data.repository.room.PlayerDatabase

class PlayerRepositoryImpl(database: PlayerDatabase) : PlayerRepository {

    private val playerDao = database.playerDao()

    override fun getAll(): List<PlayerVO> {
        val response = playerDao.getAll()
        return PlayerMapper.mapToPlayerModel(response)
    }

    override fun playerById(id: Long): PlayerVO {
        //TODO tratar erro de requisição
        val response = playerDao.playerById(id)
        return PlayerMapper.mapSinglePlayer(response)
    }

    override fun save(player: PlayerVO) {
        if (player.id == 0L) {
            val id = playerDao.insert(PlayerMapper.mapToPlayerData(player))
            player.id = id
        } else {
            playerDao.update(PlayerMapper.mapToPlayerData(player))
        }
    }

    override fun delete(player: PlayerVO) {
        return playerDao.delete(PlayerMapper.mapToPlayerData(player))
    }
}