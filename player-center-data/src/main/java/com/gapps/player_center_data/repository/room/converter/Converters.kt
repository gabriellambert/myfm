package com.gapps.player_center_data.repository.room.converter

import androidx.room.TypeConverter
import com.gapps.player_center_data.repository.model.GoalkeeperAttributesData
import com.gapps.player_center_data.repository.model.MentalAttributesData
import com.gapps.player_center_data.repository.model.PhysicalAttributesData
import com.gapps.player_center_data.repository.model.TechnicalAttributesData
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun fromTechnicalAttributesToJSON(list: TechnicalAttributesData): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoTechnicalAttributes(json: String): TechnicalAttributesData {
        return Gson().fromJson(json, TechnicalAttributesData::class.java)
    }

    @TypeConverter
    fun fromGoalkeeperAttributesToJSON(list: GoalkeeperAttributesData): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoGoalkeeperAttributes(json: String): GoalkeeperAttributesData {
        return Gson().fromJson(json, GoalkeeperAttributesData::class.java)
    }

    @TypeConverter
    fun fromMentalAttributesToJSON(list: MentalAttributesData): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoMentalAttributes(json: String): MentalAttributesData {
        return Gson().fromJson(json, MentalAttributesData::class.java)
    }

    @TypeConverter
    fun fromPhysicalAttributesToJSON(list: PhysicalAttributesData): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoPhysicalAttributes(json: String): PhysicalAttributesData {
        return Gson().fromJson(json, PhysicalAttributesData::class.java)
    }
}
