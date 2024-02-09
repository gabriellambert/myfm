package com.example.player_center.tabs

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.player_center.tabs.ui.dashboard.DashboardFragment
import com.example.player_center.tabs.ui.attributes.AttributesFragment
import com.example.player_center.tabs.ui.notifications.NotificationsFragment

internal class PlayerTabAdapter(
    appCompatActivity: AppCompatActivity,
    internal val tabs: List<PlayerTabType>
) : FragmentStateAdapter(appCompatActivity) {
    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (tabs[position]) {
            PlayerTabType.ATTRIBUTES -> AttributesFragment()
            PlayerTabType.STATISTICS -> DashboardFragment()
            PlayerTabType.SUGGESTION -> NotificationsFragment()
        }
    }
}
