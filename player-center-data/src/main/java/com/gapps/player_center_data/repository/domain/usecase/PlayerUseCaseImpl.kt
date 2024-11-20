package com.gapps.player_center_data.repository.domain.usecase

import com.gapps.player_center_data.repository.domain.repository.PlayerRepository
import com.gapps.player_center_data.repository.model.PlayerVO

class PlayerUseCaseImpl(
    private val playerRepository: PlayerRepository
) : PlayerUseCase {
    override fun getAll(): List<PlayerVO> {
        return playerRepository.getAll()
    }

    override fun playerById(id: Long): PlayerVO {
        return playerRepository.playerById(id)
    }

    override fun save(player: PlayerVO) {
        playerRepository.save(player)
    }

    override fun delete(player: PlayerVO) {
        playerRepository.delete(player)
    }
}