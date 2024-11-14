package com.gapps.myfm.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gapps.myfm.search_data.domain.usecase.SearchUseCase
import com.gapps.myfm.search_data.model.PlayerDBResponse
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchUseCase: SearchUseCase) : ViewModel() {
    private val _searchResult = MutableStateFlow<MutableList<PlayerDBResponse>>(mutableListOf())
    val searchResult: StateFlow<MutableList<PlayerDBResponse>> = _searchResult.asStateFlow()

    fun getPlayersByName(name: String) {
        viewModelScope.launch {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val foundedPlayers: MutableList<PlayerDBResponse> = mutableListOf()

            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (postSnapshot in dataSnapshot.children) {
                        val player = postSnapshot.getValue(PlayerDBResponse::class.java)

                        if (player?.searchString?.contains(name) == true) {
                            foundedPlayers.add(player)
                        }
                    }
                    _searchResult.value = foundedPlayers
                }

                override fun onCancelled(error: DatabaseError) {
                    // ...
                }
            })
        }
    }
}
