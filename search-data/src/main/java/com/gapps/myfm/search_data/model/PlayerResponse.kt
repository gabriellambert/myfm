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
    @field:SerializedName("attributes") val attributes: AttributeResponse,
)

data class AttributeResponse(
    @field:SerializedName("technicals") val technicals: TechnicalAttributeResponse,
    @field:SerializedName("mentals") val mentals: MentalAttributeResponse,
    @field:SerializedName("physicals") val physicals: PhysicalAttributeResponse,
    @field:SerializedName("goalkeeping") val goalkeeping: GoalkeepingAttributeResponse,
    @field:SerializedName("hidden") val hidden: HiddenAttributeResponse,
)

data class TechnicalAttributeResponse(
    val crossing: Int?,
    val corners: Int?,
    val firstTouch: Int?,
    val finishing: Int?,
    val dribbling: Int?,
    val heading: Int?,
    val freekicks: Int?,
    val marking: Int?,
    val longThrow: Int?,
    val longshots: Int?,
    val passing: Int?,
    val penalties: Int?,
    val tackling: Int?,
    val technique: Int?
)

data class MentalAttributeResponse(
    val workrate: Int?,
    val vision: Int?,
    val teamwork: Int?,
    val positioning: Int?,
    val offTheBall: Int?,
    val leadership: Int?,
    val flair: Int?,
    val determination: Int?,
    val decisions: Int?,
    val concentration: Int?,
    val composure: Int?,
    val bravery: Int?,
    val anticipation: Int?,
    val aggression: Int?
)

data class PhysicalAttributeResponse(
    val acceleration: Int?,
    val agility: Int?,
    val balance: Int?,
    val jumpingReach: Int?,
    val naturalFitness: Int?,
    val pace: Int?,
    val strength: Int?,
    val stamina: Int?
)

data class GoalkeepingAttributeResponse(
    val aerialReach: Int?,
    val communication: Int?,
    val commandOfArea: Int?,
    val eccentricity: Int?,
    val handling: Int?,
    val kicking: Int?,
    val oneVSOne: Int?,
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
