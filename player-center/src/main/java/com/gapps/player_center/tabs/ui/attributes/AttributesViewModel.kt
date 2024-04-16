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

    fun getDutiesFromPositionFiltered(position: Position?, roleTitle: String): List<String> {
        val roles: MutableList<String> = mutableListOf()
        Positions.entries.find { it.value == position?.value}.apply {
            this?.roles?.find { it.value == roleTitle }.apply {
                this?.duties?.forEach {
                    roles.add(it.value)
                }
            }
        }
        return roles
    }

//    fun setFilteredPosition(position: Position?, roleTitle: String) {
//        Positions.entries.find { it.value == position?.value}.apply {
//        Positions.entries.forEach {
//            for (role in it.roles) {
//                if (role.value == roleTitle) {
//                    _filteredPosition.value =
//                        position?.value?.let { positionTitle ->
//                            Position(
//                                positionTitle,
//                                roleTitle,
//                                listOf()
//                            )
//                        }
//                }
//            }
//        }
//    }
}