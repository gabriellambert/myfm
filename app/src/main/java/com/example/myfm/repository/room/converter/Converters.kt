package com.example.myfm.repository.room.converter

import androidx.room.TypeConverter
import com.example.myfm.model.GoalkeeperAttributes
import com.example.myfm.model.MentalAttributes
import com.example.myfm.model.PhysicalAttributes
import com.example.myfm.model.TechnicalAttributes
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun fromTechnicalAttributesToJSON(list: TechnicalAttributes): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoTechnicalAttributes(json: String): TechnicalAttributes {
        return Gson().fromJson(json, TechnicalAttributes::class.java)
    }

    @TypeConverter
    fun fromGoalkeeperAttributesToJSON(list: GoalkeeperAttributes): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoGoalkeeperAttributes(json: String): GoalkeeperAttributes {
        return Gson().fromJson(json, GoalkeeperAttributes::class.java)
    }

    @TypeConverter
    fun fromMentalAttributesToJSON(list: MentalAttributes): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoMentalAttributes(json: String): MentalAttributes {
        return Gson().fromJson(json, MentalAttributes::class.java)
    }

    @TypeConverter
    fun fromPhysicalAttributesToJSON(list: PhysicalAttributes): String =
        Gson().toJson(list)

    @TypeConverter
    fun fromJSONtoPhysicalAttributes(json: String): PhysicalAttributes {
        return Gson().fromJson(json, PhysicalAttributes::class.java)
    }
}
