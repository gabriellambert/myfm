package com.gapps.myfm.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gapps.myfm.search_data.domain.usecase.SearchUseCase
import com.gapps.myfm.search_data.model.AttributeResponse
import com.gapps.myfm.search_data.model.GoalkeepingAttributeResponse
import com.gapps.myfm.search_data.model.HiddenAttributeResponse
import com.gapps.myfm.search_data.model.MentalAttributeResponse
import com.gapps.myfm.search_data.model.PhysicalAttributeResponse
import com.gapps.myfm.search_data.model.PlayerResponse
import com.gapps.myfm.search_data.model.TechnicalAttributeResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {
    private val _searchResult = MutableStateFlow<List<PlayerResponse>>(mutableListOf())
    val searchResult: StateFlow<List<PlayerResponse>> = _searchResult.asStateFlow()

    private val _playerSelected = MutableStateFlow<PlayerResponse?>(null)
    val playerSelected: StateFlow<PlayerResponse?> = _playerSelected.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    fun updatePlayerFounded(player: PlayerResponse) {
        _playerSelected.value = player
    }

    fun getPlayersByName(name: String) {
        viewModelScope.launch {
            _loading.value = true
//            val foundedPlayers = searchUseCase.getPlayerByName(name.replace(" ", ""))
            val foundedPlayers = listOf(
                PlayerResponse(
                    playerId = "67030171",
                    name = "David De Gea",
                    age = "32",
                    currentAbility = "144",
                    potentialAbility = "178",
                    minPotentialAbility = "178",
                    maxPotentialAbility = "178",
                    club = "",
                    nationalities = listOf("ESP"),
                    positions = listOf("GK"),
                    askingPrice = "0",
                    contractLength = "-",
                    personality = "Resolute",
                    searchString = "David De Gea",
                    reputation = 0,
                    attributes = AttributeResponse(
                        technicals = TechnicalAttributeResponse(
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        ),
                        mentals = MentalAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        physicals = PhysicalAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0),
                        goalkeeping = GoalkeepingAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                        hidden = HiddenAttributeResponse(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                    ),
                )
            )
            _searchResult.value = foundedPlayers
            _loading.value = false
        }
    }
}
