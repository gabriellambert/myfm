package com.gapps.player_center_data.repository.model

import java.io.Serializable

data class PlayerVO(
    var id: Long = 0,
    var name: String = "",
    var age: Int = 1,
    var height: String = "",
    var weight: String = "",
    var positions: String = "",
    var secondaryPositions: String = "",
    var nationality: String = "",
    var technicalAttibutes: TechnicalAttributesVO?,
    var goalkeeperAttibutes: GoalkeeperAttributesVO?,
    var mentalAttibutes: MentalAttributesVO?,
    var physicalAttibutes: PhysicalAttributesVO?,
) : Serializable
