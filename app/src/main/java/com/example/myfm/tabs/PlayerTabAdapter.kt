package com.example.myfm.tabs

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfm.ui.ui.dashboard.DashboardFragment
import com.example.myfm.ui.ui.attributes.AttributesFragment
import com.example.myfm.ui.ui.notifications.NotificationsFragment

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
