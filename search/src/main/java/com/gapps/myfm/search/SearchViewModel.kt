package com.gapps.myfm.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gapps.myfm.search_data.domain.usecase.SearchUseCase
import com.gapps.myfm.search_data.model.PlayerResponse
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {
    private val _searchResult = MutableStateFlow<List<PlayerResponse>>(emptyList())
    val searchResult: StateFlow<List<PlayerResponse>> = _searchResult.asStateFlow()

    fun getPlayersByName(name: String) {
        viewModelScope.launch {
            val players = searchUseCase.getAllPlayersMock()
            _searchResult.value = players
            Log.d("players loaded", players.toString())
        }
    }
}
