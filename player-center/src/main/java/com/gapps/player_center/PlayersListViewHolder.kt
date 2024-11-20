package com.gapps.player_center

import androidx.recyclerview.widget.RecyclerView
import com.example.player_center.databinding.PlayerListItemBinding
import com.gapps.player_center_data.repository.model.PlayerVO

class PlayersListViewHolder(
    private val binding: PlayerListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(player: PlayerVO) {
        binding.nameText.text = player.name
        binding.positionText.text = getFirstPosition(player.positions)
    }

    private fun getFirstPosition(positions: String?): String {
        return positions?.split(",")?.get(0) ?: "-"
    }
}
