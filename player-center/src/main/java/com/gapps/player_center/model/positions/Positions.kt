package com.gapps.player_center.model.positions

enum class Positions(
    val value: String,
    val portugueseAbrev: String,
    val roles: List<NewRoles>
) {
    GK(
        "guarda-redes", "GR", listOf(
            NewRoles(
                value = "Guarda-Redes", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Guarda-Redes Líbero", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                )
            ),
        )
    ),
    DR(
        "defesa (direito)", "DD", listOf(
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                )
            ),
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Defesa Lateral", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Lateral Descomplicado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            )
        )
    ),
    DC(
        "defesa (centro)", "DC", listOf(
            NewRoles(
                value = "Defesa Central", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "bloqueador",
                        abrev = "bl",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "cobrir",
                        abrev = "co",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Líbero Avançado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Defesa Com Bola", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "bloqueador",
                        abrev = "bl",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "cobrir",
                        abrev = "co",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Defesa Central Eficiente", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "bloqueador",
                        abrev = "bl",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "cobrir",
                        abrev = "co",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Central Descaído", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
        )
    ),
    DL(
        "defesa (esquerdo)", "DE", listOf(
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                )
            ),
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Defesa Lateral", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Lateral Descomplicado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            )
        )
    ),
    WBR(
        "ala (direito)", "DAD", listOf(
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                )
            ),
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
        )
    ),
    DM(
        "médio defensivo", "MD", listOf(
            NewRoles(
                value = "Médio Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Recuado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Médio Recuperador de Bolas", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Trinco", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Pivô Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Médio Criativo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Organizador Móvel", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Segundo Volante", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
        )
    ),
    WBL(
        "ala (esquerdo)", "DAE", listOf(
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                )
            ),
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
        )
    ),
    MR(
        "médio (direito)", "MD", listOf(
            NewRoles(
                value = "Médio Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Extremo Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Organizador Aberto", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            )
        )
    ),
    MC(
        "médio (centro)", "MC", listOf(
            NewRoles(
                value = "Médio Centro", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Recuado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Médio Área-a-Área", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Médio Recuperador de Bolas", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Organizador Móvel", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Mezzala", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Carrilero", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
        )
    ),
    ML(
        "médio (esquerdo)", "ME", listOf(
            NewRoles(
                value = "Médio Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = "",
                        secondaryAttr = ""
                    )
                )
            ),
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Extremo Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Organizador Aberto", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            )
        )
    ),
    AMR(
        "médio ofensivo (direito)", "MOD", listOf(
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado Interior", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado de referência aberto", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Ponta de Lança Aberto", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
        )
    ),
    AMC(
        "médio ofensivo (centro)", "MOC", listOf(
            NewRoles(
                value = "Médio Ofensivo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Pivô Ofensivo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado Sombra", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
        )
    ),
    AML(
        "médio ofensivo (esquerdo)", "MOE", listOf(
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado Interior", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado de referência aberto", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Ponta de Lança Aberto", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
        )
    ),
    STC(
        "ponta-de-lança (centro)", "PLC", listOf(
            NewRoles(
                value = "Avançado Recuado", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Ponta-de-Lança", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado de referência", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Ponta-de-Lança Fixo", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado Completo", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Avançado Trabalhador", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = "",
                        secondaryAttr = ""
                    ),
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = ""),
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(value = "atacar", abrev = "at", primaryAttr = "", secondaryAttr = "")
                )
            ),
            NewRoles(
                value = "Falso Nove", duties = listOf(
                    NewDuties(value = "apoiar", abrev = "ap", primaryAttr = "", secondaryAttr = "")
                )
            ),
        )
    )
}

data class NewRoles(val value: String, val duties: List<NewDuties>)

data class NewDuties(
    val value: String,
    val abrev: String,
    val primaryAttr: String,
    val secondaryAttr: String
)