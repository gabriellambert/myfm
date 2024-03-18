package com.gapps.myfm

import androidx.recyclerview.widget.RecyclerView
import com.gapps.myfm.databinding.PlayerListItemBinding
import com.gapps.player_center.model.Player

class PlayersListViewHolder(
    private val binding: PlayerListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {
        binding.nameText.text = player.name
        binding.positionText.text = getFirstPosition(player.positions)
    }

    private fun getFirstPosition(positions: String?): String {
        return positions?.split(",")?.get(0) ?: "-"
    }
}