package com.example.tactics_center.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCase
import com.gapps.player_center_data.repository.model.PlayerVO

class TacticsViewModel(private val playerUseCase: PlayerUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun getPlayerList(): List<PlayerVO> {
        return playerUseCase.getAll()
    }
}