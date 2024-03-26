package com.gapps.player_center.model

import com.gapps.player_center.model.attributes.GoalkeeperAttributes
import com.gapps.player_center.model.attributes.MentalAttributes
import com.gapps.player_center.model.attributes.PhysicalAttributes
import com.gapps.player_center.model.attributes.TechnicalAttributes
import com.gapps.player_center.model.positions.OldPosition
import com.gapps.player_center.model.positions.Position
import java.io.Serializable

data class Player(
    var id: Long = 0,
    var name: String = "",
    var age: Int = 1,
    var height: String = "",
    var weight: String = "",
    var positions: List<Position>,
    var secondaryPositions: String = "",
    var nationality: String = "",
    var technicalAttibutes: TechnicalAttributes?,
    var goalkeeperAttibutes: GoalkeeperAttributes?,
    var mentalAttibutes: MentalAttributes?,
    var physicalAttibutes: PhysicalAttributes?,
): Serializable
