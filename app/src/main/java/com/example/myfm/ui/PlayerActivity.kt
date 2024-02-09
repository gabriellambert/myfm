package com.example.myfm.ui

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.appcompat.app.AppCompatActivity
import com.example.myfm.PlayerViewModel
import com.example.myfm.R
import com.example.myfm.databinding.ActivityPlayerBinding
import com.example.myfm.model.Player
import com.example.myfm.tabs.PlayerTabAdapter
import com.example.myfm.tabs.PlayerTabType
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PlayerActivity : AppCompatActivity() {

    private val playerId: Long by lazy {
        intent.getLongExtra(PLAYER_ID, -1)
    }

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var playerTabAdapter: PlayerTabAdapter

    private val viewModel: PlayerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = viewModel.getPlayerById(playerId)
        setContent(player)
        setPlayerTabs()


//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_player)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setContent(player: Player) {
        binding.playerName.text = player.name
        binding.playerHeightWeight.text = getString(
            R.string.player_height_weight,
            player.height,
            player.weight
        )
        binding.playerNationalityAndAge.text = getString(
            R.string.player_nationality_and_age,
            player.age.toString()
        )
    }

    private fun setPlayerTabs() {
        val tabs = PlayerTabType.values()

        playerTabAdapter = PlayerTabAdapter(this, tabs.toList())

        configurePlayerTabs()
    }

    private fun configurePlayerTabs() {
        with(binding.viewPager) {
            this.offscreenPageLimit = 3
            this.adapter = playerTabAdapter
        }

        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            tab.text = playerTabAdapter.tabs[position].title
        }.attach()
    }

    companion object {
        private const val PLAYER_ID = "PLAYER_ID"
    }
}