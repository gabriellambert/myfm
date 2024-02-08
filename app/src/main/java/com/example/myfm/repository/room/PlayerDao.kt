package com.example.myfm.repository.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myfm.model.Player
import com.example.myfm.repository.sqlite.COLUMN_ID
import com.example.myfm.repository.sqlite.TABLE_PLAYER

@Dao
interface PlayerDao {
    @Query("SELECT * FROM $TABLE_PLAYER")
    fun getAll(): List<Player>

    @Query("SELECT * FROM $TABLE_PLAYER WHERE $COLUMN_ID = :id")
    fun playerById(id: Long): Player

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(player: Player): Long

    @Delete
    fun delete(player: Player)

    @Update
    fun update(player: Player): Int
}