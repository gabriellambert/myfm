package com.gapps.player_center.tabs.ui.attributes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gapps.player_center.model.positions.Position
import com.gapps.player_center.model.positions.Positions

class AttributesViewModel : ViewModel() {

    private val _filteredPosition = MutableLiveData<Position>()
    val filteredPosition: LiveData<Position>
        get() = _filteredPosition

    fun setFilteredPosition(position: Position?, roleTitle: String) {
        Positions.entries.forEach {
            for (role in it.roles) {
                if (role.value == roleTitle) {
                    _filteredPosition.value =
                        position?.value?.let { positionTitle ->
                            Position(
                                positionTitle,
                                roleTitle,
                                listOf()
                            )
                        }
                }
            }
        }
    }
}