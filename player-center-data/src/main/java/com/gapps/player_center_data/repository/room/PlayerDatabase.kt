package com.gapps.player_center_data.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gapps.player_center_data.repository.model.PlayerData
import com.gapps.player_center_data.repository.room.converter.Converters
import com.gapps.player_center_data.repository.sqlite.DATABASE_NAME
import com.gapps.player_center_data.repository.sqlite.DATABASE_VERSION

@Database(entities = [PlayerData::class], version = DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class PlayerDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    companion object {
        private var instance: PlayerDatabase? = null

        fun getDatabase(context: Context): PlayerDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlayerDatabase::class.java,
                    DATABASE_NAME
                ).allowMainThreadQueries()
                    .build()
            }
            return instance as PlayerDatabase
        }

        fun destroyInstance() {
            instance = null
        }
    }
}
