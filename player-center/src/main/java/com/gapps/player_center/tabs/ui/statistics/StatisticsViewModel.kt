package com.gapps.player_center.tabs.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StatisticsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Em breve você poderá ver as estatísticas do jogador aqui"
    }
    val text: LiveData<String> = _text
}