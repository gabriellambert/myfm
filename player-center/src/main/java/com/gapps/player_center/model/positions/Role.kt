package com.gapps.player_center.model.positions

data class Role(
    val abbreviation: String,
    val value: String,
    val duties: List<Duty>,
    val primaryAttributes: List<String>?, //ajustar
    val secondaryAttributes: List<String>? //ajustar
)
