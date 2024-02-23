package com.example.player_center.model

import java.io.Serializable

data class Player(
    var id: Long = 0,
    var name: String = "",
    var age: Int = 1,
    var height: String = "",
    var weight: String = "",
    var positions: String = "",
    var technicalAttibutes: TechnicalAttributes?,
    var goalkeeperAttibutes: GoalkeeperAttributes?,
    var mentalAttibutes: MentalAttributes?,
    var physicalAttibutes: PhysicalAttributes?,
): Serializable
