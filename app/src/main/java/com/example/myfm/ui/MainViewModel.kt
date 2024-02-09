package com.example.myfm.ui

import androidx.lifecycle.ViewModel
import com.example.player_center.mappers.PlayerMapper
import com.example.player_center.model.Player
import com.example.player_center_data.repository.PlayerRepository
import com.example.player_center.model.GoalkeeperAttributes
import com.example.player_center.model.MentalAttributes
import com.example.player_center.model.PhysicalAttributes
import com.example.player_center.model.TechnicalAttributes
import com.example.player_center_data.repository.model.GoalkeeperAttributesData
import com.example.player_center_data.repository.model.MentalAttributesData
import com.example.player_center_data.repository.model.PhysicalAttributesData
import com.example.player_center_data.repository.model.PlayerData
import com.example.player_center_data.repository.model.TechnicalAttributesData

class MainViewModel(private val repository: PlayerRepository) : ViewModel() {

    val players = listOf(
        PlayerData(
            name = "Augusto Batalla",
            age = 31,
            height = "1.85m",
            weight = "79kg",
            positions = "GR",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Neto Volpi",
            age = 34,
            height = "1.89m",
            weight = "79kg",
            positions = "GR",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Young",
            age = 25,
            height = "2.02m",
            weight = "86kg",
            positions = "GR",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Antônio Carlos",
            age = 20,
            height = "1.96m",
            weight = "84kg",
            positions = "GR",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Joaquín Novillo",
            age = 29,
            height = "1.90m",
            weight = "89kg",
            positions = "D(C)",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Ian Rasso",
            age = 26,
            height = "1.81m",
            weight = "74kg",
            positions = "D(C)",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Mezenga",
            age = 25,
            height = "1.85m",
            weight = "75kg",
            positions = "D(C)",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
        PlayerData(
            name = "Bruno Rodrigues",
            age = 30,
            height = "1.77m",
            weight = "72kg",
            positions = "M(E),MO(DE),PL(C)",
            technicalAttibutes = TechnicalAttributesData(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14
            ),
            goalkeeperAttibutes = GoalkeeperAttributesData(
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50
            ),
            mentalAttibutes = MentalAttributesData(
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28
            ),
            physicalAttibutes = PhysicalAttributesData(
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37
            )
        ),
    )

    fun savePlayers() {
        players.forEach {
            repository.save(it)
        }
    }

    fun deletePlayers() {
        players.forEach {
            repository.delete(it)
        }
    }

    fun getPlayerList(): List<Player> {
        val players = repository.getAll()
        return PlayerMapper.mapToPlayerModel(players)
    }
}