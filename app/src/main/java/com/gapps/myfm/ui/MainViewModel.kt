package com.gapps.myfm.ui

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.gapps.player_center_data.repository.domain.usecase.PlayerUseCase
import com.gapps.player_center_data.repository.model.GoalkeeperAttributesVO
import com.gapps.player_center_data.repository.model.MentalAttributesVO
import com.gapps.player_center_data.repository.model.PhysicalAttributesVO
import com.gapps.player_center_data.repository.model.PlayerVO
import com.gapps.player_center_data.repository.model.TechnicalAttributesVO
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainViewModel(
    private val playerUseCase: PlayerUseCase
) : ViewModel() {

    private val players = mutableListOf<PlayerVO>()

    @Throws(IOException::class)
    fun readTextFromUri(uri: Uri, applicationContext: Context) {
        try {
            val stringBuilder = StringBuilder()
            applicationContext.contentResolver.openInputStream(uri)?.use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line: String? = reader.readLine()
                    while (line != null) {
                        if (line.isNotBlank()) {
                            stringBuilder.appendLine(line)
                        }
                        line = reader.readLine()
                    }
                }
            }
            convertFileToPlayers(stringBuilder.toString())
        } catch (e: Exception) {
            println("Error reading the TXT file: ${e.message}")
        }
    }

    private fun convertFileToPlayers(tableText: String) {

        val rows = tableText.split("\n").map { it.trim() }
        var headers = rows[0].split("|").filter { it.isNotBlank() }.map { it.trim() }
        headers = renameDuplicateImpAttribute(headers.toMutableList())

        for (i in 2 until rows.size step 2) {
            val values = rows[i].split("|").filter { it.isNotBlank() }.map { it.trim() }
            val playerMap = headers.zip(values).toMap()

            val player = PlayerVO(
                name = playerMap["Nome"] ?: "",
                age = playerMap["Idade"]?.toIntOrNull() ?: 0,
                height = playerMap["Altura"] ?: "",
                weight = playerMap["Peso"] ?: "",
                positions = playerMap["Posição"] ?: "",
                secondaryPositions = playerMap["Posição Sec."] ?: "",
                nationality = playerMap["Nac"] ?: "",
                technicalAttibutes = TechnicalAttributesVO(
                    corners = playerMap["Cnt"]?.toIntOrNull() ?: 0,
                    crossing = playerMap["Cruz"]?.toIntOrNull() ?: 0,
                    dribbling = playerMap["Fnt"]?.toIntOrNull() ?: 0,
                    finishing = playerMap["Fnl"]?.toIntOrNull() ?: 0,
                    firstTouch = playerMap["Pri"]?.toIntOrNull() ?: 0,
                    freeKickTacking = playerMap["Liv"]?.toIntOrNull() ?: 0,
                    heading = playerMap["Cab"]?.toIntOrNull() ?: 0,
                    longShots = playerMap["Rem Lo"]?.toIntOrNull() ?: 0,
                    longThrows = playerMap["LnçL"]?.toIntOrNull() ?: 0,
                    marking = playerMap["Mar"]?.toIntOrNull() ?: 0,
                    passing = playerMap["Pas"]?.toIntOrNull() ?: 0,
                    penaltyTaking = playerMap["Pen"]?.toIntOrNull() ?: 0,
                    tackling = playerMap["Des"]?.toIntOrNull() ?: 0,
                    technique = playerMap["Téc"]?.toIntOrNull() ?: 0
                ),
                goalkeeperAttibutes = GoalkeeperAttributesVO(
                    aerialReach = playerMap["Aer"]?.toIntOrNull() ?: 0,
                    commandOfArea = playerMap["Cmd"]?.toIntOrNull() ?: 0,
                    communication = playerMap["Com"]?.toIntOrNull() ?: 0,
                    eccentricity = playerMap["Exc"]?.toIntOrNull() ?: 0,
                    firstTouch = playerMap["Pri"]?.toIntOrNull() ?: 0,
                    handling = playerMap["Jg Mãos"]?.toIntOrNull() ?: 0,
                    kicking = playerMap["Pont"]?.toIntOrNull() ?: 0,
                    oneOnOnes = playerMap["1x1"]?.toIntOrNull() ?: 0,
                    passing = playerMap["Pas"]?.toIntOrNull() ?: 0,
                    punching = playerMap["Soc"]?.toIntOrNull() ?: 0,
                    reflexes = playerMap["Ref"]?.toIntOrNull() ?: 0,
                    rushingOut = playerMap["TSB"]?.toIntOrNull() ?: 0,
                    throwing = playerMap["Lan"]?.toIntOrNull() ?: 0
                ),
                mentalAttibutes = MentalAttributesVO(
                    aggression = playerMap["Agr"]?.toIntOrNull() ?: 0,
                    anticipation = playerMap["Ant"]?.toIntOrNull() ?: 0,
                    bravery = playerMap["Bra"]?.toIntOrNull() ?: 0,
                    composure = playerMap["Cmp"]?.toIntOrNull() ?: 0,
                    concentration = playerMap["Cnc"]?.toIntOrNull() ?: 0,
                    decisions = playerMap["Decis"]?.toIntOrNull() ?: 0,
                    determination = playerMap["Det"]?.toIntOrNull() ?: 0,
                    flair = playerMap["Impr"]?.toIntOrNull() ?: 0,
                    leadership = playerMap["Lid"]?.toIntOrNull() ?: 0,
                    offTheBall = playerMap["SB"]?.toIntOrNull() ?: 0,
                    positioning = playerMap["Pos"]?.toIntOrNull() ?: 0,
                    teamwork = playerMap["Tr Eq"]?.toIntOrNull() ?: 0,
                    vision = playerMap["Vis"]?.toIntOrNull() ?: 0,
                    workRate = playerMap["In Tr"]?.toIntOrNull() ?: 0
                ),
                physicalAttibutes = PhysicalAttributesVO(
                    acceleration = playerMap["Acl"]?.toIntOrNull() ?: 0,
                    agility = playerMap["Agi"]?.toIntOrNull() ?: 0,
                    balance = playerMap["Eql"]?.toIntOrNull() ?: 0,
                    jumpingReach = playerMap["Imp"]?.toIntOrNull() ?: 0,
                    naturalFitness = playerMap["AF"]?.toIntOrNull() ?: 0,
                    pace = playerMap["Vel"]?.toIntOrNull() ?: 0,
                    stamina = playerMap["Res"]?.toIntOrNull() ?: 0,
                    strenght = playerMap["For"]?.toIntOrNull() ?: 0
                )
            )

            players.add(player)
        }

        savePlayers()
    }

    private fun renameDuplicateImpAttribute(headers: MutableList<String>): List<String> {
        //encontra o primeiro "Imp" e altera para "Impr" para que os atributos não fiquem duplicados"
        var found = false
        headers.forEachIndexed { index, header ->
            if (header == "Imp" && !found) {
                headers[index] = "Impr"
                found = true
            }
        }

        return headers
    }

    private fun savePlayers() {
        players.forEach {
            playerUseCase.save(it)
        }
    }

    fun deletePlayers() {
        //ajustar para remover todos os players
        players.forEach {
            playerUseCase.delete(it)
        }
    }

    fun getPlayerList(): List<PlayerVO> {
        return playerUseCase.getAll()
    }
}
