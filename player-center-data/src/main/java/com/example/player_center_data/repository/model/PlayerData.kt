package com.example.player_center_data.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = com.example.player_center_data.repository.sqlite.TABLE_PLAYER)
data class PlayerData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = com.example.player_center_data.repository.sqlite.COLUMN_ID)
    var id: Long = 0,
    var name: String = "",
    var age: Int = 1,
    var height: String = "",
    var weight: String = "",
    var positions: String = "",
    @TypeConverters(com.example.player_center_data.repository.room.converter.Converters::class)
    var technicalAttibutes: TechnicalAttributesData?,
    @TypeConverters(com.example.player_center_data.repository.room.converter.Converters::class)
    var goalkeeperAttibutes: GoalkeeperAttributesData?,
    @TypeConverters(com.example.player_center_data.repository.room.converter.Converters::class)
    var mentalAttibutes: MentalAttributesData?,
    @TypeConverters(com.example.player_center_data.repository.room.converter.Converters::class)
    var physicalAttibutes: PhysicalAttributesData?,
)
