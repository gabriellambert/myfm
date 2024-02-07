package com.example.myfm.repository

import androidx.lifecycle.LiveData
import com.example.myfm.model.Player

interface PlayerRepository {

    fun getAll(): List<Player>

    fun playerById(id: Long): List<Player>

    fun save(player: Player)

    fun delete(player: Player)
}