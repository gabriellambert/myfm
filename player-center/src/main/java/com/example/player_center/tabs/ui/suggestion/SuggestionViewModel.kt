package com.example.player_center.tabs.ui.suggestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SuggestionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Em breve você poderá ver sugestões de treinos e evolução deste jogador"
    }
    val text: LiveData<String> = _text
}