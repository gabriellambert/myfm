package com.example.myfm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myfm.repository.room.converter.Converters
import com.example.myfm.repository.sqlite.COLUMN_ID
import com.example.myfm.repository.sqlite.TABLE_PLAYER

@Entity(tableName = TABLE_PLAYER)
data class Player(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long = 0,
    var name: String = "",
    var age: Int = 1,
    var height: String = "",
    var weight: String = "",
    var positions: String = "",
    @TypeConverters(Converters::class)
    var technicalAttibutes: TechnicalAttributes?,
    @TypeConverters(Converters::class)
    var goalkeeperAttibutes: GoalkeeperAttributes?,
    @TypeConverters(Converters::class)
    var mentalAttibutes: MentalAttributes?,
    @TypeConverters(Converters::class)
    var physicalAttibutes: PhysicalAttributes?,
)
