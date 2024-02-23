package com.example.myfm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfm.adapter.PlayersListAdapter
import com.example.myfm.databinding.ActivityMainBinding
import com.example.myfm.ui.MainViewModel
import com.example.player_center.PlayerActivity
import com.example.player_center.model.Player
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        setListeners()
    }

    private fun initRecyclerView() {
        with(binding.recyclerViewPlayersList) {
            this.setHasFixedSize(true)
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        binding.recyclerViewPlayersList.adapter =
            PlayersListAdapter(this, viewModel.getPlayerList(), this::onPlayerItemClick)
    }

    private fun setListeners() {
        with(binding) {
            this.addButton.setOnClickListener {
                viewModel.savePlayers()
            }
            this.deleteButton.setOnClickListener {
                viewModel.deletePlayers()
            }
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