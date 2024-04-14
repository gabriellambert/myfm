package com.gapps.player_center.tabs.ui.attributes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gapps.player_center.model.positions.Positions

class AttributesViewModel : ViewModel() {

    private val _filteredPosition = MutableLiveData<Positions>()
    val filteredPosition: LiveData<Positions>
        get() = _filteredPosition

    fun setFilteredPosition(roleTitle: String) {
        Positions.entries.forEach {
            for (role in it.roles) {
                if (role.value == roleTitle) {
                    _filteredPosition.value = it
                }
            }
        }
    }
}