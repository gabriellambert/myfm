package com.example.myfm

import androidx.lifecycle.ViewModel
import com.example.myfm.model.Player
import com.example.myfm.repository.PlayerRepository

class PlayerViewModel(private val repository: PlayerRepository) : ViewModel() {

    fun getPlayerById(id: Long): Player = repository.playerById(id)
}