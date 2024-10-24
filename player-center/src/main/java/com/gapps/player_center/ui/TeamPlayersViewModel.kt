package com.gapps.player_center.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TeamPlayersViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

//    fun getPlayerList(): List<Player> {
//        val players = repository.getAll()
//        return PlayerMapper.mapToPlayerModel(players)
//    }
}