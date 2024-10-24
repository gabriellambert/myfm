package com.gapps.player_center

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.player_center.R
import com.example.player_center.databinding.ActivityPlayerBinding
import com.gapps.player_center.tabs.PlayerTabAdapter
import com.gapps.player_center.tabs.PlayerTabType
import com.gapps.player_center_data.repository.model.PlayerVO
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerActivity : AppCompatActivity() {

    private val playerId: Long by lazy {
        intent.getLongExtra(PLAYER_ID, -1)
    }

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var playerTabAdapter: PlayerTabAdapter
    private lateinit var player: PlayerVO

    private val viewModel: PlayerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        val player = viewModel.getPlayerById(playerId)
        this.player = player

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

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

    private fun setContent(player: PlayerVO) {
        binding.playerName.text = player.name
        binding.playerHeightWeight.text = getString(
            R.string.player_height_weight,
            player.height,
            player.weight
        )
        binding.playerNationalityAndAge.text = getString(
            R.string.player_nationality_and_age,
            player.nationality,
            player.age.toString()
        )
    }

    private fun setPlayerTabs() {
        val tabs = PlayerTabType.entries.toTypedArray()

        playerTabAdapter = PlayerTabAdapter(this, tabs.toList(), player)

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