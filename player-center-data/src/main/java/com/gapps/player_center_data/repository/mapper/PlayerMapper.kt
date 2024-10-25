package com.gapps.player_center_data.repository.mapper

import com.gapps.player_center_data.repository.model.GoalkeeperAttributesData
import com.gapps.player_center_data.repository.model.GoalkeeperAttributesVO
import com.gapps.player_center_data.repository.model.MentalAttributesData
import com.gapps.player_center_data.repository.model.MentalAttributesVO
import com.gapps.player_center_data.repository.model.PhysicalAttributesData
import com.gapps.player_center_data.repository.model.PhysicalAttributesVO
import com.gapps.player_center_data.repository.model.PlayerData
import com.gapps.player_center_data.repository.model.PlayerVO
import com.gapps.player_center_data.repository.model.TechnicalAttributesData
import com.gapps.player_center_data.repository.model.TechnicalAttributesVO

object PlayerMapper {

    fun mapSinglePlayer(playerData: PlayerData): PlayerVO {
        return PlayerVO(
            id = playerData.id,
            name = playerData.name,
            age = playerData.age,
            height = playerData.height,
            weight = playerData.weight,
            positions = playerData.positions,
            secondaryPositions = playerData.secondaryPositions,
            nationality = playerData.nationality,
            technicalAttibutes = mapTechnicalAttributes(playerData.technicalAttibutes),
            goalkeeperAttibutes = mapGoalkeeperAttributes(playerData.goalkeeperAttibutes),
            mentalAttibutes = mapMentalAttributes(playerData.mentalAttibutes),
            physicalAttibutes = mapPhysicalAttributes(playerData.physicalAttibutes)
        )
    }

    fun mapToPlayerModel(result: List<PlayerData>): List<PlayerVO> {
        val mappedPlayers = mutableListOf<PlayerVO>()

        result.forEach {
            val player = PlayerVO(
                id = it.id,
                name = it.name,
                age = it.age,
                height = it.height,
                weight = it.weight,
                positions = it.positions,
                secondaryPositions = it.secondaryPositions,
                nationality = it.nationality,
                technicalAttibutes = mapTechnicalAttributes(it.technicalAttibutes),
                goalkeeperAttibutes = mapGoalkeeperAttributes(it.goalkeeperAttibutes),
                mentalAttibutes = mapMentalAttributes(it.mentalAttibutes),
                physicalAttibutes = mapPhysicalAttributes(it.physicalAttibutes)
            )

            mappedPlayers.add(player)
        }

        return mappedPlayers
    }

    private fun mapTechnicalAttributes(technicalAttibutesData: TechnicalAttributesData?): TechnicalAttributesVO {
        return TechnicalAttributesVO(
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

    private fun mapMentalAttributes(mentalAttributesData: MentalAttributesData?): MentalAttributesVO {
        return MentalAttributesVO(
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

    private fun mapPhysicalAttributes(physicalAttributesData: PhysicalAttributesData?): PhysicalAttributesVO {
        return PhysicalAttributesVO(
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

    private fun mapGoalkeeperAttributes(goalkeeperAttributesData: GoalkeeperAttributesData?): GoalkeeperAttributesVO {
        return GoalkeeperAttributesVO(
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

    fun mapToPlayerData(playerVO: PlayerVO): PlayerData {
        return PlayerData(
                id = playerVO.id,
                name = playerVO.name,
                age = playerVO.age,
                height = playerVO.height,
                weight = playerVO.weight,
                positions = playerVO.positions,
                secondaryPositions = playerVO.secondaryPositions,
                nationality = playerVO.nationality,
                technicalAttibutes = mapTechnicalAttributesToData(playerVO.technicalAttibutes),
                goalkeeperAttibutes = mapGoalkeeperAttributesToData(playerVO.goalkeeperAttibutes),
                mentalAttibutes = mapMentalAttributesToData(playerVO.mentalAttibutes),
                physicalAttibutes = mapPhysicalAttributesToData(playerVO.physicalAttibutes)
            )
    }

    private fun mapTechnicalAttributesToData(technicalAttibutesVO: TechnicalAttributesVO?): TechnicalAttributesData {
        return TechnicalAttributesData(
            corners = technicalAttibutesVO?.corners,
            crossing = technicalAttibutesVO?.crossing,
            dribbling = technicalAttibutesVO?.dribbling,
            finishing = technicalAttibutesVO?.finishing,
            firstTouch = technicalAttibutesVO?.firstTouch,
            freeKickTacking = technicalAttibutesVO?.freeKickTacking,
            heading = technicalAttibutesVO?.heading,
            longShots = technicalAttibutesVO?.longShots,
            longThrows = technicalAttibutesVO?.longThrows,
            marking = technicalAttibutesVO?.marking,
            passing = technicalAttibutesVO?.passing,
            penaltyTaking = technicalAttibutesVO?.penaltyTaking,
            tackling = technicalAttibutesVO?.tackling,
            technique = technicalAttibutesVO?.technique
        )
    }

    private fun mapMentalAttributesToData(mentalAttributesVO: MentalAttributesVO?): MentalAttributesData {
        return MentalAttributesData(
            aggression = mentalAttributesVO?.aggression,
            anticipation = mentalAttributesVO?.anticipation,
            bravery = mentalAttributesVO?.bravery,
            composure = mentalAttributesVO?.composure,
            concentration = mentalAttributesVO?.concentration,
            decisions = mentalAttributesVO?.decisions,
            determination = mentalAttributesVO?.determination,
            flair = mentalAttributesVO?.flair,
            leadership = mentalAttributesVO?.leadership,
            offTheBall = mentalAttributesVO?.offTheBall,
            positioning = mentalAttributesVO?.positioning,
            teamwork = mentalAttributesVO?.teamwork,
            vision = mentalAttributesVO?.vision,
            workRate = mentalAttributesVO?.workRate
        )
    }

    private fun mapPhysicalAttributesToData(physicalAttributesVO: PhysicalAttributesVO?): PhysicalAttributesData {
        return PhysicalAttributesData(
            acceleration = physicalAttributesVO?.acceleration,
            agility = physicalAttributesVO?.agility,
            balance = physicalAttributesVO?.balance,
            jumpingReach = physicalAttributesVO?.jumpingReach,
            naturalFitness = physicalAttributesVO?.naturalFitness,
            pace = physicalAttributesVO?.pace,
            stamina = physicalAttributesVO?.stamina,
            strenght = physicalAttributesVO?.strenght,
        )
    }

    private fun mapGoalkeeperAttributesToData(goalkeeperAttributesVO: GoalkeeperAttributesVO?): GoalkeeperAttributesData {
        return GoalkeeperAttributesData(
            aerialReach = goalkeeperAttributesVO?.aerialReach,
            commandOfArea = goalkeeperAttributesVO?.commandOfArea,
            communication = goalkeeperAttributesVO?.communication,
            eccentricity = goalkeeperAttributesVO?.eccentricity,
            firstTouch = goalkeeperAttributesVO?.firstTouch,
            handling = goalkeeperAttributesVO?.handling,
            kicking = goalkeeperAttributesVO?.kicking,
            oneOnOnes = goalkeeperAttributesVO?.oneOnOnes,
            passing = goalkeeperAttributesVO?.passing,
            punching = goalkeeperAttributesVO?.punching,
            reflexes = goalkeeperAttributesVO?.reflexes,
            rushingOut = goalkeeperAttributesVO?.rushingOut,
            throwing = goalkeeperAttributesVO?.throwing,
        )
    }
}
