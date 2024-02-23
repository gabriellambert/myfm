package com.example.player_center.tabs

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.player_center.model.Player
import com.example.player_center.tabs.ui.statistics.StatisticsFragment
import com.example.player_center.tabs.ui.attributes.AttributesFragment
import com.example.player_center.tabs.ui.suggestion.SuggestionFragment

internal class PlayerTabAdapter(
    appCompatActivity: AppCompatActivity,
    internal val tabs: List<PlayerTabType>,
    private val player: Player
) : FragmentStateAdapter(appCompatActivity) {
    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (tabs[position]) {
            PlayerTabType.ATTRIBUTES -> AttributesFragment.newInstance(player)
            PlayerTabType.STATISTICS -> StatisticsFragment()
            PlayerTabType.SUGGESTION -> SuggestionFragment()
        }
    }
}
