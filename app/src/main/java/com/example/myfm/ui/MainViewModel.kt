package com.example.myfm.ui

import androidx.lifecycle.ViewModel
import com.example.myfm.model.GoalkeeperAttributes
import com.example.myfm.model.MentalAttributes
import com.example.myfm.model.PhysicalAttributes
import com.example.myfm.model.Player
import com.example.myfm.model.TechnicalAttributes
import com.example.myfm.repository.PlayerRepository

class MainViewModel(private val repository: PlayerRepository) : ViewModel() {

    val players = listOf(
        Player(
            name = "Augusto Batalla",
            age = 31,
            height = "1.85m",
            weight = "79kg",
            positions = "GR",
            technicalAttibutes = TechnicalAttributes(
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
            goalkeeperAttibutes = GoalkeeperAttributes(
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
            mentalAttibutes = MentalAttributes(
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
            physicalAttibutes = PhysicalAttributes(30, 31, 32, 33, 34, 35, 36, 37)
        ),
        Player(
            name = "Neto Volpi",
            age = 34,
            height = "1.89m",
            weight = "79kg",
            positions = "GR",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
        Player(
            name = "Young",
            age = 25,
            height = "2.02m",
            weight = "86kg",
            positions = "GR",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
        Player(
            name = "Antônio Carlos",
            age = 20,
            height = "1.96m",
            weight = "84kg",
            positions = "GR",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
        Player(
            name = "Joaquín Novillo",
            age = 29,
            height = "1.90m",
            weight = "89kg",
            positions = "D(C)",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
        Player(
            name = "Ian Rasso",
            age = 26,
            height = "1.81m",
            weight = "74kg",
            positions = "D(C)",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
        Player(
            name = "Mezenga",
            age = 25,
            height = "1.85m",
            weight = "75kg",
            positions = "D(C)",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
        Player(
            name = "Bruno Rodrigues",
            age = 30,
            height = "1.77m",
            weight = "72kg",
            positions = "M(E),MO(DE),PL(C)",
            technicalAttibutes = null,
            goalkeeperAttibutes = null,
            mentalAttibutes = null,
            physicalAttibutes = null
        ),
    )

    fun savePlayers() {
        players.forEach {
            repository.save(it)
        }
    }

    fun getPlayerList(): List<Player> {
        return repository.getAll()
    }
}