package com.example.myfm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfm.adapter.PlayersListAdapter
import com.example.myfm.databinding.ActivityMainBinding
import com.example.myfm.model.Player
import com.example.myfm.ui.PlayerActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.InputStream
import java.io.ObjectInputStream
import java.util.Scanner

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val players = listOf(
        Player(
            name = "Augusto Batalla",
            age = 31,
            height = "1.85m",
            weight = "79kg",
            positions = "GR"
        ),
        Player(name = "Neto Volpi", age = 34, height = "1.89m", weight = "79kg", positions = "GR"),
        Player(name = "Young", age = 25, height = "2.02m", weight = "86kg", positions = "GR"),
        Player(name = "César", age = 21, height = "1.94m", weight = "85kg", positions = "GR"),
        Player(
            name = "Antônio Carlos",
            age = 20,
            height = "1.96m",
            weight = "84kg",
            positions = "GR"
        ),
        Player(
            name = "Paulo Eduardo",
            age = 19,
            height = "1.89m",
            weight = "77kg",
            positions = "GR"
        ),
        Player(
            name = "Danilo Bidias",
            age = 19,
            height = "1.97m",
            weight = "85kg",
            positions = "GR"
        ),
        Player(
            name = "Joaquín Novillo",
            age = 29,
            height = "1.90m",
            weight = "89kg",
            positions = "D(C)"
        ),
        Player(name = "Ian Rasso", age = 26, height = "1.81m", weight = "74kg", positions = "D(C)"),
        Player(name = "Mezenga", age = 25, height = "1.85m", weight = "75kg", positions = "D(C)"),
        Player(name="Bruno Rodrigues", age=30, height="1.77m", weight="72kg", positions="M(E),MO(DE),PL(C)"),
    )

    private val playersListAdapter = PlayersListAdapter(this, players, this::onPlayerItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding.recyclerViewPlayersList) {
            this.setHasFixedSize(true)
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = playersListAdapter
        }
    }

    private fun onPlayerItemClick(player: Player) {
        val intent = Intent(this, PlayerActivity::class.java).apply {
            putExtra(PLAYER_ID, player.id)
        }
        startActivity(intent)
    }

    companion object {
        private const val PLAYER_ID = "PLAYER_ID"
    }
}