package com.example.myfm

import androidx.recyclerview.widget.RecyclerView
import com.example.myfm.databinding.PlayerListItemBinding
import com.example.player_center.model.Player

class PlayersListViewHolder(
    private val binding: PlayerListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player, position: Int) {
        binding.nameText.text = player.name
        binding.positionText.text = getFirstPosition(player.positions)
        binding.ageText.text = player.age.toString()
        if (position % 2 != 0) {
            binding.root.setBackgroundResource(R.drawable.ripple)
        }
    }

    private fun getFirstPosition(positions: String?): String {
        return positions?.split(",")?.get(0) ?: "-"
    }
}