package com.gapps.player_center.model.positions

enum class OldPositions(
    val value: String,
    val abbreviation: String,
    val duties: List<Duty>,
    val primaryAttributes: List<String>?, //ajustar
    val secondaryAttributes: List<String>? //ajustar
) {
    GOALKEEPER(
        "guarda-redes",
        "GR",
        listOf(Duty.DEFEND),
        null,
        null),
    SWEEPER_KEEPER(
        "guarda-redes-líbero",
        "",
        listOf(Duty.DEFEND, Duty.SUPPORT, Duty.ATTACK),
        null,
        null
    ),
    CENTRAL_DEFENDER(
        "defesa central",
        "D (C)",
        listOf(Duty.DEFEND, Duty.SUPPORT, Duty.COVER),
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
        "central descaído",
        "",
        listOf(Duty.DEFEND, Duty.SUPPORT, Duty.ATTACK),
        null,
        null
    ),
    NO_NONSENSE_CENTRE_BACK(
        "defesa central eficiente",
        "",
        listOf(Duty.DEFEND, Duty.SUPPORT, Duty.COVER),
        null,
        null
    ),
    BALL_PLAYING_DEFENDER(
        "defesa com bola",
        "",
        listOf(Duty.DEFEND, Duty.SUPPORT, Duty.COVER),
        null,
        null
    ),
    LIBERO(
        "líbero avançado",
        "",
        listOf(Duty.DEFEND, Duty.SUPPORT),
        null,
        null
    ),
}