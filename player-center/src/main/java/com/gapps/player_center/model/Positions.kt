package com.gapps.player_center.model

import com.gapps.player_center_data.repository.model.TechnicalAttributesData

enum class Positions(
    val value: String,
    val abbreviation: String,
    val functions: List<Function>,
    val primaryAttributes: List<String>?, //ajustar
    val secondaryAttributes: List<String>? //ajustar
) {
    GOALKEEPER(
        "guarda-redes",
        "GR",
        listOf(Function.DEFEND),
        null,
        null),
    SWEEPER_KEEPER(
        "guarda-redes-líbero",
        "",
        listOf(Function.DEFEND, Function.SUPPORT, Function.ATTACK),
        null,
        null
    ),
    CENTRAL_DEFENDER(
        "?",
        "",
        listOf(Function.DEFEND, Function.SUPPORT, Function.COVER),
        listOf(
            "marking", "tackling",
            "anticipation", "concentration", "decisions", "positioning",
            "pace"
        ),
        listOf(
            "heading",
            "bravery", "composure",
            "jumpingReach", "strength"
        )
    ),
    WIDE_CENTER_BACK(
        "?",
        "",
        listOf(Function.DEFEND, Function.SUPPORT, Function.ATTACK),
        null,
        null
    ),
    NO_NONSENSE_CENTRE_BACK(
        "?",
        "",
        listOf(Function.DEFEND, Function.SUPPORT, Function.COVER),
        null,
        null
    ),
    BALL_PLAYING_DEFENDER(
        "?",
        "",
        listOf(Function.DEFEND, Function.SUPPORT, Function.COVER),
        null,
        null
    ),
    LIBERO(
        "?",
        "",
        listOf(Function.DEFEND, Function.SUPPORT),
        null,
        null
    ),
}