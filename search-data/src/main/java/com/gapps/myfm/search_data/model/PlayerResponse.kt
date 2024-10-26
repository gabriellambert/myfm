package com.gapps.myfm.search_data.model

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @field:SerializedName("playerId") val playerId: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("age") val age: String,
    @field:SerializedName("currentAbility") val currentAbility: String,
    @field:SerializedName("potentialAbility") val potentialAbility: String,
    @field:SerializedName("minPotentialAbility") val minPotentialAbility: String,
    @field:SerializedName("maxPotentialAbility") val maxPotentialAbility: String,
    @field:SerializedName("club") val club: String,
    @field:SerializedName("nationalities") val nationalities: List<String>,
    @field:SerializedName("positions") val positions: List<String>,
    @field:SerializedName("askingPrice") val askingPrice: String,
    @field:SerializedName("contractLength") val contractLength: String,
    @field:SerializedName("personality") val personality: String,
    @field:SerializedName("searchString") val searchString: String,
    @field:SerializedName("reputation") val reputation: Int,
    @field:SerializedName("attributes") val attributes: List<AttributeResponse>,
)

data class AttributeResponse(
    @field:SerializedName("technicals") val technicals: List<TechnicalAttributeResponse>,
    @field:SerializedName("mentals") val mentals: List<MentalAttributeResponse>,
    @field:SerializedName("physicals") val physicals: List<PhysicalAttributeResponse>,
    @field:SerializedName("goalkeeping") val goalkeeping: List<GoalkeepingAttributeResponse>,
    @field:SerializedName("hidden") val hidden: List<HiddenAttributeResponse>,
)

data class TechnicalAttributeResponse(
    val corners: Int?,
    val crossing: Int?,
    val dribbling: Int?,
    val finishing: Int?,
    val firstTouch: Int?,
    val freeKickTacking: Int?,
    val heading: Int?,
    val longShots: Int?,
    val longThrows: Int?,
    val marking: Int?,
    val passing: Int?,
    val penaltyTaking: Int?,
    val tackling: Int?,
    val technique: Int?
)

data class MentalAttributeResponse(
    val aggression: Int?,
    val anticipation: Int?,
    val bravery: Int?,
    val composure: Int?,
    val concentration: Int?,
    val decisions: Int?,
    val determination: Int?,
    val flair: Int?,
    val leadership: Int?,
    val offTheBall: Int?,
    val positioning: Int?,
    val teamwork: Int?,
    val vision: Int?,
    val workRate: Int?,
)

data class PhysicalAttributeResponse(
    val acceleration: Int?,
    val agility: Int?,
    val balance: Int?,
    val jumpingReach: Int?,
    val naturalFitness: Int?,
    val pace: Int?,
    val stamina: Int?,
    val strenght: Int?,
)

data class GoalkeepingAttributeResponse(
    val aerialReach: Int?,
    val commandOfArea: Int?,
    val communication: Int?,
    val eccentricity: Int?,
    val firstTouch: Int?,
    val handling: Int?,
    val kicking: Int?,
    val oneOnOnes: Int?,
    val passing: Int?,
    val punching: Int?,
    val reflexes: Int?,
    val rushingOut: Int?,
    val throwing: Int?,
)

data class HiddenAttributeResponse(
    val adaptability: Int?,
    val controversy: Int?,
    val consistency: Int?,
    val ambition: Int?,
    val versatility: Int?,
    val temperament: Int?,
    val sportsmanship: Int?,
    val professionalism: Int?,
    val pressure: Int?,
    val loyalty: Int?,
    val injuryProneness: Int?,
    val importantMatches: Int?,
    val dirtiness: Int?,
)
