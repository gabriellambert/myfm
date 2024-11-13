package com.gapps.myfm.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gapps.myfm.search_data.domain.usecase.SearchUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {
    fun getAllPlayers() {
        viewModelScope.launch {
            val players = searchUseCase.getAllPlayersMock()
            Log.d("players loaded", players.toString())
        }
    }
}
