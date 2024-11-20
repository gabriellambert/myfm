package com.gapps.player_center.tabs

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gapps.player_center.tabs.ui.attributes.AttributesFragment
import com.gapps.player_center.tabs.ui.statistics.StatisticsFragment
import com.gapps.player_center.tabs.ui.suggestion.SuggestionFragment
import com.gapps.player_center_data.repository.model.PlayerVO

internal class PlayerTabAdapter(
    appCompatActivity: AppCompatActivity,
    internal val tabs: List<PlayerTabType>,
    private val player: PlayerVO
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
