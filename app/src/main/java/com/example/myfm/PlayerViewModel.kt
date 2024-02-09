package com.example.myfm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfm.model.Player
import com.example.myfm.repository.PlayerRepository

class PlayerViewModel(private val repository: PlayerRepository) : ViewModel() {

    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player>
        get() =_player

    fun getPlayerById(id: Long): Player {
        val player = repository.playerById(id)
        _player.postValue(player)

        return player
    }
}