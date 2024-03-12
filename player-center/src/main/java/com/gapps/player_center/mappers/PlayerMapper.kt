package com.gapps.player_center.mappers

import com.gapps.player_center.model.attributes.GoalkeeperAttributes
import com.gapps.player_center.model.attributes.MentalAttributes
import com.gapps.player_center.model.attributes.PhysicalAttributes
import com.gapps.player_center.model.Player
import com.gapps.player_center.model.positions.OldPosition
import com.gapps.player_center.model.positions.OldPositions
import com.gapps.player_center.model.attributes.TechnicalAttributes
import com.gapps.player_center.model.positions.Position
import com.gapps.player_center.model.positions.Positions
import com.gapps.player_center_data.repository.model.GoalkeeperAttributesData
import com.gapps.player_center_data.repository.model.MentalAttributesData
import com.gapps.player_center_data.repository.model.PhysicalAttributesData
import com.gapps.player_center_data.repository.model.PlayerData
import com.gapps.player_center_data.repository.model.TechnicalAttributesData

object PlayerMapper {

    fun mapSinglePlayer(playerData: PlayerData): Player {
        return Player(
            id = playerData.id,
            name = playerData.name,
            age = playerData.age,
            height = playerData.height,
            weight = playerData.weight,
            positions = mapPositions(playerData.positions),
            technicalAttibutes = mapTechnicalAttributes(playerData.technicalAttibutes),
            goalkeeperAttibutes = mapGoalkeeperAttributes(playerData.goalkeeperAttibutes),
            mentalAttibutes = mapMentalAttributes(playerData.mentalAttibutes),
            physicalAttibutes = mapPhysicalAttributes(playerData.physicalAttibutes)
        )
    }

    fun mapToPlayerModel(result: List<PlayerData>): List<Player> {
        val mappedPlayers = mutableListOf<Player>()

        result.forEach {
            val player = Player(
                id = it.id,
                name = it.name,
                age = it.age,
                height = it.height,
                weight = it.weight,
                positions = mapPositions(it.positions),
                technicalAttibutes = mapTechnicalAttributes(it.technicalAttibutes),
                goalkeeperAttibutes = mapGoalkeeperAttributes(it.goalkeeperAttibutes),
                mentalAttibutes = mapMentalAttributes(it.mentalAttibutes),
                physicalAttibutes = mapPhysicalAttributes(it.physicalAttibutes)
            )

            mappedPlayers.add(player)
        }

        return mappedPlayers
    }

    private fun mapPositions(positions: String): List<Position> {
        val listPositions = mutableListOf<Position>()
        val mappedPositions = positions.split(", ")

        mappedPositions.forEach { mappedAbrev ->
            Positions.entries.find {
                it.portugueseAbrev.lowercase() == mappedAbrev.lowercase()
            }?.apply {
                listPositions.add(
                    Position(
                        portugueseAbrev = mappedAbrev,
                        value = this.value,
                        roles = this.roles,
                    )
                )
            }
        }

        return listPositions
    }

    private fun mapTechnicalAttributes(technicalAttibutesData: TechnicalAttributesData?): TechnicalAttributes {
        return TechnicalAttributes(
            corners = technicalAttibutesData?.corners,
            crossing = technicalAttibutesData?.crossing,
            dribbling = technicalAttibutesData?.dribbling,
            finishing = technicalAttibutesData?.finishing,
            firstTouch = technicalAttibutesData?.firstTouch,
            freeKickTacking = technicalAttibutesData?.freeKickTacking,
            heading = technicalAttibutesData?.heading,
            longShots = technicalAttibutesData?.longShots,
            longThrows = technicalAttibutesData?.longThrows,
            marking = technicalAttibutesData?.marking,
            passing = technicalAttibutesData?.passing,
            penaltyTaking = technicalAttibutesData?.penaltyTaking,
            tackling = technicalAttibutesData?.tackling,
            technique = technicalAttibutesData?.technique
        )
    }

    private fun mapMentalAttributes(mentalAttributesData: MentalAttributesData?): MentalAttributes {
        return MentalAttributes(
            aggression = mentalAttributesData?.aggression,
            anticipation = mentalAttributesData?.anticipation,
            bravery = mentalAttributesData?.bravery,
            composure = mentalAttributesData?.composure,
            concentration = mentalAttributesData?.concentration,
            decisions = mentalAttributesData?.decisions,
            determination = mentalAttributesData?.determination,
            flair = mentalAttributesData?.flair,
            leadership = mentalAttributesData?.leadership,
            offTheBall = mentalAttributesData?.offTheBall,
            positioning = mentalAttributesData?.positioning,
            teamwork = mentalAttributesData?.teamwork,
            vision = mentalAttributesData?.vision,
            workRate = mentalAttributesData?.workRate
        )
    }

    private fun mapPhysicalAttributes(physicalAttributesData: PhysicalAttributesData?): PhysicalAttributes {
        return PhysicalAttributes(
            acceleration = physicalAttributesData?.acceleration,
            agility = physicalAttributesData?.agility,
            balance = physicalAttributesData?.balance,
            jumpingReach = physicalAttributesData?.jumpingReach,
            naturalFitness = physicalAttributesData?.naturalFitness,
            pace = physicalAttributesData?.pace,
            stamina = physicalAttributesData?.stamina,
            strenght = physicalAttributesData?.strenght,
        )
    }

    private fun mapGoalkeeperAttributes(goalkeeperAttributesData: GoalkeeperAttributesData?): GoalkeeperAttributes {
        return GoalkeeperAttributes(
            aerialReach = goalkeeperAttributesData?.aerialReach,
            commandOfArea = goalkeeperAttributesData?.commandOfArea,
            communication = goalkeeperAttributesData?.communication,
            eccentricity = goalkeeperAttributesData?.eccentricity,
            firstTouch = goalkeeperAttributesData?.firstTouch,
            handling = goalkeeperAttributesData?.handling,
            kicking = goalkeeperAttributesData?.kicking,
            oneOnOnes = goalkeeperAttributesData?.oneOnOnes,
            passing = goalkeeperAttributesData?.passing,
            punching = goalkeeperAttributesData?.punching,
            reflexes = goalkeeperAttributesData?.reflexes,
            rushingOut = goalkeeperAttributesData?.rushingOut,
            throwing = goalkeeperAttributesData?.throwing,
        )
    }
}