package com.example.player_center

import androidx.lifecycle.ViewModel
import com.example.player_center.mappers.PlayerMapper
import com.example.player_center.model.Player
import com.example.player_center_data.repository.PlayerRepository

class PlayerViewModel(private val repository: PlayerRepository) : ViewModel() {

//    private val _player = MutableLiveData<Player>()
//    val player: LiveData<Player>
//        get() = _player

    fun getPlayerById(id: Long): Player {
        val playerData = repository.playerById(id)
        val player = PlayerMapper.mapSinglePlayer(playerData)
//        _player.postValue(player)
        return player
    }
}