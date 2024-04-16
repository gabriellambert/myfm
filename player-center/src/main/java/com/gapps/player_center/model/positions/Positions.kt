package com.gapps.player_center.model.positions

import com.gapps.player_center.utils.GoalkeeperAttributesKeys
import com.gapps.player_center.utils.MentalAttributesKeys
import com.gapps.player_center.utils.PhysicalAttributesKeys

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
                        primaryAttr = listOf(
                            GoalkeeperAttributesKeys.AERIAL_REACH.value,
                            GoalkeeperAttributesKeys.COMMAND_OF_AREA.value,
                            GoalkeeperAttributesKeys.COMMUNICATION.value,
                            GoalkeeperAttributesKeys.HANDLING.value,
                            GoalkeeperAttributesKeys.KICKING.value,
                            GoalkeeperAttributesKeys.REFLEXES.value,
                            MentalAttributesKeys.CONCENTRATION.value,
                            MentalAttributesKeys.POSITIONING.value,
                            PhysicalAttributesKeys.AGILITY.value
                        ),
                        secondaryAttr = listOf(
                            GoalkeeperAttributesKeys.THROWING.value,
                            GoalkeeperAttributesKeys.ONE_ON_ONES.value,
                            MentalAttributesKeys.ANTICIPATION.value,
                            MentalAttributesKeys.DECISIONS.value,
                        )
                    )
                )
            ),
            NewRoles(
                value = "Guarda-Redes Líbero", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(
                            GoalkeeperAttributesKeys.COMMAND_OF_AREA.value,
                            GoalkeeperAttributesKeys.KICKING.value,
                            GoalkeeperAttributesKeys.REFLEXES.value,
                            GoalkeeperAttributesKeys.ONE_ON_ONES.value,
                            MentalAttributesKeys.ANTICIPATION.value,
                            MentalAttributesKeys.CONCENTRATION.value,
                            MentalAttributesKeys.POSITIONING.value,
                            PhysicalAttributesKeys.AGILITY.value
                        ),
                        secondaryAttr = listOf(
                            GoalkeeperAttributesKeys.PUNCHING.value,
                            GoalkeeperAttributesKeys.AERIAL_REACH.value,
                            GoalkeeperAttributesKeys.COMMUNICATION.value,
                            GoalkeeperAttributesKeys.HANDLING.value,
                            GoalkeeperAttributesKeys.THROWING.value,
                            GoalkeeperAttributesKeys.PASSING.value,
                            GoalkeeperAttributesKeys.FIRST_TOUCH.value,
                            MentalAttributesKeys.COMPOSURE.value,
                            MentalAttributesKeys.DECISIONS.value,
                            MentalAttributesKeys.VISION.value,
                            PhysicalAttributesKeys.ACCELERATION.value
                        )
                    ),
                    NewDuties(
                        value = "apoiar", abrev = "ap", primaryAttr = listOf(
                            GoalkeeperAttributesKeys.PUNCHING.value,
                            GoalkeeperAttributesKeys.COMMAND_OF_AREA.value,
                            GoalkeeperAttributesKeys.KICKING.value,
                            GoalkeeperAttributesKeys.REFLEXES.value,
                            GoalkeeperAttributesKeys.ONE_ON_ONES.value,
                            MentalAttributesKeys.ANTICIPATION.value,
                            MentalAttributesKeys.COMPOSURE.value,
                            MentalAttributesKeys.CONCENTRATION.value,
                            MentalAttributesKeys.POSITIONING.value,
                            PhysicalAttributesKeys.AGILITY.value
                        ),
                        secondaryAttr = listOf(
                            GoalkeeperAttributesKeys.AERIAL_REACH.value,
                            GoalkeeperAttributesKeys.COMMUNICATION.value,
                            GoalkeeperAttributesKeys.HANDLING.value,
                            GoalkeeperAttributesKeys.THROWING.value,
                            GoalkeeperAttributesKeys.PASSING.value,
                            GoalkeeperAttributesKeys.FIRST_TOUCH.value,
                            MentalAttributesKeys.DECISIONS.value,
                            MentalAttributesKeys.VISION.value,
                            PhysicalAttributesKeys.ACCELERATION.value
                        )
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(
                            GoalkeeperAttributesKeys.PUNCHING.value,
                            GoalkeeperAttributesKeys.COMMAND_OF_AREA.value,
                            GoalkeeperAttributesKeys.KICKING.value,
                            GoalkeeperAttributesKeys.REFLEXES.value,
                            GoalkeeperAttributesKeys.ONE_ON_ONES.value,
                            MentalAttributesKeys.ANTICIPATION.value,
                            MentalAttributesKeys.COMPOSURE.value,
                            MentalAttributesKeys.CONCENTRATION.value,
                            MentalAttributesKeys.POSITIONING.value,
                            PhysicalAttributesKeys.AGILITY.value
                        ),
                        secondaryAttr = listOf(
                            GoalkeeperAttributesKeys.AERIAL_REACH.value,
                            GoalkeeperAttributesKeys.COMMUNICATION.value,
                            GoalkeeperAttributesKeys.ECCENTRICITY.value,
                            GoalkeeperAttributesKeys.HANDLING.value,
                            GoalkeeperAttributesKeys.THROWING.value,
                            GoalkeeperAttributesKeys.PASSING.value,
                            GoalkeeperAttributesKeys.FIRST_TOUCH.value,
                            MentalAttributesKeys.DECISIONS.value,
                            MentalAttributesKeys.VISION.value,
                            PhysicalAttributesKeys.ACCELERATION.value
                        )
                    ),
                )
            ),
        )
    ),
    DR(
        "defesa (direito)", "D (D)", listOf(
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Defesa Lateral", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Lateral Descomplicado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            )
        )
    ),
    DC(
        "defesa (centro)", "D (C)", listOf(
            NewRoles(
                value = "Defesa Central", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "bloqueador",
                        abrev = "bl",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "cobrir",
                        abrev = "co",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Líbero Avançado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Defesa Com Bola", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "bloqueador",
                        abrev = "bl",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "cobrir",
                        abrev = "co",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Defesa Central Eficiente", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "bloqueador",
                        abrev = "bl",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "cobrir",
                        abrev = "co",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Central Descaído", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
        )
    ),
    DL(
        "defesa (esquerdo)", "D (E)", listOf(
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Defesa Lateral", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Lateral Descomplicado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            )
        )
    ),
    WBR(
        "ala (direito)", "DA (D)", listOf(
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
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
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Recuado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Médio Recuperador de Bolas", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Trinco", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Pivô Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Médio Criativo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Organizador Móvel", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Segundo Volante", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
        )
    ),
    WBL(
        "ala (esquerdo)", "DA (E)", listOf(
            NewRoles(
                value = "Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Ala Completo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Defesa Ala Invertido", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
        )
    ),
    MR(
        "médio (direito)", "M (D)", listOf(
            NewRoles(
                value = "Médio Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Organizador Aberto", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            )
        )
    ),
    MC(
        "médio (centro)", "M (C)", listOf(
            NewRoles(
                value = "Médio Centro", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Recuado", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Médio Área-a-Área", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Médio Recuperador de Bolas", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Organizador Móvel", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Mezzala", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Carrilero", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
        )
    ),
    ML(
        "médio (esquerdo)", "M (E)", listOf(
            NewRoles(
                value = "Médio Ala", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "automático",
                        abrev = "au",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo Defensivo", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Organizador Aberto", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            )
        )
    ),
    AMR(
        "médio ofensivo (direito)", "MO (D)", listOf(
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado Interior", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado de referência aberto", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Ponta de Lança Aberto", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
        )
    ),
    AMC(
        "médio ofensivo (centro)", "MO (C)", listOf(
            NewRoles(
                value = "Médio Ofensivo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Pivô Ofensivo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado Sombra", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
        )
    ),
    AML(
        "médio ofensivo (esquerdo)", "MO (E)", listOf(
            NewRoles(
                value = "Extremo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Construtor de Jogo Avançado", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado Interior", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado de referência aberto", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Ponta de Lança Aberto", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Extremo Invertido", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
        )
    ),
    STC(
        "ponta-de-lança (centro)", "PL (C)", listOf(
            NewRoles(
                value = "Avançado Recuado", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Ponta-de-Lança", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado de referência", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Ponta-de-Lança Fixo", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado Completo", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Avançado Trabalhador", duties = listOf(
                    NewDuties(
                        value = "defender",
                        abrev = "de",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    ),
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Número 10", duties = listOf(
                    NewDuties(
                        value = "atacar",
                        abrev = "at",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
            NewRoles(
                value = "Falso Nove", duties = listOf(
                    NewDuties(
                        value = "apoiar",
                        abrev = "ap",
                        primaryAttr = listOf(),
                        secondaryAttr = listOf()
                    )
                )
            ),
        )
    )
}

data class NewRoles(val value: String, val duties: List<NewDuties>)

data class NewDuties(
    val value: String,
    val abrev: String,
    val primaryAttr: List<String>,
    val secondaryAttr: List<String>
)