package com.gapps.player_center_data.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.gapps.player_center_data.repository.room.converter.Converters
import com.gapps.player_center_data.repository.sqlite.COLUMN_ID
import com.gapps.player_center_data.repository.sqlite.TABLE_PLAYER

@Entity(tableName = TABLE_PLAYER)
data class PlayerData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long = 0,
    var name: String = "",
    var age: Int = 1,
    var height: String = "",
    var weight: String = "",
    var positions: String = "",
    var secondaryPositions: String = "",
    var nationality: String = "",
    @TypeConverters(Converters::class)
    var technicalAttibutes: TechnicalAttributesData?,
    @TypeConverters(Converters::class)
    var goalkeeperAttibutes: GoalkeeperAttributesData?,
    @TypeConverters(Converters::class)
    var mentalAttibutes: MentalAttributesData?,
    @TypeConverters(Converters::class)
    var physicalAttibutes: PhysicalAttributesData?,
)
