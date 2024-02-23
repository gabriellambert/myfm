package com.example.player_center_data.repository.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.player_center_data.repository.model.PlayerData
import com.example.player_center_data.repository.sqlite.COLUMN_ID
import com.example.player_center_data.repository.sqlite.TABLE_PLAYER

@Dao
interface PlayerDao {
    @Query("SELECT * FROM $TABLE_PLAYER")
    fun getAll(): List<PlayerData>

    @Query("SELECT * FROM $TABLE_PLAYER WHERE $COLUMN_ID = :id")
    fun playerById(id: Long): PlayerData

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(player: PlayerData): Long

    @Delete
    fun delete(player: PlayerData)

    @Update
    fun update(player: PlayerData): Int
}