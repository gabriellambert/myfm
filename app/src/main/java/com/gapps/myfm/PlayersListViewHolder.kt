package com.gapps.myfm

import androidx.recyclerview.widget.RecyclerView
import com.gapps.myfm.databinding.PlayerListItemBinding
import com.gapps.player_center.model.Player
import com.gapps.player_center.model.positions.Position

class PlayersListViewHolder(
    private val binding: PlayerListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {
        binding.nameText.text = player.name
        binding.positionText.text = getPositions(player.positions)
    }

    private fun getPositions(positions: List<Position>?): String {
        val newStrings = mutableListOf<String>()
        positions?.forEach {
            newStrings.add(it.portugueseAbrev)
        }
        return newStrings.joinToString()
    }
}